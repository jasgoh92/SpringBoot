package org.generation.toollist.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.generation.toollist.controller.dto.ListDTO;

import java.time.LocalDate;

@Entity
public class List {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;             //retrieve product item by ID - has to be an object
    private String description;
    private LocalDate date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List() {
    }

    public List(ListDTO listDTO) {
        this.title = listDTO.getTitle();
        this.description = listDTO.getDescription();
        this.date = listDTO.getDate();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Item{" + "title=" + title + ", description='" + description + '\'' + ", date='" +
                date + '\'' + '}';
    }

}
