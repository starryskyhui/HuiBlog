package com.starryskyhui.blog.pojo.entity;

import lombok.Data;

/**
 * @author 郑国辉
 */
@Data
public class ArticleCategoryDO {
    private Integer id;
    private Integer categoryId;
    private String categoryName;
    private Integer totalNumber;
}
