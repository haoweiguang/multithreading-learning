package me.light.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.HashMap;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.setBannerMode(Banner.Mode.OFF);

        try {
            HashMap<String, String> headerVersionMap = new ObjectMapper().readValue("{\"g\":\"1\"}", HashMap.class);
            headerVersionMap.put("g","2");
            headerVersionMap.put("g","3");
            String value = headerVersionMap.get("g");
            String ddd = "";
        } catch (IOException e) {
            e.printStackTrace();
        }


        SpringApplication.run(DemoApplication.class, args);
    }
}
