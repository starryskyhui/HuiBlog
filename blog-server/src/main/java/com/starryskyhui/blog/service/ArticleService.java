package com.starryskyhui.blog.service;

import com.starryskyhui.blog.pojo.dto.ArticleCategoryDTO;
import com.starryskyhui.blog.pojo.dto.ArticleDTO;
import com.starryskyhui.blog.pojo.entity.ArticleCategoryDO;

import java.util.List;

/**
 * @author 郑国辉
 */
public interface ArticleService {
    public int insert(ArticleDTO articleDTO);

    public List<ArticleDTO> getAll();

    public ArticleDTO getArticle(int id);

    public int insert(ArticleCategoryDTO articleCategoryDTO);

    public ArticleCategoryDTO selectByCategoryName(String categoryName);

    public List<ArticleCategoryDTO> getAllCategory();

    public Integer selectCategoryMax();

    public Integer update(ArticleCategoryDTO articleCategoryDTO);

    public Integer deleteByNameOrId(String categoryName, int categoryId);
}
