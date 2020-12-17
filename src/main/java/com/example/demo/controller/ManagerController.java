package com.example.demo.controller;

import com.example.demo.pojo.Manager;
import com.example.demo.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ManagerController {
    @Autowired
    ManagerService managerService;
    @RequestMapping("/select")
    @ResponseBody
    public Manager getById(@RequestParam("id") Integer id){
        return managerService.getById(id);
    }
    @RequestMapping("/update")
    @ResponseBody
    public Manager update(Manager manager){
        managerService.update(manager);
        return manager;
    }
    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        managerService.delete(id);
    }
}
