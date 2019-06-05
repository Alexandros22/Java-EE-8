/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.entity;

import java.time.LocalDate;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aloukopoulos
 */

@Entity
public class Lista {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotNull(message = "Date of creation must be set!")
    @FutureOrPresent(message = "Date of creation must be in the present or future.")
    @JsonbDateFormat(value = "dd-MM-yyyy")
    private LocalDate dateCreated;
    
    @NotEmpty(message = "Creator must be set!")
    @Size(max = 50, message = "Creator should not be more than 50 characters.")
    private String creator;
    private String lastmod;
    
    @NotNull(message = "True of false of list's completion must be set!")
    private boolean isCompleted;
    
    
    @PrePersist
    private void init(){
        setDateCreated(LocalDate.now());
        setIsCompleted(false);
    }
    

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getLastmod() {
        return lastmod;
    }

    public void setLastmod(String lastmod) {
        this.lastmod = lastmod;
    }
    
}
