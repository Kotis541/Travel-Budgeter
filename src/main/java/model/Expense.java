package model;

import java.time.LocalDate;
import java.util.UUID;

public class Expense {
    private String id;
    private String category;
    private String description;
    private LocalDate date;
    private double amount;

    public Expense(String category, double amount, String description, LocalDate date) {
        this.id = UUID.randomUUID().toString();
        this.category = category;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
