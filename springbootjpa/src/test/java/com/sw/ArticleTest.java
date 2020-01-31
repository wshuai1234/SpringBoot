package com.sw;

import com.alibaba.fastjson.JSON;
import com.sw.domain.*;
import com.sw.service.ArticleService;
import com.sw.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ArticleTest {
    @Autowired
    private ArticleService articleService;

    @Test
    public void saveArticle(){
        Article article = new Article();
        article.setTitle("job find");
        article.setContent("some thoughts about finding job");
        Comment comment1 = new Comment("review content one");
        Comment comment2 = new Comment("review content two");
        article.addComment(comment1);
        article.addComment(comment2);
        articleService.saveArticle(article);
    }
    @Test
    public void updateArticle(){
        Article article = articleService.findArticle(6L);
        if (article == null){
            return;
        }
        article.setContent("already changed");
        articleService.updateArticle(article);
    }
    @Test
    public void findArticle(){
        Article article = articleService.findArticle(6L);
        System.out.println(JSON.toJSONString(article, true));
    }
    @Test
    public void deleteArticle(){
        articleService.deleteArticle(9L);

    }
}
