package com.starryskyhui.blog.service.Impl;

import com.starryskyhui.blog.dao.ArticleCategoryDAO;
import com.starryskyhui.blog.dao.ArticleDAO;
import com.starryskyhui.blog.pojo.dto.ArticleCategoryDTO;
import com.starryskyhui.blog.pojo.dto.ArticleDTO;
import com.starryskyhui.blog.pojo.entity.ArticleCategoryDO;
import com.starryskyhui.blog.pojo.entity.ArticleDO;
import com.starryskyhui.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 郑国辉
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleDAO articleDAO;

    @Autowired
    ArticleCategoryDAO articleCategoryDAO;

    @Override
    public int insert(ArticleDTO articleDTO) {
        ArticleDO articleDO = new ArticleDO();
        articleDO.setId(articleDTO.getId());
        articleDO.setTitle(articleDTO.getTitle());
        articleDO.setContent(articleDTO.getContent());
        articleDO.setCategoryId(articleDTO.getCategoryId());
        return articleDAO.insert(articleDO);
    }

    @Override
    public List<ArticleDTO> getAll() {
        List<ArticleDTO> result = new ArrayList<>();
        List<ArticleDO> articleDAOAll = articleDAO.getAll();

        articleDAOAll.forEach(param->{
            ArticleDTO articleDTO = new ArticleDTO();
            articleDTO.setId(param.getId());
            articleDTO.setTitle(param.getTitle());
            articleDTO.setContent(param.getContent());
            articleDTO.setCategoryId(param.getCategoryId());
            result.add(articleDTO);
        });
        return result;
    }

    @Override
    public ArticleDTO getArticle(int id) {
        ArticleDTO articleDTO = new ArticleDTO();
        ArticleDO articleDO = articleDAO.getArticleById(id);
        articleDTO.setTitle(articleDO.getTitle());
        articleDTO.setContent(articleDO.getContent());
        articleDTO.setCategoryId(articleDO.getCategoryId());
        return articleDTO;
    }

    @Override
    public int insert(ArticleCategoryDTO articleCategoryDTO) {
        ArticleCategoryDO articleCategoryDO = new ArticleCategoryDO();
        articleCategoryDO.setCategoryId(articleCategoryDTO.getCategoryId());
        articleCategoryDO.setCategoryName(articleCategoryDTO.getCategoryName());
        articleCategoryDO.setTotalNumber(articleCategoryDTO.getTotalNumber());
        articleCategoryDAO.insert(articleCategoryDO);
        return 0;
    }

    @Override
    public List<ArticleCategoryDTO> getAllCategory() {
        List<ArticleCategoryDTO> res = new ArrayList<>();
        List<ArticleCategoryDO> articleCategoryDOS = articleCategoryDAO.selectAll();

        articleCategoryDOS.forEach(e->{
            ArticleCategoryDTO articleCategoryDTO = new ArticleCategoryDTO();
            articleCategoryDTO.setCategoryId(e.getCategoryId());
            articleCategoryDTO.setCategoryName(e.getCategoryName());
            articleCategoryDTO.setTotalNumber(e.getTotalNumber());

            res.add(articleCategoryDTO);
        });
        return res;
    }

    @Override
    public ArticleCategoryDTO selectByCategoryName(String categoryName) {
        ArticleCategoryDTO articleCategoryDTO = new ArticleCategoryDTO();
        ArticleCategoryDO articleCategoryDO = articleCategoryDAO.selectByCategoryName(categoryName);
        articleCategoryDTO.setCategoryId(articleCategoryDO.getCategoryId());
        articleCategoryDTO.setCategoryName(articleCategoryDO.getCategoryName());
        articleCategoryDTO.setTotalNumber(articleCategoryDO.getTotalNumber());

        return articleCategoryDTO;
    }

    @Override
    public Integer selectCategoryMax() {
        return articleCategoryDAO.selectCategoryIdMax();
    }

    @Override
    public Integer update(ArticleCategoryDTO articleCategoryDTO) {
        ArticleCategoryDO articleCategoryDO = new ArticleCategoryDO();
        articleCategoryDO.setCategoryId(articleCategoryDTO.getCategoryId());
        articleCategoryDO.setCategoryName(articleCategoryDTO.getCategoryName());
        articleCategoryDO.setTotalNumber(articleCategoryDTO.getTotalNumber());

        articleCategoryDAO.update(articleCategoryDO);
        return 1;
    }

    @Override
    public Integer deleteByNameOrId(String categoryName, int categoryId) {
        return null;
    }
}
