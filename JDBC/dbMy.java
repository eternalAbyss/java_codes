package JDBC;

import java.sql.*;

public class dbMy {
    public static void main(String args[]){
    //     try {
    //         // dynamically loading the class files
    //         Class.forName("com.mysql.cj.jdbc.Driver");
    //         Connection dbConn = DriverManager.getConnection("jdbc:mysql://sql4.freesqldatabase.com:3306/sql6397443","sql6397443","TsZ1I4RLI5");
    //         System.out.println("Connected to the dataBase");
    //         Statement stmt = dbConn.createStatement();
    //     }catch(ClassNotFoundException e){
    //         System.out.println(e);
    //     }catch(SQLException e) {
    //         System.out.println(e);
    //     }

    //     try {
    //         stmt.execute("create table TVChannels (chname varchar(25),chtype varchar(20),chfrequency int)");
    //         System.out.println("Table Created Successfully");
    //     }catch(SQLException e) {
    //         System.out.println(e.getMessage());
    //     }

    //     stmt.executeUpdate("insert into TVChannels values ('Ten Sports', 'Sports', 54300)");
    //     System.out.println("1 Row Inserted");
    //     ResultSet rs = stmt.executeQuery("select * from TVChannels");
    //     while(rs.next())
    //     System.out.println(rs.getString(1) + "\t" + rs.getString(2) +"\t" + rs.getInt(3));
    // }

        try {
            // dynamically loading the class files
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connection dbConn = DriverManager.getConnection("jdbc:mysql://<host>:<port>/<dbname>>","<username>","<password>");
            Connection dbConn = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com:3306/sql6397443","sql6397443","TsZ1I4RLI5");
            System.out.println("Connected Successfully !!");
            Statement stmt = dbConn.createStatement();
            stmt.execute("create table TVChannels (chname varchar(25),chtype varchar(20),chfrequency int)");
            System.out.println("Table Created Successfully");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
