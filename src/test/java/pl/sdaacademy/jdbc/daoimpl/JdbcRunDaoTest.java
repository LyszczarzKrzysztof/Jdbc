package pl.sdaacademy.jdbc.daoimpl;


import org.junit.Before;
import org.junit.Test;
import pl.sdacademy.main.dao.RunDao;
import pl.sdacademy.main.daoimpl.JdbcRunDao;
import pl.sdacademy.main.entity.Run;
import pl.sdacademy.main.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import static org.junit.Assert.*;

public class JdbcRunDaoTest {

    @Before
    public void clearAll() throws SQLException {
        Connection connection = JdbcUtils.instance().getConnection();
        Statement statement = connection.createStatement();
        statement.execute("delete from runs");
        statement.close();
    }

    @Test
    public void saveTest() {

        try {
            RunDao runDao = new JdbcRunDao();
            Run run = new Run();
            run.setId(99);
            run.setName("Damian jestem");
            run.setStartDate(new Date());
            runDao.save(run);

            Run run1 = new Run();
            run1.setId(999);
            run1.setName("Krzysiek jestem");
            run1.setStartDate(new Date());
            runDao.save(run1);

            Run testRun = runDao.findById(99);

            assertNotNull(testRun);
            assertEquals(run.getName(), testRun.getName());
            assertEquals(run.getId(), testRun.getId());

            System.out.println(runDao.findAll());

        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void updateTest() {
        try {
            RunDao runDao = new JdbcRunDao();
            Run run = new Run();
            run.setId(99);
            run.setName("Damian jestem");
            run.setStartDate(new Date());
            runDao.save(run);


            run.setName("Inne imie");
            runDao.update(run);

            Run update = runDao.findById(99);

            assertEquals(update.getName(),run.getName());

        } catch (SQLException e) {
            fail(e.getMessage());
        }


    }

    @Test
    public void deleteTest() {
        try {
            RunDao runDao = new JdbcRunDao();
            Run run = new Run();
            run.setId(99);
            run.setName("Damian jestem");
            run.setStartDate(new Date());
            runDao.save(run);

            Run run1 = new Run();
            run1.setId(999);
            run1.setName("Krzysiek jestem");
            run1.setStartDate(new Date());
            runDao.save(run1);

            System.out.println(runDao.findAll());

            assertEquals(runDao.findAll().size(),2);

            runDao.delete(999);

            System.out.println(runDao.findAll());

            assertEquals(runDao.findAll().size(),1);

            assertNull(runDao.findById(999));


        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }
}
