package nl.saxion.re.zonneenergie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainController {

    private final ObservableList<GeplandeInstallatie> geplandeInstallaties;

    public MainController() {
        geplandeInstallaties = FXCollections.observableArrayList();
    }

    public ObservableList<GeplandeInstallatie> getGeplandeInstallaties() {
        return geplandeInstallaties;
    }
}
