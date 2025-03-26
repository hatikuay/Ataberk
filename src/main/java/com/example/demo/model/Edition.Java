package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Edition {
    @Id @GeneratedValue
    private Long id;
    private String editionNumber;
    
    private int publicationYear;
    
    @ManyToOne
    private Book book;

    public String getEditionLabel() {
        if(editionNumber == 1){ return editionNumber +"st"+ " "+ "Edition"}
        else if( editionNumber == 2){return editionNumber +"nd"+" "+"Edition"}
        else
        return editionNumber +"rd"+" "+"Edition";
    }
    
}
