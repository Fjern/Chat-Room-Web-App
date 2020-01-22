package com.github.fjern.ChatRoom.controller;


import com.github.fjern.ChatRoom.model.User;
import com.github.fjern.ChatRoom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @RequestMapping("/")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
    @RequestMapping("/addUser")
    public ModelAndView addUser(String username, String password){
//        User personToAdd = userService.addUser(username,password);
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("personAdded",personToAdd);
//        mv.setViewName("chat");
//        return mv;
        User thisUser = userService.addUser(username,password);
        ModelAndView mv = new ModelAndView();
        if(thisUser!=null){
            mv.setViewName("login");
            mv.addObject("thisUser",thisUser);
        }
        else{
            mv.setViewName("reg");
            String errorMsg = "username taken";
            mv.addObject("errorMsg",errorMsg);
        }
        return mv;
    }
    @RequestMapping("/verify")
    public ModelAndView verify(String username,String password){
        ModelAndView mv = new ModelAndView();
       User thisUser = userService.verifyUser(username,password);
       if (thisUser!=null){
           mv.setViewName("welcome");
           mv.addObject("thisUser",thisUser);
       }
       else{
           mv.setViewName("login");
           String errorMsg = "incorrect username/password";
           mv.addObject("errorMsg",errorMsg);
       }
       return mv;
    }
}
