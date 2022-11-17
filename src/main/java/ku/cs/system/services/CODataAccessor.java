package ku.cs.system.services;

import ku.cs.system.models.CO;
import ku.cs.system.models.SO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CODataAccessor {
    private Connection connection;

    public CODataAccessor(String dbURL, String user, String password) throws SQLException, ClassNotFoundException{
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException{
        if (connection != null){
            connection.close();
        }
    }

    public List<CO> getCOList() throws SQLException{
        try(
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM co");
        ){
            List<CO> coList = new ArrayList<>();
            while(resultSet.next()){
                int co_id = Integer.parseInt(resultSet.getString("CO_ID"));
                int p_id = Integer.parseInt(resultSet.getString("P_ID"));
                int c_id = Integer.parseInt(resultSet.getString("C_ID"));
                String name = resultSet.getString("CO_Prod");
                float price = Float.parseFloat(resultSet.getString("CO_Price"));
                int amount = Integer.parseInt(resultSet.getString("CO_Amount"));
                CO co = new CO(co_id, p_id, c_id, name, amount, price);
                coList.add(co);
            }
            return coList;
        }
    }

    public void insertCO(CO co) throws SQLException {
        PreparedStatement preparedStatement=null;
        try {
            int CO_ID = co.getCO_ID();
            int c_ID = co.getC_ID();
            int p_ID = co.getP_ID();
            String CO_Prod = co.getCO_Prod();
            float CO_Price = co.getCO_Price();
            int CO_Amount = co.getCO_Amount();
            String query =
                    "INSERT INTO CO (CO_ID, c_ID, p_ID, CO_Prod, CO_Price, CO_Amount) VALUES (?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1,CO_ID);
            preparedStatement.setInt(2,c_ID);
            preparedStatement.setInt(3,p_ID);
            preparedStatement.setString(4, CO_Prod);
            preparedStatement.setFloat(5,CO_Price);
            preparedStatement.setInt(6,CO_Amount);

            preparedStatement.executeUpdate();

            System.out.println("add CO successfully!");
        }catch (Exception e){
            System.out.println("add CO failed!");
        }
    }
}
