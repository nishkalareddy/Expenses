package com.expenses.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
/*******************************************
 Developer Name: Nishkala
 Created on: 08/09/25 1:47 pm
 *******************************************/


@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private String type;      // "income" or "expense"
    private String category;
    private LocalDateTime date;

    // Constructors
    public Transaction() {
        this.date = LocalDateTime.now();
    }

    public Transaction(double amount, String type, String category) {
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.date = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

