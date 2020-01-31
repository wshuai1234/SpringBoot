package com.shuaiwang.web;
import com.shuaiwang.domain.User;
import com.shuaiwang.domain.UserRepository;
import com.shuaiwang.domain.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    //to index
    @GetMapping("/")
    public String index(){
        return "index";
    }
    //跳转到注册页面
    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("userForm", new UserForm());
        return "register";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    //登录页面提交方法
    @PostMapping("/login")
    public String loginPost(@RequestParam String username, @RequestParam String password, HttpSession session){
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user!= null){
            session.setAttribute("user",user);
            return "index";
        }
        return "login";
    }
    //提交注册接收的方法
    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult result){
        if (! userForm.confirmPassword()){
            result.rejectValue("confirmPassword", "confirmError","两次密码不一致");
        }
        if(result.hasErrors()){
            return "register";
        }
        User user = userForm.convertToUser();
        userRepository.save(user);
        return "redirect:/login";
    }
    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }
    //异常方法
    @GetMapping("/exception")
    public String testException(){
        throw new RuntimeException("测试异常处理");
    }
}
