package vebinar.dao;

import vebinar.entity.Mail;
import vebinar.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> findAll();

    void save(User user);
    User getByLogin(String login);
    void update(User user);
    void delete(String login);

    User login(String login, String pass);
    void saveMessage(String LoginTo,String LoginFrom, String Text);
    List<Mail> findAllOutbox(String LoginFrom);

    List<Mail> findAllInbox(String loginFrom);

    boolean CheckLogin(String login, String email);
}
