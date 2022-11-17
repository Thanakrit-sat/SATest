package ku.cs.system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ku.cs.FXRouter;
import ku.cs.system.models.Customer;
import ku.cs.system.services.CustomerDataAccessor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CheckCustomerController {
    @FXML
    private TextField idField;
    @FXML
    private Label statusLabel;
    private List<Customer> customers;
    private CustomerDataAccessor customerDataAccessor;
    String check;

    @FXML void initialize() throws SQLException, ClassNotFoundException {
        customerDataAccessor = new CustomerDataAccessor("jdbc:mysql://localhost:3306/jewelsystem",
                "root", "");
        customers = customerDataAccessor.getCustomers();
        statusLabel.setText("");
        check = (String) FXRouter.getData();
    }

    @FXML
    public void clickFindCustomer() throws IOException, SQLException {
        int id = Integer.parseInt(idField.getText());
        if(id <= 0){
            statusLabel.setText("Invalid information");
            statusLabel.setStyle("-fx-text-fill: #ff546b;");
            return;
        }
        else if(id > customers.size()){
            customerDataAccessor.shutdown();
            FXRouter.goTo("newCustomer", check);
        }else{
            customerDataAccessor.shutdown();
            customerDataAccessor.shutdown();
            if(check.equals("buy"))
                FXRouter.goTo("buyProduct", id);
            else if (check.equals("pre"))
                FXRouter.goTo("pre_order", id);
            else
                return;
        }
    }

    @FXML
    public void clickBuySupply(ActionEvent actionEvent){
        try {
            customerDataAccessor.shutdown();
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
            customerDataAccessor.shutdown();
            FXRouter.goTo("addProduct");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า addProduct ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด addProduct");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickCreateProduct(ActionEvent actionEvent){
        try {
            customerDataAccessor.shutdown();
            FXRouter.goTo("createSupplier");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า createSupplier ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด createSupplier");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickPre_Order(ActionEvent actionEvent){
        try {
            customerDataAccessor.shutdown();
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
            customerDataAccessor.shutdown();
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
            customerDataAccessor.shutdown();
            FXRouter.goTo("confirm");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า confirm ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด confirm");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
