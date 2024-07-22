package com.example.demoapi.service;

import com.example.demoapi.entity.DataEntity;

import java.util.List;

public interface DataService {
    DataEntity saveData(DataEntity dataEntity);
    List<DataEntity> fetchAllData();
    DataEntity getDataById(Long id);
    DataEntity updateData(DataEntity dataEntity);
    boolean deleteCDataById(Long id);

}
