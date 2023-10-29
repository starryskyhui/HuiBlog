package com.starryskyhui.blog.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @author 郑国辉
 */
@Data
public class ArticleVO {
    private Integer id;
    private String title;
    private String content;
    private List<String> categoryName;
}
