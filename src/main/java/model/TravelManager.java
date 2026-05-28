package model;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.*;

public class TravelManager {
    private ObservableList<Trip> trips = FXCollections.observableArrayList();

    public void addTrip(Trip trip) {
        this.trips.add(trip);
    }

    public void removeTrip(Trip trip) {
        this.trips.remove(trip);
    }

    public ObservableList<Trip> getTrips() {
        return trips;
    }

    public void saveData(String filepath) {
        //
    }

    public void loadData(String filepath) {
        //
    }
}
