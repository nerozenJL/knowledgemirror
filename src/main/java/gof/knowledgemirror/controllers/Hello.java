package gof.knowledgemirror.controllers;

import gof.knowledgemirror.mappers.userMapper;
import gof.knowledgemirror.pojos.userEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //标注，第一次使用
public class Hello {
    @RequestMapping("/hello") //同样是标注，作何作用？
    public String sayHello() {
        return "Finally";
    }

    @Autowired
    private userMapper um;

    @RequestMapping("getuser")
    public List<userEntity> dogetUser() {
        List<userEntity> users=um.getAll();
        return users;
    }

    /*@GetMapping("/")
    public String welcome() {
        return "login.html";
    }*/
}
