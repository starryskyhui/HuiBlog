package com.starryskyhui.blog.controller;

import com.starryskyhui.blog.pojo.dto.ArticleCategoryDTO;
import com.starryskyhui.blog.pojo.dto.ArticleDTO;
import com.starryskyhui.blog.pojo.vo.ArticleVO;
import com.starryskyhui.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 郑国辉
 */
@RestController
public class ArticleController {
    private static final Integer DEFAULT_NUMBER = 1;
    private static final Integer DEFAULT_CATEGORY_ID=1;
    @Autowired
    ArticleService articleService;

    @PostMapping("/blog/edit")
    public int addArticle(@RequestBody ArticleVO articleVO) {
        ArticleDTO articleDTO = new ArticleDTO();

        articleDTO.setTitle(articleVO.getTitle());
        articleDTO.setContent(articleVO.getContent());
        List<ArticleCategoryDTO> allCategories = articleService.getAllCategory();
        List<String> categories = new ArrayList<>();
        Map<String, Integer> categoryIds = new HashMap<>();
        allCategories.forEach(e->{
            categories.add(e.getCategoryName());
            categoryIds.put(e.getCategoryName(), e.getCategoryId());
        });
        int category = 0;
        for (String e : articleVO.getCategoryName()) {
            ArticleCategoryDTO articleCategoryDTO = new ArticleCategoryDTO();
            articleCategoryDTO.setCategoryName(e);
            if (!categories.contains(e)) {
                articleCategoryDTO.setTotalNumber(DEFAULT_NUMBER);
                Integer categoryId = articleService.selectCategoryMax();
                if (categoryId == null) {
                    articleCategoryDTO.setCategoryId(DEFAULT_CATEGORY_ID);
                    category |= DEFAULT_CATEGORY_ID;
                } else if (categoryId << 1 == 0) {
                    return -1;
                } else {
                    articleCategoryDTO.setCategoryId(categoryId << 1);
                    category |= categoryId << 1;
                }
                articleService.insert(articleCategoryDTO);
            } else {
                articleCategoryDTO.setTotalNumber(articleService.selectByCategoryName(e).getTotalNumber()+1);
                articleService.update(articleCategoryDTO);
                category |= categoryIds.get(e);
            }
        }
        if (category != 0) {
            articleDTO.setCategoryId(category);
        }
        return articleService.insert(articleDTO);
    }

    @GetMapping("/blog/getLabels")
    public List<String> getAllLabel() {
        List<String> ans = new ArrayList<>();
        List<ArticleCategoryDTO> allCategory = articleService.getAllCategory();

        allCategory.forEach(e->ans.add(e.getCategoryName()));
        return ans;
    }

    @GetMapping("/blog/article/getAll")
    public List<ArticleVO> getAllArticles() {
        List<ArticleDTO> all = articleService.getAll();
        List<ArticleVO> res = new ArrayList<>();
        all.forEach(param->{
            ArticleVO articleVO = new ArticleVO();
            articleVO.setId(param.getId());
            articleVO.setTitle(param.getTitle());
            articleVO.setContent(param.getContent());
            res.add(articleVO);
        });

        return res;
    }

    @GetMapping("/blog/article/{id}")
    public ArticleVO getArticleById(@PathVariable("id") int articleID) {
        ArticleVO articleVO = new ArticleVO();
        ArticleDTO article = articleService.getArticle(articleID);
        articleVO.setTitle(article.getTitle());
        articleVO.setContent(article.getContent());

        int categoryId = article.getCategoryId();
        List<ArticleCategoryDTO> allCategories = articleService.getAllCategory();
        List<String> categories = new ArrayList<>();
        allCategories.forEach(e->{
            if ((e.getCategoryId() & categoryId) == e.getCategoryId()) {
                categories.add(e.getCategoryName());
            }
        });
        articleVO.setCategoryName(categories);

        return articleVO;
    }
}
