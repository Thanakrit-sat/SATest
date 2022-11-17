package ku.cs.system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ku.cs.FXRouter;
import ku.cs.system.models.Product;
import ku.cs.system.models.Supply;
import ku.cs.system.services.ProductDataAccessor;
import ku.cs.system.services.SupplyDataAccessor;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

public class CreateSupplierController {
    @FXML
    private TextField addressField;
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;
    @FXML
    private Label statusLabel;
    private SupplyDataAccessor supplyDataAccessor;
    private ProductDataAccessor productDataAccessor;
    private List<Supply> supplies;
    private List<Product> products;
    private Supply supply;

    @FXML void initialize() throws SQLException, ClassNotFoundException {
        supplyDataAccessor = new SupplyDataAccessor("jdbc:mysql://localhost:3306/jewelsystem",
                "root", "");
        productDataAccessor = new ProductDataAccessor("jdbc:mysql://localhost:3306/jewelsystem",
                "root", "");
        products = productDataAccessor.getProducts();
        supplies = supplyDataAccessor.getSupplyList();
        statusLabel.setText("");
    }

    @FXML
    public void clickSubmit(ActionEvent actionEvent){
        String name = nameField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        int p_id = Integer.parseInt(idField.getText());
        if(name.isBlank() || phone.isBlank() || address.isBlank() || idField.getText().isBlank()){
            statusLabel.setText("Invalid Information");
            statusLabel.setStyle("-fx-text-fill: #ff546b;");
            return;
        }else if (p_id <= 0 || p_id > products.size()){
            statusLabel.setText("Invalid Information");
            statusLabel.setStyle("-fx-text-fill: #ff546b;");
            return;
        }
        supply = new Supply(supplies.size()+1, p_id, name, phone, address);
        try {
            supplyDataAccessor.insertSupply(supply);
            statusLabel.setText("Add supplier successfully");
            statusLabel.setStyle("-fx-text-fill: #42ed6a;");
        } catch (SQLException e) {
            statusLabel.setText("Add supplier to DB failed");
            statusLabel.setStyle("-fx-text-fill: #ff546b;");
        }
    }

    @FXML
    public void clickBuySupply(ActionEvent actionEvent){
        try {
            supplyDataAccessor.shutdown();
            productDataAccessor.shutdown();
            FXRouter.goTo("supply");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า supply ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด supply");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickAddProduct(ActionEvent actionEvent){
        try {
            supplyDataAccessor.shutdown();
            productDataAccessor.shutdown();
            FXRouter.goTo("addProduct");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า addProduct ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด addProduct");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickBuyProduct(ActionEvent actionEvent){
        try {
            supplyDataAccessor.shutdown();
            productDataAccessor.shutdown();
            FXRouter.goTo("checkCustomer", "buy");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า checkCustomer ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด buyProduct");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickPre_Order(ActionEvent actionEvent){
        try {
            supplyDataAccessor.shutdown();
            productDataAccessor.shutdown();
            FXRouter.goTo("checkCustomer", "pre");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า checkCustomer ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด checkCustomer");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickDelivery(ActionEvent actionEvent){
        try {
            supplyDataAccessor.shutdown();
            productDataAccessor.shutdown();
            FXRouter.goTo("delivery");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า delivery ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด delivery");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickConfirm(ActionEvent actionEvent) {
        try {
            supplyDataAccessor.shutdown();
            productDataAccessor.shutdown();
            FXRouter.goTo("confirm");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า confirm ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด confirm");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
