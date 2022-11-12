module com.vthacks.vthacksguardian {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.vthacks.vthacksguardian to javafx.fxml;
    exports com.vthacks.vthacksguardian;
}