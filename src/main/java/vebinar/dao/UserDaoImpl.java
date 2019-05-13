package vebinar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;
import vebinar.entity.Mail;
import vebinar.entity.User;
import vebinar.mapper.MailMapper;
import vebinar.mapper.UserMapper;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<User> findAll() {
        String sql = "SELECT * FROM login";
        return jdbcTemplate.query(sql,new UserMapper());
    }


    public List<Mail> findAllOutbox(String LoginFrom) {
        String sql = "SELECT *FROM message where loginfrom =? ";
        return jdbcTemplate.query(sql, new MailMapper(),LoginFrom);
    }

    @Override
    public List<Mail> findAllInbox(String loginto) {
        String sql = "SELECT *FROM message where loginto =? ";
        return jdbcTemplate.query(sql,new MailMapper(),loginto);
    }




    public void save(User user) {
        try{
        String sql = "INSERT INTO login (Name,Surname,Email,Login,Password) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql,user.getName(),user.getSurname(),user.getEmail(),user.getLogin(),user.getPassword());}
        catch (EmptyResultDataAccessException e){
        }
    }


    public User getByLogin(String login) {
        String sql = "SELECT  * FROM login where Login=?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), login);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }


    public void update(User user) {
        String sql = "UPDATE login SET Name =?,Surname =? , Email= ?, Login =? , Password =? WHERE id = ?";
        jdbcTemplate.update(sql,user.getName(),user.getSurname(),user.getEmail(),user.getLogin(),user.getPassword(), user.getId());
    }

    public void delete(String login) {
        String sql ="DELETE FROM login WHERE Login = ?";
        jdbcTemplate.update(sql, login);
    }


    public User login(String login, String pass)  throws EmptyResultDataAccessException {
        String sql = "SELECT  * FROM login where Login=? and Password = ?";
        try{
            return jdbcTemplate.queryForObject(sql,new UserMapper(), login,pass);
        }
        catch (EmptyResultDataAccessException e){
           return null;
        }
    }


    public boolean CheckLogin(String login, String email) {

        String sql = "SELECT *FROM login WHERE Login = ? or Email = ? ";
        try{
            jdbcTemplate.queryForObject(sql,new UserMapper(), login,email);
            return false;
        }
        catch(EmptyResultDataAccessException e){
                return true;
        }
    }

    public void saveMessage(String LoginTo, String LoginFrom, String Text){
        String sql ="INSERT INTO message(loginto, loginfrom, message) value (?,?,?)";
        jdbcTemplate.update(sql,LoginTo,LoginFrom,Text);
    }


}
