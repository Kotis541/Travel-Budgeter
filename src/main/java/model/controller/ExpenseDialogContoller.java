package model.controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Expense;

import java.time.LocalDate;

public class ExpenseDialogContoller {

    @FXML private TextField categoryField;
    @FXML private TextField amountField;
    @FXML private TextField descriptionField;
    @FXML private DatePicker datePicker;

    public Expense processResults() {
        String category = categoryField.getText();
        String description = descriptionField.getText();

        double amount = Double.parseDouble(amountField.getText());
        LocalDate date = datePicker.getValue();

        return new Expense(category, amount, description, date);
    }
}
