package com.commentsManager.controller;

import com.commentsManager.domain.Comment;
import com.commentsManager.domain.User;
import com.commentsManager.repos.CommentRepo;
import com.commentsManager.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/comment")
    public String main(Map<String, Object> model){
        Iterable<Comment> comments = commentService.findAllComments();

        model.put("comments", comments);
        return "comment";
    }

    @PostMapping("/comment")
    public String addComment(@AuthenticationPrincipal User user,
                             @Valid Comment comment,
                             BindingResult bindingResult,
                             Model model
    ){
        if (bindingResult.hasErrors()){
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("comment", comment);
        } else {
            commentService.addComment(comment, user, new Date());
        }

        model.addAttribute("message", null);

        Iterable<Comment> comments = commentService.findAllComments();
        model.addAttribute("comments", comments);
        return "comment";
    }


}
