package io.github.xiaobaxi.certification.web;

import io.github.xiaobaxi.certification.core.AuthenticationManger;
import io.github.xiaobaxi.certification.core.DefaultCredentials;
import io.github.xiaobaxi.certification.core.Principal;
import io.github.xiaobaxi.certification.result.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
        Principal principal = authenticationManger.authenticate(credentials);
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
