package pl.sdacademy.main.daoimpl;

import pl.sdacademy.main.dao.RunDao;
import pl.sdacademy.main.entity.Run;
import pl.sdacademy.main.utils.JdbcUtils;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcRunDao implements RunDao {

    private Connection connection = JdbcUtils.instance().getConnection();

    public void save(Run run) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into runs (id, name, start_date) values (?, ?, ?)");
        statement.setInt(1,run.getId());
        statement.setString(2,run.getName());

        java.sql.Date runSqlDate = new java.sql.Date(run.getStartDate().getTime());
        statement.setDate(3, runSqlDate);

        statement.executeUpdate();
        statement.close();
    }

    public Run findById(Integer id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery("select * from runs where id = "+id);

        if(results.next()){
            Run run = new Run();
            run.setId(results.getInt("id"));
            run.setName(results.getString("name"));
            java.sql.Date sqlStartDate = results.getDate("start_date");
            java.util.Date utilStartDate = new java.util.Date(sqlStartDate.getTime());
            run.setStartDate(utilStartDate);

            statement.close();

            return run;

        }
        statement.close();
        return null;
    }

    public List<Run> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery("select * from runs");
        List<Run> listOfRuns = new ArrayList<Run>();

        while(results.next()){
          listOfRuns.add(new Run(results.getInt("id"),
                  results.getString("name"),results.getDate("start_date")));

        }

        statement.close();
        return listOfRuns;


    }

    public void update(Run run) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("update runs set name =?, start_date=? where id=?");
        statement.setString(1,run.getName());

        java.sql.Date runSqlDate = new java.sql.Date(run.getStartDate().getTime());
        statement.setDate(2, runSqlDate);
        statement.setInt(3,run.getId());

        statement.executeUpdate();
        statement.close();

    }

    public void delete(Integer id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("delete from runs where id="+id);
        statement.close();
    }
}
