package vebinar.service;

import vebinar.entity.Mail;
import vebinar.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<Mail> findAllOutbox(String LoginFrom);
    List<Mail> findAllInbox(String LoginFrom);
    void save(User user);
    User getByLogin(String login);
    void update(User user);
    void delete(String login);
    User login(String login, String pass);
    void saveMessage(String LoginTo,String LoginFrom, String Text);

    boolean CheckLogin(String login, String email);
}
