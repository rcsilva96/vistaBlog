package com.techvista.vistablog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Post")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postID;

    private String postTitle;

    private String postContent;

    private Date postDate;

    @ManyToOne
    private UserModel userID;

    public PostModel(Long postID, String postTitle, String postContent, UserModel userID) {
    }
}
