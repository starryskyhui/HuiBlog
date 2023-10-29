package com.starryskyhui.blog.pojo.entity;

import lombok.Data;

/**
 * @author 郑国辉
 */
@Data
public class ArticleDO {
    private Integer id;
    private String title;
    private String content;
    private Integer categoryId;
}
