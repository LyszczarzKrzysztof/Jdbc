package pl.sdacademy.main;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import pl.sdacademy.main.dao.RunDao;
import pl.sdacademy.main.daoimpl.JdbcRunDao;
import pl.sdacademy.main.entity.Run;
import pl.sdacademy.main.utils.JdbcUtils;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Date;
import java.util.Properties;

public class Main {


    public static void main(String[] args) throws SQLException {

//        try {
//            String connectionString = "jdbc:mysql://localhost:3306/runs";
//
//            Properties prop = new Properties();
//            prop.put("password", "1234");
//            prop.put("user", "user0");
//            prop.put("serverTimezone", "UTC");
//
//            Connection connection = DriverManager.getConnection(connectionString, prop);
//
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("INSERT INTO invoice (id, invoice_number) VALUE (1, 'FV/100/2018')");
//            statement.executeUpdate("INSERT INTO invoice (id, invoice_number) VALUE (2, 'FV/101/2018')");
//            statement.executeUpdate("INSERT INTO invoice (id, invoice_number) VALUE (3, 'FV/102/2018')");
//            statement.close();
//
//
//
//        }catch (SQLException e){
//            System.out.println(e);
//            System.exit(-1);
//        }

        //-----------------------------------------------------------------------------

//       Statement statement =  JdbcUtils.instance().getConnection().createStatement();
//
//       statement.executeUpdate("delete from runs");
//       statement.executeUpdate("INSERT INTO runs (ID, NAME, START_DATE) VALUES (1, 'Bieg_1', '2019-09-12')");
//       statement.executeUpdate("INSERT INTO runs (ID, NAME, START_DATE) VALUES (2, 'Bieg_2', '2019-08-11')");
//       statement.executeUpdate("INSERT INTO runs (ID, NAME, START_DATE) VALUES (3, 'Bieg_3', '2019-05-01')");
//
//       statement.executeUpdate("delete from members");
//       statement.executeUpdate("INSERT INTO members (ID, NAME, START_NUMBER, RUN_ID) VALUES (1, 'Ala Kowalska', 1, 1)");
//
//       statement.close();
//
//       //pooobieramy tutaj
//
//        Statement statement1 = JdbcUtils.instance().getConnection().createStatement();
//        ResultSet results =statement1.executeQuery("select name from runs");
//        while(results.next()){
//            String runsName = results.getString("name");
//            System.out.println(runsName);
//        }
//        statement.close();
        //-----------------------------------------------------------------------------


        RunDao runDao = new JdbcRunDao();

        Run run = new Run();

        run.setId(667);
        run.setName("Mój bardzy fajny bieg");
        run.setStartDate(new Date());

        runDao.save(run);

        runDao.findById(1);

    }
}
