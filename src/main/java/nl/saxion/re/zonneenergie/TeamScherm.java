package nl.saxion.re.zonneenergie;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class TeamScherm {

    @FXML
    private TableView<GeplandeInstallatie> installatieTable;

    @FXML
    private TableColumn<GeplandeInstallatie, String> teamColumn;

    @FXML
    private TableColumn<GeplandeInstallatie, String> datumColumn;

    @FXML
    private TableColumn<GeplandeInstallatie, String> adresColumn;

    @FXML
    private Button logUit;

    private final MainController mainController;

    public TeamScherm(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void initialize() {
        teamColumn.setCellValueFactory(new PropertyValueFactory<>("team"));
        datumColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDatum().toString()));
        adresColumn.setCellValueFactory(new PropertyValueFactory<>("adres"));

        installatieTable.setItems(mainController.getGeplandeInstallaties());
    }
    @FXML
    private void logUit(ActionEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginPage.fxml"));
            Parent loginScherm = fxmlLoader.load();

            Scene loginScene = new Scene(loginScherm);

            Stage stage = (Stage) logUit.getScene().getWindow();
            stage.setScene(loginScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}