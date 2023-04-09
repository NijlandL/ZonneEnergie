module nl.saxion.re.zonneenergie {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens nl.saxion.re.zonneenergie to javafx.fxml;
    exports nl.saxion.re.zonneenergie;
}