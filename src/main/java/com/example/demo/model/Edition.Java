package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Edition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String editionNumber;
    private int publicationYear;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public String getEditionLabel() {
        if ("1".equals(editionNumber)) {
            return editionNumber + "st Edition";
        } else if ("2".equals(editionNumber)) {
            return editionNumber + "nd Edition";
        } else if ("3".equals(editionNumber)) {
            return editionNumber + "rd Edition";
        } else
            return editionNumber + "th Edition";
    }

}
