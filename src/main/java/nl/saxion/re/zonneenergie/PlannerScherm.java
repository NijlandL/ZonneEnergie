package nl.saxion.re.zonneenergie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PlannerScherm {

    @FXML
    private ComboBox<String> teamComboBox;

    @FXML
    private DatePicker datumPicker;
    @FXML
    private Button logUit;

    // Voeg een Label toe om de status weer te geven
    @FXML
    private Label statusLabel;

    // HashMap om de planning van de teams bij te houden.
    private Map<String, LocalDate> teamPlanning;
    private final MainController mainController;

    public PlannerScherm(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void initialize() {

        teamComboBox.getItems().addAll("Team 1", "Team 2", "Team 3", "Team 4", "Team 5");

        // Initialiseer de HashMap om de planning van de teams bij te houden.
        teamPlanning = new HashMap<>();

        LocalDate vandaag = LocalDate.now();
        datumPicker.setValue(vandaag);
        datumPicker.setShowWeekNumbers(false);
        datumPicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(vandaag) < 0 || date.compareTo(vandaag.plusDays(7)) > 0);
            }
        });
    }

    @FXML
    private void logUit(ActionEvent event) {
        try {
            // Laad het login scherm FXML-bestand
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginPage.fxml"));
            Parent loginScherm = fxmlLoader.load();

            Scene loginScene = new Scene(loginScherm);

            Stage stage = (Stage) logUit.getScene().getWindow();
            stage.setScene(loginScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void planInstallatie() {
        String geselecteerdTeam = teamComboBox.getSelectionModel().getSelectedItem();
        LocalDate gekozenDatum = datumPicker.getValue();
        String adres = "Voorbeeldstraat 1";

        if (geselecteerdTeam != null && gekozenDatum != null) {
            GeplandeInstallatie geplandeInstallatie = new GeplandeInstallatie(gekozenDatum, geselecteerdTeam, adres);
            mainController.getGeplandeInstallaties().add(geplandeInstallatie);
            statusLabel.setText("Installatie gepland voor " + geselecteerdTeam + " op " + gekozenDatum + " bij " + adres);
        } else {
            statusLabel.setText("Selecteer een team en een datum om een installatie te plannen.");
        }
    }
}
