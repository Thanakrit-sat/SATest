package ku.cs.system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ku.cs.FXRouter;
import ku.cs.system.models.CO;
import ku.cs.system.models.DO;
import ku.cs.system.services.CODataAccessor;
import ku.cs.system.services.DODataAccessor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DeliveryController {
    @FXML
    private TextField PriceField;
    @FXML
    private TextField idField;
    @FXML
    private Label statusLabel;
    private DODataAccessor doDataAccessor;
    private CODataAccessor coDataAccessor;
    private List<DO> doList;
    private List<CO> coList;
    private DO delivery;

    @FXML void initialize() throws SQLException, ClassNotFoundException {
        doDataAccessor = new DODataAccessor("jdbc:mysql://localhost:3306/jewelsystem",
                "root", "");
        coDataAccessor = new CODataAccessor("jdbc:mysql://localhost:3306/jewelsystem",
                "root", "");
        coList = coDataAccessor.getCOList();
        doList = doDataAccessor.getDOList();
        statusLabel.setText("");
    }

    @FXML
    public void clickAddDO(){
        if(idField.getText().isBlank() || PriceField.getText().isBlank()){
            statusLabel.setText("Invalid Information");
            statusLabel.setStyle("-fx-text-fill: #ff546b ;");
            return;
        }
        int co_id = Integer.parseInt(idField.getText());
        Float price = Float.parseFloat(PriceField.getText());
        if(co_id <= 0 || co_id > coList.size()){
            statusLabel.setText("Invalid Information");
            statusLabel.setStyle("-fx-text-fill: #ff546b ;");
            return;
        }
        delivery = new DO(doList.size()+1, co_id, price, "On Going");
        try {
            doDataAccessor.insertDO(delivery);
            statusLabel.setText("Add DO successfully");
            statusLabel.setStyle("-fx-text-fill: #42ed6a;");
        } catch (SQLException e) {
            statusLabel.setText("Add DO to DB failed");
            statusLabel.setStyle("-fx-text-fill: #ff546b;");
        }
    }

    @FXML
    public void clickBuySupply(ActionEvent actionEvent){
        try {
            doDataAccessor.shutdown();
            coDataAccessor.shutdown();
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
            doDataAccessor.shutdown();
            coDataAccessor.shutdown();
            FXRouter.goTo("addProduct");
        } catch (IOException | SQLException e) {
            System.err.println("ไปที่หน้า addProduct ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด addProduct");
        }
    }

    @FXML
    public void clickCreateProduct(ActionEvent actionEvent){
        try {
            doDataAccessor.shutdown();
            coDataAccessor.shutdown();
            FXRouter.goTo("createSupplier");
        } catch (IOException | SQLException e) {
            System.err.println("ไปที่หน้า createSupplier ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด createSupplier");
        }
    }

    @FXML
    public void clickBuyProduct(ActionEvent actionEvent){
        try {
            doDataAccessor.shutdown();
            coDataAccessor.shutdown();
            FXRouter.goTo("checkCustomer", "buy");
        } catch (IOException | SQLException e) {
            System.err.println("ไปที่หน้า checkCustomer ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด buyProduct");
        }
    }

    @FXML
    public void clickPre_Order(ActionEvent actionEvent){
        try {
            doDataAccessor.shutdown();
            coDataAccessor.shutdown();
            FXRouter.goTo("checkCustomer", "pre");
        } catch (IOException | SQLException e) {
            System.err.println("ไปที่หน้า checkCustomer ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด checkCustomer");
        }
    }

    @FXML
    public void clickConfirm(ActionEvent actionEvent) {
        try {
            doDataAccessor.shutdown();
            coDataAccessor.shutdown();
            FXRouter.goTo("confirm");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า confirm ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด confirm");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
