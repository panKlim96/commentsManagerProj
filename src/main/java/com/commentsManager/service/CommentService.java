package com.commentsManager.service;

import com.commentsManager.domain.Comment;
import com.commentsManager.domain.User;
import com.commentsManager.repos.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepo commentRepo;

    public void addComment(Comment comment, User user, Date commentDate){
        comment.setAuthor(user);
        comment.setCommentDate(new Date());
        commentRepo.save(comment);
    }

    public Iterable<Comment> findAllComments(){
        return commentRepo.findAll();
    }

}
