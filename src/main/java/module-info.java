module com.example.demo3 {
    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens Mypack to javafx.fxml;
    exports Mypack;
    exports Mypack.ComputerParts;
    opens Mypack.ComputerParts to javafx.fxml;
    exports Mypack.Controllers;
    opens Mypack.Controllers to javafx.fxml;
}