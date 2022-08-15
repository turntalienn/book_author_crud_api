package com.turntalien.library.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String bookName;

    @NotNull
    private int publishedYear;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "authorId")
    private Author author;

}
