package pl.sdacademy.main.daoimpl;

import pl.sdacademy.main.dao.MemberDao;
import pl.sdacademy.main.entity.Member;

import java.sql.SQLException;
import java.util.List;

public class JdbcMemberDao implements MemberDao {
    public void save(Member member) throws SQLException {

    }

    public Member findById(Integer id) throws SQLException {
        return null;
    }

    public List<Member> findAll() throws SQLException {
        return null;
    }

    public void update(Member run) throws SQLException {

    }

    public void delete(Integer id) throws SQLException {

    }
}
