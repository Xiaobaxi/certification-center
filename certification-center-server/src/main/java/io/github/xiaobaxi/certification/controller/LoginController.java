package io.github.xiaobaxi.certification.controller;

import io.github.xiaobaxi.certification.core.AuthenticationManger;
import io.github.xiaobaxi.certification.core.DefaultCredentials;
import io.github.xiaobaxi.certification.core.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author fangzhibin
 * @date 2017/3/23
 */
@Controller
public class LoginController {
    @Value("${redirectUrl:index}")
    private String redirectUrl;

    @Autowired
    private AuthenticationManger authenticationManger;

    @GetMapping("/login.html")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login.html")
    public String login(DefaultCredentials credentials) {
        Principal principal = authenticationManger.authenticateAndObtainPrincipal(credentials);
        return "redirect:" + redirectUrl;
    }

    @GetMapping("/logout.html")
    public String logout() {
        return "logout";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

}
