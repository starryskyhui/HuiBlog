package com.starryskyhui.blog.pojo.dto;

import lombok.Data;

/**
 * @author 郑国辉
 */
@Data
public class ArticleCategoryDTO {
    private Integer id;
    private Integer categoryId;
    private String categoryName;
    private Integer totalNumber;
}
