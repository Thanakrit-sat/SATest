module ku.cs {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.context;
    requires spring.beans;
    requires spring.web;
    requires spring.boot;
    requires org.jetbrains.annotations;
    requires spring.boot.autoconfigure;
    requires spring.core;

    opens ku.cs to javafx.fxml;
    exports ku.cs;
    exports ku.cs.system.controllers;
    opens ku.cs.system.controllers to javafx.fxml;

    exports ku.cs.system.models;
    opens ku.cs.system.models to java.base;
}
