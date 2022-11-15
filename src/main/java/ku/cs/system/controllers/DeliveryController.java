package ku.cs.system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ku.cs.FXRouter;
import ku.cs.system.models.DO;

import java.io.IOException;

public class DeliveryController {
    @FXML
    private TextField AmountField;

    @FXML
    private TextField CO_IDField;

    @FXML
    private TextField PriceField;

    @FXML
    private TextField ProductField;

    @FXML
    private Label statusLabel;

    @FXML void initialize(){
        statusLabel.setText("");
    }

    @FXML
    public void clickAddDO(){
        String co_idFieldText = CO_IDField.getText();
        String product = ProductField.getText();
        String priceText = PriceField.getText();
        String amountText = AmountField.getText();

        if(co_idFieldText.isBlank() || product.isBlank() || priceText.isBlank() || amountText.isBlank()){
            statusLabel.setText("กรอกข้อมูลไม่ถูกต้อง");
            statusLabel.setStyle("-fx-text-fill: #A31F1F ;");
            return;
        }

        int co_id = Integer.parseInt(co_idFieldText);
        float price = Float.parseFloat(priceText);
        int amount = Integer.parseInt(amountText);

        statusLabel.setText("กรอกข้อมูลสำเร็จ");
    }

    @FXML
    public void clickBuySupply(ActionEvent actionEvent){
        try {
            FXRouter.goTo("supply");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า supply ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด supply");
        }
    }

    @FXML
    public void clickAddProduct(ActionEvent actionEvent){
        try {
            FXRouter.goTo("addProduct");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า addProduct ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด addProduct");
        }
    }

    @FXML
    public void clickCreateProduct(ActionEvent actionEvent){
        try {
            FXRouter.goTo("createProduct");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า createProduct ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด createProduct");
        }
    }

    @FXML
    public void clickBuyProduct(ActionEvent actionEvent){
        try {
            FXRouter.goTo("buyProduct");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า buyProduct ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด buyProduct");
        }
    }

    @FXML
    public void clickPre_Order(ActionEvent actionEvent){
        try {
            FXRouter.goTo("pre_order");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า pre_order ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด pre_order");
        }
    }

    @FXML
    public void clickConfirm(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("confirm");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า confirm ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด confirm");
        }
    }
}
