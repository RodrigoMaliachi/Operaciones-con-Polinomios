module com.uady.operacionesconpolinomios {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens com.uady.operacionesconpolinomios to javafx.fxml;
    exports com.uady.operacionesconpolinomios;
}