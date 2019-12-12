package me.light.demo.valueannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author light.hao
 * @date 2019/12/12 5:05 PM
 */
@Service
public class HelloWorldService {

    @Value("${" + Constant.URL + "}")
    private String url;

    public String getUrl() {
        return url;
    }
}
