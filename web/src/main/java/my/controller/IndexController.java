package my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class IndexController {

    @GetMapping({"/", "/index.html"})
    public ModelAndView homePage(){
        System.out.println("Call home page");
        return new ModelAndView("index");
    }

//    @GetMapping("/css/main.css")
//    public byte[] homeMainCss(){
//        System.out.println("Call main css");
//        byte[] bytes = null;  // ./src/credit/ex12/text.txt
//        try (var fis = new FileInputStream("/css/main.css")){ // /car_rent/css/main.css
//            bytes = fis.readAllBytes();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return bytes;
//    }

}
