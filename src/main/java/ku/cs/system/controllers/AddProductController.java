package ku.cs.system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ku.cs.FXRouter;
import ku.cs.system.models.Product;
import ku.cs.system.services.ProductDataAccessor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddProductController {

    @FXML
    Label amountLabel;

    @FXML
    TextField IDField;

    @FXML
    TextField amountField;

    @FXML
    Label nameLabel;

    @FXML
    Label priceLabel;

    @FXML
    Label statusLabel;
    private ProductDataAccessor productDataAccessor;
    private List<Product> products;
    private Product product;

    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {
        nameLabel.setText("None");
        priceLabel.setText("None");
        amountLabel.setText("None");
        statusLabel.setText("");
        productDataAccessor = new ProductDataAccessor("jdbc:mysql://localhost:3306/jewelsystem",
                "root", "");
        products = productDataAccessor.getProducts();
    }

    @FXML
    public void clickFindProduct(ActionEvent actionEvent){
        int id = Integer.parseInt(IDField.getText());
        product = products.get(id-1);
        nameLabel.setText(product.getP_Name());
        priceLabel.setText(""+product.getP_Price());
        amountLabel.setText(""+product.getP_Amount());
    }

    @FXML
    public void clickAddProduct(ActionEvent actionEvent){
        if(amountField.getText().isBlank()){
            statusLabel.setText("Please enter the amountField");
            statusLabel.setStyle("-fx-text-fill: #ff546b;");
            return;
        }
        int amount = Integer.parseInt(amountField.getText());
        product.setP_Amount(product.AddProduct(amount));
        int prod_amount = product.getP_Amount();
        try{
            productDataAccessor.updateAmount(prod_amount, product.getP_ID());
            amountLabel.setText(product.getP_Amount()+"");
            statusLabel.setText("Add product successfully");
            statusLabel.setStyle("-fx-text-fill: #42ed6a;");
        } catch (Exception e) {
            statusLabel.setText("Add product failed");
            statusLabel.setStyle("-fx-text-fill: #ff546b;");
        }
    }

    @FXML
    public void clickBuySupply(ActionEvent actionEvent){
        try {
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
    public void clickCreateProduct(ActionEvent actionEvent){
        try {
            productDataAccessor.shutdown();
            FXRouter.goTo("createProduct");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า createProduct ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด createProduct");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickBuyProduct(ActionEvent actionEvent){
        try {
            productDataAccessor.shutdown();
            FXRouter.goTo("buyProduct");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า buyProduct ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด buyProduct");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickPre_Order(ActionEvent actionEvent){
        try {
            productDataAccessor.shutdown();
            FXRouter.goTo("pre_order");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า pre_order ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด pre_order");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickDelivery(ActionEvent actionEvent){
        try {
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
