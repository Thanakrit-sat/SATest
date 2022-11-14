module ku.cs {
    requires javafx.controls;
    requires javafx.fxml;

    opens ku.cs to javafx.fxml;
    exports ku.cs;
    exports ku.cs.system.controllers;
    opens ku.cs.system.controllers to javafx.fxml;

    exports ku.cs.system.models;
    opens ku.cs.system.models to java.base;
}
