package nl.saxion.re.zonneenergie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AdviseurScherm {
    @FXML
    private TextField energieverbruik;

    @FXML
    private TextField dakoppervlak;
    @FXML
    private Button loguit;
    @FXML
    private ComboBox<String> meterkastComboBox;

    @FXML
    private ComboBox<String> omvormerComboBox;
    @FXML
    private Button berekenOfferte;
    @FXML
    private Label offerteResultaat;

    public AdviseurScherm() {
    }

    @FXML
    public void initialize() {
        omvormerComboBox.getItems().addAll(
                "SB2000 - €400",
                "SB5000 - €600",
                "SB6000 - €800",
                "SB8000 - €1000",
                "SB12000 - €1500"
        );
        meterkastComboBox.getItems().addAll(
                "Ja",
                "Nee"
        );
    }

    @FXML
    private void onLoguitButtonPressed(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginPage.fxml"));
            Parent loginScherm = fxmlLoader.load();

            Scene loginScene = new Scene(loginScherm);

            Stage stage = (Stage) loguit.getScene().getWindow();
            stage.setScene(loginScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void berekenOfferte(ActionEvent event) {

        double dakOppervlak = Double.parseDouble(dakoppervlak.getText());
        double jaarlijksVerbruik = Double.parseDouble(energieverbruik.getText());
        double maxZonnepanelen = dakOppervlak / 1.6; // Veronderstel dat 1 zonnepaneel 1,6 m² groot is
        double benodigdeZonnepanelen = jaarlijksVerbruik / 405;

        int zonnepanelen = (int) Math.min(maxZonnepanelen, benodigdeZonnepanelen);
        double basisPrijs = zonnepanelen * 250;
        double standaardPrijs = 1000;
        String omvormerKeuze = omvormerComboBox.getValue();
        double omvormerPrijs = Double.parseDouble(omvormerKeuze.substring(omvormerKeuze.indexOf("€") + 1));

        double meterkastPrijs = "Ja".equals(meterkastComboBox.getValue()) ? 800 : 0;

        double totalePrijs = basisPrijs + omvormerPrijs + meterkastPrijs + standaardPrijs;
        offerteResultaat.setText(String.format("Offerte: € %.2f", totalePrijs));

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("offerteScherm.fxml"));
            Parent offerteScherm = fxmlLoader.load();

            OfferteScherm offerteSchermController = fxmlLoader.getController();

            String zonnepanelenInfo = "Zonnepanelen: " + basisPrijs;
            String omvormerInfo = "Omvormer: " + omvormerPrijs;
            String installatieInfo = "Installatie: €1000";
            String meterkastInfo = meterkastComboBox.getValue().equals("Ja") ? "Meterkast aanpassing: €800" : "";
            String totaalPrijsInfo = "Totaalprijs: €" + totalePrijs;

            offerteSchermController.setOfferteInformatie(zonnepanelenInfo, omvormerInfo, installatieInfo, meterkastInfo, totaalPrijsInfo);

            Scene offerteScene = new Scene(offerteScherm);

            Stage offerteStage = new Stage();
            offerteStage.setScene(offerteScene);
            offerteStage.setTitle("Offerte");
            offerteStage.initModality(Modality.APPLICATION_MODAL); // Dit zorgt ervoor dat het adviseurScherm niet toegankelijk is tot het offertescherm wordt gesloten
            offerteStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
