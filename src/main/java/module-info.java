module com.uady.operacionesconpolinomios {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires jlatexmath;
    requires java.desktop;
    requires javafx.swing;

    opens com.uady.operacionesconpolinomios to javafx.fxml;
    exports com.uady.operacionesconpolinomios;
}