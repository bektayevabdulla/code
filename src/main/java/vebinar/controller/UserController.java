package vebinar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vebinar.entity.Mail;
import vebinar.entity.User;
import vebinar.service.Sender;
import vebinar.service.UserService;

import java.io.PrintWriter;
import java.util.Map;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    public UserService userService;

    @Autowired
    public Sender sender;

    public String Login;

    boolean LoginBool = true;

    @GetMapping("/")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/")
    public String login(@ModelAttribute("user") User user) {

        if(user.getLogin().equals("Abdulla") && user.getPassword().equals("Abdulla")){
            return "redirect:/users";
        }
        else{
            User userFromDb = userService.login(user.getLogin(),user.getPassword());

            if(userFromDb != null){
                return "redirect:/user/" + userFromDb.getLogin();
            }
            else{
                return  "redirect:/";
            }
        }
    }


    @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users",userService.findAll());
        return "usersList";
    }

    @GetMapping("/message/outbox/{login}")
    public String Outbox(Model model,@PathVariable("login") String login ){
        model.addAttribute("mails",userService.findAllOutbox(login));
        return "outbox";
    }


    @GetMapping("/message/inbox/{login}")
    public String Inbox(Model model,@PathVariable("login") String login ){
        model.addAttribute("mails",userService.findAllInbox(login));
        return "inbox";
    }


    @GetMapping("/message/{login}")
    public String messagePage(@PathVariable("login") String login){
        Login = login;
        return "message";
    }

    @PostMapping("/message/{login}")
    public String message( @ModelAttribute("message") Mail mail){
        if(userService.getByLogin(mail.getLoginto()) == null || mail.getMessage().equals("")){
            return "redirect:/message/{login}";
        }

        userService.saveMessage(mail.getLoginto(),Login,mail.getMessage());
        return "redirect:/message/outbox/" + Login;
    }

    @GetMapping("/forgot")
    public String Createforgot(){
        return "forgot";
    }
    @PostMapping("/forgot")
    public String forgot(@ModelAttribute("user") User user){
        sender.send("Password","Don't tell anyone. It is You Password " + userService.getByLogin(user.getLogin()).getPassword(),"forjavamessage@gmail.com",userService.getByLogin(user.getLogin()).getEmail());
        String login  = userService.getByLogin(user.getLogin()).getLogin();
        return "redirect:/";
    }

    @GetMapping("/addUser")
    public String createUserPage(){
        return "createUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        if(user.getName().length() < 3 || user.getSurname().length() < 3){
        return "redirect:/addUser";
        }
        if(!(userService.CheckLogin(user.getLogin(),user.getEmail()))){
            return "redirect:/addUser";
        }
        if(user.getPassword().length() < 8){
            return "redirect:/addUser";
        }

        userService.save(user);
        sender.send("Welcome","Welcome to our team " + user.getName(),"forjavamessage@gmail.com",user.getEmail());
        return "redirect:/";
    }

    @PostMapping("/updateUser")
    public String updeteUser(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/user/" + user.getLogin();
    }

    @GetMapping("/user/{login}")
    public String getById(@PathVariable("login") String login, Model model){
        model.addAttribute("user",userService.getByLogin(login));
        return "showUser";
    }
    @GetMapping("/update/{login}")
    public String update(@PathVariable("login") String login,Model model){
        model.addAttribute("user",userService.getByLogin(login));
        return "editUser";
    }

    @GetMapping("/delete/{login}")
    public String delete(@PathVariable("login") String login){
        userService.delete(login);
        return "redirect:/users";
    }
    @GetMapping("/mainIndex")
    public String MainIndex(){
        return "mainIndex";
    }
}
