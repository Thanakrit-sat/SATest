package ku.cs.system.services;

import ku.cs.system.models.Supply;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplyDataAccessor {
    private Connection connection;

    public SupplyDataAccessor(String dbURL, String user, String password) throws SQLException, ClassNotFoundException{
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException{
        if (connection != null){
            connection.close();
        }
    }

    public List<Supply> getSupplyList() throws SQLException{
        try(
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM supply");
        ){
            List<Supply> soList = new ArrayList<>();
            while(resultSet.next()){
                int S_ID = Integer.parseInt(resultSet.getString("S_ID"));
                int P_ID =  Integer.parseInt(resultSet.getString("P_ID"));
                String name = resultSet.getString("S_Name");
                String phone = resultSet.getString("S_Phone");
                String address = resultSet.getString("S_Address");
                Supply supply = new Supply(S_ID, P_ID, name, phone, address);
                soList.add(supply);
            }
            return soList;
        }
    }
}
