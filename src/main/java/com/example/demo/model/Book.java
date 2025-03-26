package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book<Edition> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private LocalDate publicationDate;

    @ManyToOne
    @JsonBackReference
    private Category category;

    @OneToMany(mappedBy = "book")
    private List<Edition> editions;


}
