package com.techvista.vistablog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Commentary")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentaryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentaryId;
    private String content;

    private Date date;

    @ManyToOne
    private UserModel user;

    @ManyToOne
    private PostModel post;

}
