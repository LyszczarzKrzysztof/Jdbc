package pl.sdacademy.main.dao;

import pl.sdacademy.main.entity.Run;

import java.sql.SQLException;
import java.util.List;

public interface RunDao {
    void save(Run run) throws SQLException;
    Run findById(Integer id) throws SQLException;
    List<Run> findAll() throws SQLException;
    void update(Run run) throws SQLException;
    void delete(Integer id) throws SQLException;
}
