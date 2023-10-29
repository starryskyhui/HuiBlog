package com.starryskyhui.blog.dao;

import com.starryskyhui.blog.pojo.entity.ArticleCategoryDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 郑国辉
 */
@Repository
public interface ArticleCategoryDAO {
    public List<ArticleCategoryDO> selectAll();
    public ArticleCategoryDO selectByCategoryName(String categoryName);
    public Integer selectCategoryIdMax();
    public int insert(ArticleCategoryDO articleCategoryDO);
    public int update(ArticleCategoryDO articleCategoryDO);
}
