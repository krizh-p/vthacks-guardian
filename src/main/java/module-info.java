module com.vthacks.vthacksguardian {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires json.simple;
    requires java.net.http;

    opens com.vthacks.vthacksguardian to javafx.fxml;
    exports com.vthacks.vthacksguardian;
}