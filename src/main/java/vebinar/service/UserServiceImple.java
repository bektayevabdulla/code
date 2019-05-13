package vebinar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import vebinar.dao.UserDao;
import vebinar.entity.Mail;
import vebinar.entity.User;

import java.util.List;

@Service
public class UserServiceImple implements UserService {
   @Autowired
   public UserDao userDao;


    public List<User> findAll() {
       return userDao.findAll();
   }

    @Override
    public List<Mail> findAllOutbox(String LoginFrom) {
        return userDao.findAllOutbox(LoginFrom);
    }

    @Override
    public List<Mail> findAllInbox(String Loginto) {
        return userDao.findAllInbox(Loginto);
    }

    @Override
    public void save(User user) {
       userDao.save(user);
    }

    @Override
    public User getByLogin(String login) {
        return userDao.getByLogin(login);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(String login) {
        userDao.delete(login);
    }

    @Override
    public User login(String login, String pass)  throws EmptyResultDataAccessException {
        return userDao.login(login,pass);
    }

    @Override
    public void saveMessage(String LoginTo, String LoginFrom, String Text){
        userDao.saveMessage(LoginTo,LoginFrom,Text);
    }

    @Override
    public boolean CheckLogin(String login, String email) {
        return userDao.CheckLogin(login,email);
    }


}
