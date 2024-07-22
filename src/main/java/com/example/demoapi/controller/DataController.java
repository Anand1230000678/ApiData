package com.example.demoapi.controller;

import com.example.demoapi.entity.DataEntity;
import com.example.demoapi.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DataController {
    @Autowired
    private DataService dataService;

    @PostMapping("/data")
    public DataEntity saveData(@RequestBody DataEntity dataEntity) {

        return dataService.saveData(dataEntity);
    }
    @GetMapping("/data")
    public List<DataEntity> getAllState() {

        return dataService.fetchAllData();
    }
    @GetMapping("/data/{id}")
    public DataEntity getDataById(@PathVariable("id") Long id) {

        return dataService.getDataById(id);
    }
    @PutMapping("/data")
    public DataEntity updateData(@RequestBody DataEntity dataEntity) {

        return dataService.updateData(dataEntity);
    }

    @DeleteMapping("/data/{id}")
    public boolean deleteData(@PathVariable("id") Long id) {

        return dataService.deleteCDataById(id);
    }
}
