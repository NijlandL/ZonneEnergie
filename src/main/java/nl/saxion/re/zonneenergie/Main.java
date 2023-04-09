package nl.saxion.re.zonneenergie;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    private static Main instance;
    private Stage primaryStage;

    public static Main getInstance() {
        return instance;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        instance = this;
        setPrimaryStage(primaryStage);
        Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        primaryStage.setTitle("Login Pagina");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

    public void openAdviseurScherm() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("adviseurScherm.fxml"));
            Stage adviseurStage = new Stage();
            adviseurStage.setTitle("Adviseur Scherm");
            adviseurStage.setScene(new Scene(root));
            adviseurStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openTeamScherm() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("teamscherm.fxml"));
            Stage teamStage = new Stage();
            teamStage.setTitle("Team Scherm");
            teamStage.setScene(new Scene(root));
            teamStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openPlannerScherm() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("plannerScherm.fxml"));
            Stage plannerStage = new Stage();
            plannerStage.setTitle("Planner Scherm");
            plannerStage.setScene(new Scene(root));
            plannerStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showInlogScherm() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/loginPage.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}

