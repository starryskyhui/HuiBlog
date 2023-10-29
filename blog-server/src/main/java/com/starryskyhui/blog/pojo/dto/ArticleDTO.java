package com.starryskyhui.blog.pojo.dto;

import lombok.Data;

/**
 * @author 郑国辉
 */
@Data
public class ArticleDTO {
    private Integer id;
    private String title;
    private String content;
    private Integer categoryId;
}
