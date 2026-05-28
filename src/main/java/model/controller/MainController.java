package model.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import model.Expense;
import model.TravelManager;
import model.Trip;


import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

public class MainController {
    @FXML public TableView expenseTable;
    private TravelManager travelManager = new TravelManager();

    @FXML private ListView<Trip> listView;
    @FXML private TableColumn<Expense, LocalDate> dateColumn;
    @FXML private TableColumn<Expense, String> categoryColumn;
    @FXML private TableColumn<Expense, Double> amountColumn;
    @FXML private TableColumn<Expense, String> descriptionColumn;

    @FXML private TextField searchField;
    @FXML private Label totalLabel;

    @FXML
    public void handleAddExpense() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(expenseTable.getScene().getWindow());
        dialog.setTitle("Add new Expanse");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/view/ExpenseDialog.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Failed loading fxml file!");
            e.printStackTrace();
            return ;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            ExpenseDialogContoller contoller = fxmlLoader.getController();

            Expense newExpense = contoller.processResults();

            Trip selectedTrip = listView.getSelectionModel().getSelectedItem();

            if (selectedTrip != null) {
                selectedTrip.getExpenses().add(newExpense);
            } else {
                System.out.println("First pick any trip!");
            }
        }
    }

    @FXML
    public void handleRemoveExpense() {
        Trip selectedTrip = listView.getSelectionModel().getSelectedItem();
        Expense selectedExpense = (Expense) expenseTable.getSelectionModel().getSelectedItem();

        if (selectedTrip != null && selectedExpense != null) {
            selectedTrip.getExpenses().remove(selectedExpense);
        } else {
            System.out.println("First you need to pick trip and expense");
        }


    }

    @FXML
    public void handleSave() {
        System.out.println("Clicked on save");
    }

    @FXML
    public void handleLoad() {
        System.out.println("Clicked on load");
    }

    @FXML
    public void initialize() {
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        Trip egyptTrip = new Trip("Egypt", 2000.0);
        egyptTrip.getExpenses().add(new Expense("Transit", 2000, "Taxi v Káhiře", LocalDate.of(2026, 2, 12)));

        travelManager.getTrips().add(egyptTrip);
        listView.setItems(travelManager.getTrips());


    }


    public MainController() {
        TravelManager travelManager = new TravelManager();
    }
}
