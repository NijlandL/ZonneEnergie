package nl.saxion.re.zonneenergie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login {
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML

    private void onButtonPressed(ActionEvent event) {
        String enteredUsername = username.getText();
        String enteredPassword = password.getText();

        if (isValidLogin(enteredUsername, enteredPassword)) {
            System.out.println("Succesvol ingelogd!");

            // Sluit het huidige scherm
            Stage stage = (Stage) login.getScene().getWindow();
            stage.close();

            // Open het nieuwe scherm als de gebruiker een adviseur is
            if ("adviseur".equals(enteredUsername)) {
                Main.getInstance().openAdviseurScherm();
            }

            // Open het nieuwe scherm als de gebruiker een planner is
            if ("planner".equals(enteredUsername)) {
                Main.getInstance().openPlannerScherm();

            }
            if ("team".equals(enteredUsername)) {
                Main.getInstance().openTeamScherm();
            }
        } else {
            System.out.println("Inloggen mislukt. Probeer het opnieuw.");
        }
    }

    private boolean isValidLogin(String enteredUsername, String enteredPassword) {

        // Adviseur
        if ("adviseur".equals(enteredUsername) && "adviseur123".equals(enteredPassword)) {
            return true;
        }
        // Inkoopmedewerker
        else if ("inkoop".equals(enteredUsername) && "inkoop123".equals(enteredPassword)) {
            return true;
        }
        // Monteur
        else if ("monteur".equals(enteredUsername) && "monteur123".equals(enteredPassword)) {
            return true;
        }
        // Planner
        else if ("planner".equals(enteredUsername) && "planner123".equals(enteredPassword)) {
            return true;
        }
        else if("team".equals(enteredUsername) && "team123".equals(enteredPassword)) {
            return true;
        }
        // Onjuiste inloggegevens
        else {
            return false;
        }
    }
}
