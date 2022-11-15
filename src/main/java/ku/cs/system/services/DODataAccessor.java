package ku.cs.system.services;

import ku.cs.system.models.DO;
import ku.cs.system.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DODataAccessor {
    private Connection connection;

    public DODataAccessor(String dbURL, String user, String password) throws SQLException, ClassNotFoundException{
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException{
        if (connection != null){
            connection.close();
        }
    }

    public List<DO> getDOList() throws SQLException{
        try(
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM do");
        ){
            List<DO> doList = new ArrayList<>();
            while(resultSet.next()){
                int do_id = Integer.parseInt(resultSet.getString("DO_ID"));
                int co_id = Integer.parseInt(resultSet.getString("CO_ID"));
                int amount = Integer.parseInt(resultSet.getString("DO_Amount"));
                float price = Float.parseFloat(resultSet.getString("DO_Price"));
                String name = resultSet.getString("DO_Prod");
                DO delivery = new DO(do_id, co_id, amount, price, name);
                doList.add(delivery);
            }
            return doList;
        }
    }
}
