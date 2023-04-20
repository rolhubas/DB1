package org.example;

import java.sql.*;
import java.util.ArrayList;

public class AirportDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/db";

    public static void create(Airport oro) {
        String query = "INSERT INTO `sb_airports`( `biz_name`, `address`, `city`)" +
                " VALUES" + " (?,?,?)";

        try {
            //sukuriamas prisijungimas prie DB
            Connection connection = DriverManager.getConnection(URL, "root", "");

            //sukuriama paruošiamoji užklausa DB
            PreparedStatement statement = connection.prepareStatement(query);

            // eilės tvarka pakeičiami "?" užklausoje
            statement.setString(1, oro.getBizName());
            statement.setString(2, oro.getAddress());
            statement.setString(3, oro.getCity());


            //įvykdoma užklausa DB
            //executeUpdate metodas naudojamas sukuriant naują įrašą, redaguoti esamą ir išstrynimui
            //norint atlikti paiešką DB tarp esamų įrašų, reikia naudoti metodą executeQuery
            statement.executeUpdate();

            System.out.println("Įrašas sukurtas");
            //nutraukiamas susijungimas su DB
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Įvyko klaida kuriant naują įrašą DB. Plačiau: " + e.getMessage());
        }

    }

    public static ArrayList<Airport> searchByAirportName(String name) {
        String query = "SELECT * FROM `sb_airports` WHERE `biz_name` LIKE ?";
        ArrayList<Airport> airports = new ArrayList<>();
       // Connection connection = null;
        try {
            Connection connection = DriverManager.getConnection(URL,"root","");
           // connection = DriverManager.getConnection(URL, "root", "");

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,name );

            //DB grąžina neapdirbtą (RAW data) sąrašą
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                //išsitraukiame iš resultSet reikšmes pagal stulpelio pavadinimą (esančio DB)
                int bizId = resultSet.getInt("biz_id");
                String bizName = resultSet.getString("biz_name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");

                airports.add(new Airport(bizId, bizName, address, city));
            }
            statement.executeUpdate();

            System.out.println("Paieškos užklausa DB įvykdyta sėkmingai: ");
            //nutraukiamas susijungimas su DB
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Įvyko klaida ieškant įrašo DB. Plačiau: " + e.getMessage());
        }
        return airports;
    }
    public static void update(Airport oro){
        //String query = "UPDATE `sb_airports` SET `biz_name`='Kauno oro 69',`address`='Veiveriu 36',`city`='Riga' WHERE biz_id = 2";
        String query = "UPDATE `sb_airports` SET `biz_name`=?,`address`=?,`city`=? WHERE biz_id = ?";
        try {
            //sukuriamas prisijungimas prie DB
            Connection connection = DriverManager.getConnection(URL, "root", "");

            //sukuriama paruošiamoji užklausa DB
            PreparedStatement statement = connection.prepareStatement(query);

            // eilės tvarka pakeičiami "?"
            statement.setString(1, oro.getBizName());
            statement.setString(2, oro.getAddress());
            statement.setString(3, oro.getCity());
            statement.setInt(4, oro.getBizId());

            //įvykdoma užklausa DB
            //executeUpdate metodas naudojamas sukuriant naują įrašą, redaguoti esamą ir išstrynimui
            //norint atlikti paiešką DB tarp esamų įrašų, reikia naudoti metodą executeQuery
            statement.executeUpdate();

            System.out.println("Įrašas atnaujintas");
            //nutraukiamas susijungimas su DB
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Įvyko klaida atnaujinant įrašą DB. Plačiau: " + e.getMessage());
        }
    }
    public static void delete(int id)  {
        String query = "DELETE FROM `sb_airports` WHERE biz_id = ?";
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Įrašas istrintas sekmingai");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Įvyko klaida Istrinant įrašą DB. Plačiau: " + e.getMessage());
        }

    }
   /* public static ArrayList<Airport> searchByAirportName(String name) {
        String query = "SELECT * FROM `sb_airports` WHERE `biz_name` LIKE '" + name + "'";
        ArrayList<Airport> airports = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, "root", "");

            PreparedStatement statement = connection.prepareStatement(query);

            //DB grąžina neapdirbtą (RAW data) sąrašą
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                //išsitraukiame iš resultSet reikšmes pagal stulpelio pavadinimą (esančio DB)
                int bizId = resultSet.getInt("biz_id");
                String bizName = resultSet.getString("biz_name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");

                airports.add(new Airport(bizId, bizName, address, city));
            }

            System.out.println("Paieškos užklausa DB įvykdyta sėkmingai: ");
            //nutraukiamas susijungimas su DB
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Įvyko klaida ieškant įrašo DB. Plačiau: " + e.getMessage());
        }
        return airports;
    }*/





}
//TODO
// 1.4. Išsaugoti įrašą db.
// 1.5. Atlikti paiešką pagal oro uosto pavadinimą.
// 1.6. Paredaguoti esamą įrašą.
// 1.7. Ištrinti esamą įrašą pagal įrašo id.
// 1.8. Parašyti JUnit CRUD testus DAO klasei.
//surasti kaip atlikti paiešką su "?"