package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//컨트롤러 같은 경우는 @Controller 를 입력해줘야 한다.
@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "Spring!!!");
        return "hello";

    }
}
