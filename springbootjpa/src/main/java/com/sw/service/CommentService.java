package com.sw.service;

import com.sw.domain.Comment;

public interface CommentService {
    Comment saveComment(Comment comment);
    void deleteComment(Long id);
}
