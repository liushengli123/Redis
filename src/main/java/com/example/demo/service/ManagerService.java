package com.example.demo.service;

import com.example.demo.pojo.Manager;

public interface ManagerService {
    Manager getById(Integer id);
    Manager update(Manager manager);
    void delete(Integer id);
}
