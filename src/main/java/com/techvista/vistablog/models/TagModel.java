package com.techvista.vistablog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Tag")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TagModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tagId;

    private String name;

}
