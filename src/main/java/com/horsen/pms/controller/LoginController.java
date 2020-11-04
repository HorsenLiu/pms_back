package com.horsen.pms.controller;

import com.horsen.pms.utils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author Horsen
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class LoginController {
    @PostMapping("/login")
    public R login() {
        return R.success().setData("token", "admin");

    }
    @GetMapping("/info")
    public R info() {
        return R.success()
                .setData("roles", "admin")
                .setData("name", "admin")
                .setData("avatar", "https://horsenliu.gitee.io/images/avatar.png");
    }
}
