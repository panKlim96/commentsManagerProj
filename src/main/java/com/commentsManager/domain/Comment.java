package com.commentsManager.domain;

import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER) // каждый раз, когда получаем комментарий сразу же получаем информацию об авторе.
    @JoinColumn(name = "user_id")
    private User author;

    @NotBlank(message = "Please fill the comment text")
    @Size(max = 2048, message = "Comment too long (more than 2kB")
    private String text;


    private Date commentDate;

    public Comment(User user, String text, Date commentDate) {
        this.text = text;
        this.commentDate = commentDate;
        this.author = user;
    }

    public Comment() {
    }

    public String getAuthorName(){
        return author != null ? author.getUsername() : "none";
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
