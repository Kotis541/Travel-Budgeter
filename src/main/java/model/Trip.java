package model;

import java.util.ArrayList;
import java.util.UUID;

public class Trip {
    private String id;
    private String destination;
    private ArrayList<Expense> expenses;
    private double budget;

    public Trip(String destination, double budget) {
        this.id = UUID.randomUUID().toString();
        this.destination = destination;
        this.budget = budget;
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        this.expenses.add(expense);
    }

    public void removeExpense(Expense expense) {
        this.expenses.remove(expense);
    }

    public double getTotalSpent() {
        double total = 0;
        for (Expense e: expenses) {
            total += e.getAmount();
        }
        return total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(ArrayList<Expense> expenses) {
        this.expenses = expenses;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
    @Override
    public String toString() {
        return this.destination;
    }
}
