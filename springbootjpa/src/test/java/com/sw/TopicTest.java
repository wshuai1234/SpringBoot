package com.sw;

import com.alibaba.fastjson.JSON;
import com.sw.domain.Article;
import com.sw.domain.Comment;
import com.sw.domain.Topic;
import com.sw.service.ArticleService;
import com.sw.service.TopicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TopicTest {
    @Autowired
    private TopicService topicService;
    @Test

    public void saveTopic(){
        Topic topic = new Topic();
        topic.setName("艺术");
        topicService.saveTopic(topic);
    }
    @Test
    public void updateTopic(){
        Topic topic = topicService.findTopic(13L);
        topic.setName("游戏");
        topicService.saveTopic(topic);
    }
    @Test
    public void includeArticleTest(){
        topicService.includeArticle(13L,6L);
    }
    @Test
    public void findTopic(){
        Topic topic = topicService.findTopic(13L);
//        System.out.println(JSON.toJSONString(topic, true));
    }
    @Test
    public void unIncludeArticle(){
        topicService.unIncludeArticle(13L, 6L);
    }
    //Topic是关系维护者，当然可以维护关系，删除topic本身时候连带删除对应文章记录
    @Test
    public void deleteTopic(){
        topicService.deleteTopic(13L);
    }
}
