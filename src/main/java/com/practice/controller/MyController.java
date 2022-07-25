package com.practice.controller;

import org.springframework.boot.Banner;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class MyController {

    @GetMapping("/about")
    public String about(Model model){
        System.out.println("In about");
        model.addAttribute("name","Sushruth");
        model.addAttribute("date",new Date().toLocaleString());
        return "about";
    }
    @GetMapping("/loops")
    public String loopExample(Model model){
        List<String>names= Arrays.asList("Sushruth","Tada","Sunny","Maha","Kiran");
        model.addAttribute("names",names);
        return "loop";
    }

    @GetMapping(value = {"/condition","/condition/{status}"})
    public String conditional(Model model, @PathVariable(required = false) String status){
        boolean s=true;
       if(status!=null)
            s=status.equals("A") ? true : false;
        model.addAttribute("isActive",s);
        model.addAttribute("gender","M");
        List<Integer>list=Arrays.asList(1,2,3,4,5);
        model.addAttribute("myList",list);
        return "condition";
    }

    @GetMapping("/services")
    public String services(){
        return "form";
    }
    @GetMapping("/generate")
    public String generate(Model m,@RequestParam("title") String title,@RequestParam("subTitle") String subTitle){
        m.addAttribute("title",title);
        m.addAttribute("subTitle",subTitle);
        return "service";
    }

    //for new about
    @GetMapping("/newabout")
    public String newAbout(){
        return "aboutnew";
    }
    //addong css ,js and image
    @GetMapping("/add")
    public String addFiles(){
        return "example";
    }
}
