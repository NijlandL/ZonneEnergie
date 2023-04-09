package nl.saxion.re.zonneenergie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class OfferteScherm {

    @FXML
    private Label zonnepanelenInfo;

    @FXML
    private Label omvormerInfo;

    @FXML
    private Label installatieInfo;

    @FXML
    private Label meterkastInfo;

    @FXML
    private Label totaalPrijsInfo;

    @FXML
    private Button sluiten;

    public void setOfferteInformatie(String zonnepanelenInfo, String omvormerInfo, String installatieInfo, String meterkastInfo, String totaalPrijsInfo) {
        this.zonnepanelenInfo.setText(zonnepanelenInfo);
        this.omvormerInfo.setText(omvormerInfo);
        this.installatieInfo.setText(installatieInfo);
        this.meterkastInfo.setText(meterkastInfo);
        this.totaalPrijsInfo.setText(totaalPrijsInfo);
    }

    @FXML
    private void sluitenOfferte(ActionEvent event) {
        Stage stage = (Stage) sluiten.getScene().getWindow();
        stage.close();
    }
}
