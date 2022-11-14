package ku.cs.system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ku.cs.FXRouter;
import ku.cs.system.models.Product;
import ku.cs.system.models.SO;
import ku.cs.system.models.Supp;
import ku.cs.system.services.ProductService;
import ku.cs.system.services.SOService;
import ku.cs.system.services.SuppService;

import java.io.IOException;

public class SupplyController {
    @FXML
    private TextField IDField;

    @FXML
    private TextField amountField;
    @FXML
    private  TextField priceField;

    @FXML
    private Label nameLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label typeLabel;
    private SuppService suppService = new SuppService();
    private SOService soService = new SOService();
    private Supp supp;
    private Product product;

    @FXML void initialize(){
        nameLabel.setText("");
        phoneLabel.setText("");
        typeLabel.setText("");
    }

    @FXML
    public void clickFindSupp(){
        int id = Integer.parseInt(IDField.getText());
        supp = suppService.getSupp(id);
        nameLabel.setText(supp.getS_Name());
        phoneLabel.setText(supp.getS_Phone());
        typeLabel.setText(""+supp.getP_ID());
    }

    @FXML
    public void clickBuyProduct(){
        int amount = Integer.parseInt(amountField.getText());
        float price = Float.parseFloat(priceField.getText());
        SO so = new SO(supp.getP_ID(), supp.getS_ID(), amount, price);
        try {
            soService.create(so);
        }
        catch (RuntimeException r) {
            System.out.println(r);
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
    public void clickDelivery(ActionEvent actionEvent){
        try {
            FXRouter.goTo("delivery");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า delivery ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด delivery");
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
