package com.sw.domain;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    //Many那一方属于关系维护方，使用mappedby的是关系被维护方，One那一方
    @OneToMany(mappedBy = "article",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    @ManyToMany(mappedBy = "articles")
    private List<Topic> topics = new ArrayList<>();
    public void addComment(Comment comment){
        comment.setArticle(this);
        comments.add(comment);
    }
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Article(){

    }

}
