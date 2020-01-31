package com.sw;

import com.alibaba.fastjson.JSON;
import com.sw.domain.Article;
import com.sw.domain.Comment;
import com.sw.service.ArticleService;
import com.sw.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentTest {
    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleService articleService;
    @Test
    public void saveCommentTest(){
        Article article = articleService.findArticle(6L);
        Comment comment = new Comment();
        comment.setContent("关于互联网...");
        comment.setArticle(article);
        commentService.saveComment(comment);
    }
    @Test
    public void deleteCommentTest(){
        commentService.deleteComment(7L);
    }


}
