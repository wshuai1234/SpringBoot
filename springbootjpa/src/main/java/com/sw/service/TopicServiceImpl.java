package com.sw.service;

import com.alibaba.fastjson.JSON;
import com.sw.domain.Article;
import com.sw.domain.ArticleRepository;
import com.sw.domain.Topic;
import com.sw.domain.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TopicServiceImpl  implements TopicService{
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Transactional
    @Override
    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }
    @Transactional
    @Override
    public Topic findTopic(Long id) {
        Optional<Topic> list = topicRepository.findById(id);
        if (! list.isPresent()){
            return null;
        }
        System.out.println(JSON.toJSONString(list.get(), true));
        return list.get();
    }
    @Transactional
    @Override
    public Topic updateTopic(Topic topic) {
        return topicRepository.save(topic);
    }
    @Transactional
    @Override
    public Topic includeArticle(Long topicId, Long articleId) {
        Optional<Topic> list = topicRepository.findById(topicId);
        if (! list.isPresent()){
            return null;
        }
        Topic topic = list.get();
        Article article = articleRepository.getOne(articleId);
        topic.getArticles().add(article);
        return topic;
    }
    @Transactional
    @Override
    public Topic unIncludeArticle(Long topicId, Long articleId) {
        Optional<Topic> list = topicRepository.findById(topicId);
        if (! list.isPresent()){
            return null;
        }
        Topic topic = list.get();
        Optional<Article> list1 = articleRepository.findById(articleId);
        if (! list1.isPresent()){
            return null;
        }
        Article article = list1.get();
        topic.getArticles().remove(article);
        return topic;
    }
    @Transactional
    @Override
    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);

    }
}
