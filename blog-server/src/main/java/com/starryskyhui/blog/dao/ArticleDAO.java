package com.starryskyhui.blog.dao;

import com.starryskyhui.blog.pojo.entity.ArticleDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDAO {
    public int insert(ArticleDO articleDO);

    public List<ArticleDO> getAll();

    public ArticleDO getArticleById(int id);
}
