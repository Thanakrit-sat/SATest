package ku.cs.system.services;

import ku.cs.system.models.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDataAccessor {
    private Connection connection;

    public CustomerDataAccessor(String dbURL, String user, String password) throws SQLException , ClassNotFoundException{
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException{
        if (connection != null){
            connection.close();
        }
    }

    public List<Customer> getCustomers() throws SQLException{
        try(
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");
        ){
            List<Customer> customers = new ArrayList<>();
            while(resultSet.next()){
                int ID = Integer.parseInt(resultSet.getString("C_ID"));
                String name = resultSet.getString("C_Name");
                String phone = resultSet.getString("C_Phone");
                String address = resultSet.getString("C_Addrs");
                Customer customer = new Customer(ID, name, phone, address);
                customers.add(customer);
            }
            return customers;
        }
    }
}
