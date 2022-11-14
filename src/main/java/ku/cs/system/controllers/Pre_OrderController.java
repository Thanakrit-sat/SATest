package ku.cs.system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ku.cs.FXRouter;
import ku.cs.system.services.CustService;
import ku.cs.system.services.Pre_ProdService;

import java.io.IOException;

public class Pre_OrderController {
    @FXML
    private TextField IDField;

    @FXML
    private TextField amountField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;
    private Pre_ProdService pre_prodService = new Pre_ProdService();
    private CustService custService = new CustService();

    @FXML void initialize(){}

    @FXML
    public void clickFindCust(){

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
