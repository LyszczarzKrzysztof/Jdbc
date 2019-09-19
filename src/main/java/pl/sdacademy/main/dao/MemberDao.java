package pl.sdacademy.main.dao;

import pl.sdacademy.main.entity.Member;

import java.sql.SQLException;
import java.util.List;

public interface MemberDao {
    void save(Member member) throws SQLException;
    Member findById(Integer id) throws SQLException;
    List<Member> findAll() throws SQLException;
    void update(Member run) throws SQLException;
    void delete(Integer id) throws SQLException;
}
