/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbbauernregeln;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arjuna
 */
public class mySQLconnection {

    private Connection connect;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public mySQLconnection() throws SQLException {
        // This will load the MySQL driver, each DB has its own driver
        //   Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306?autoReconnect=true&useSSL=false", "arjuna", "fadda");
    }

    public List<Wettereintrag> readDataBase(String query) throws Exception {
        try {

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery(query);

            List<Wettereintrag> result = new ArrayList<Wettereintrag>();
            while (resultSet.next()) {
            // It is possible to get the columns via name
                // also possible to get the columns via the column number
                // which starts at 1
                result.add(new Wettereintrag(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.getFloat(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getFloat(7), resultSet.getFloat(8), resultSet.getFloat(9), resultSet.getFloat(10), resultSet.getFloat(11), resultSet.getFloat(12), resultSet.getFloat(13), resultSet.getFloat(14), resultSet.getInt(15), resultSet.getFloat(16), resultSet.getInt(17), resultSet.getString(18)));

            }

            return  result;
            /*
             writeResultSet(resultSet);
        
             // PreparedStatements can use variables and are more efficient
             preparedStatement = connect
             .prepareStatement("insert into  wetter.wetterdaten values (default, ?, ?, ?, ? , ?, ?)");
             // "myuser, webpage, datum, summery, COMMENTS from feedback.comments");
             // Parameters start with 1
             preparedStatement.setString(1, "Test");
             preparedStatement.setString(2, "TestEmail");
             preparedStatement.setString(3, "TestWebpage");
             preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
             preparedStatement.setString(5, "TestSummary");
             preparedStatement.setString(6, "TestComment");
             preparedStatement.executeUpdate();

             preparedStatement = connect
             .prepareStatement("SELECT myuser, webpage, datum, summery, COMMENTS from feedback.comments");
             resultSet = preparedStatement.executeQuery();
             writeResultSet(resultSet);

             // Remove again the insert comment
             preparedStatement = connect
             .prepareStatement("delete from feedback.comments where myuser= ? ; ");
             preparedStatement.setString(1, "Test");
             preparedStatement.executeUpdate();
      
             resultSet = statement
             .executeQuery("select * from feedback.comments");
             writeMetaData(resultSet);
             */
        } catch (Exception e) {
            throw e;
        }
    }

    public void insertIntoDatabase(List<Wettereintrag> daten) throws SQLException {
        for (int i = 0; i < daten.size(); i++) {
            try {
                preparedStatement = connect
                        .prepareStatement("insert into  wetter.wetterdaten values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                // Parameters start with 1
                preparedStatement.setString(1, daten.get(i).STATION);
                preparedStatement.setInt(2, daten.get(i).MESS_DATUM);
                preparedStatement.setInt(3, daten.get(i).QUALITAETS_NIVEAU);
                preparedStatement.setFloat(4, daten.get(i).LUFTTEMPERATUR);
                preparedStatement.setFloat(5, daten.get(i).DAMPFDRUCK);
                preparedStatement.setFloat(6, daten.get(i).BEDECKUNGSGRAD);
                preparedStatement.setFloat(7, daten.get(i).LUFTDRUCK_STATIONSHOEHE);
                preparedStatement.setFloat(8, daten.get(i).REL_FEUCHTE);
                preparedStatement.setFloat(9, daten.get(i).WINDGESCHWINDIGKEIT);
                preparedStatement.setFloat(10, daten.get(i).LUFTTEMPERATUR_MAXIMUM);
                preparedStatement.setFloat(11, daten.get(i).LUFTTEMPERATUR_MINIMUM);
                preparedStatement.setFloat(12, daten.get(i).LUFTTEMP_AM_ERDB_MINIMUM);
                preparedStatement.setFloat(13, daten.get(i).WINDSPITZE_MAXIMUM);
                preparedStatement.setFloat(14, daten.get(i).NIEDERSCHLAGSHOEHE);
                preparedStatement.setInt(15, daten.get(i).NIEDERSCHLAGSHOEHE_IND);
                preparedStatement.setFloat(16, daten.get(i).SONNENSCHEINDAUER);
                preparedStatement.setInt(17, daten.get(i).SCHNEEHOEHE);
                preparedStatement.setString(18, daten.get(i).eor);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String inString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        return sb.toString();
    }

    private String inString(float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(f);
        return sb.toString();
    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //   Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
 /*
         // simple JDBC code to run SQL query and populate resultSet - END
         List<Wettereintrag> pojoList = resultSetMapper.mapRersultSetToObject(resultSet, Wettereintrag.class);
         // print out the list retrieved from database
         if(pojoList != null){
         for(SamplePojo pojo : pojoList){
         System.out.println(pojo);
         }
         }else{
         System.out.println("ResultSet is empty. Please check if database table is empty");
         }
        
         */
        List<Wettereintrag> result = new ArrayList<Wettereintrag>();
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            result.add(new Wettereintrag(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.getFloat(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getFloat(7), resultSet.getFloat(8), resultSet.getFloat(9), resultSet.getFloat(10), resultSet.getFloat(11), resultSet.getFloat(12), resultSet.getFloat(13), resultSet.getFloat(14), resultSet.getInt(15), resultSet.getFloat(16), resultSet.getInt(17), resultSet.getString(18)));

        }
    }

    // You need to close the resultSet
    public void close() {

        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
