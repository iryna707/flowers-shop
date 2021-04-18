package shop.jdbc;
import shop.exceptions.InvalidFlowerHeightException;
import shop.exceptions.InvalidFlowerPriceException;
import shop.exceptions.InvalidFlowerTypeException;
import shop.models.flowers.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReadDataBase {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/FLOWERS";

    static final String USER = "newuser";
    static final String PASS = "password";

    public List<Flower> getAllFlowers() throws InvalidFlowerHeightException, InvalidFlowerPriceException, InvalidFlowerTypeException {
        Connection conn = null;
        Statement stmt = null;
        List<Flower> result = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT flowerID, flowerType, height, basePrice, color from flower";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int flowerID  = rs.getInt("flowerID");
                int height = rs.getInt("height");
                int basePrice = rs.getInt("basePrice");
                String flowerType = rs.getString("flowerType");
                String color = rs.getString("color");

                result.add(createFlower(height, basePrice, color, flowerType));
            }
            rs.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
//        catch(ClassNotFoundException e){
//            e.printStackTrace();
//        }

        finally{
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Done");
        return result;
    }

    private Flower createFlower(int height, int basePrice, String color, String flowerType) throws InvalidFlowerHeightException, InvalidFlowerPriceException, InvalidFlowerTypeException{
        if(height < 1) {
            throw new InvalidFlowerHeightException("Flower height is less than minimum, actual height is :" + height);
        }
        if(basePrice < 1) {
            throw new InvalidFlowerPriceException("Flower price is less than minimum, actual price is :" + basePrice);
        }

        if(flowerType.equals("rose")) {
            return new RoseFlower(height, color, basePrice);
        }
        else if(flowerType.equals("chamomile")) {
            return new ChamomileFlower(height, color, basePrice);}

        else {
            throw new InvalidFlowerTypeException("Flower type is incorrect");
        }

    }
}
