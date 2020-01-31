package com.sw.service;

import com.sw.domain.Comment;
import com.sw.domain.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Transactional
    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
    @Transactional
    @Override
    public void deleteComment(Long id) {
//        commentRepository.deleteById(id);
//        commentRepository.deleteBy(id);
        Optional<Comment> obj = commentRepository.findById(id);
        if (! obj.isPresent()){
            return;
        }
        Comment comment = obj.get();
        comment.clearComment();
//        List<Comment> list = comment.getArticle().getComments();
//        for (Comment comment1 : list){
//            if (id == comment1.getId()){
//                list.remove(comment1);
//                break;
//            }
//        }
        commentRepository.deleteBy(id);
    }
}
