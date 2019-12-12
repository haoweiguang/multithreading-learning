package me.light.demo.valueannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author light.hao
 * @date 2019/12/12 5:14 PM
 */
@RestController
@RequestMapping("/annotion")
public class HelloWorld {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/helloworld")
    public String helloworld() {
        return helloWorldService.getUrl();
    }

}
