package com.example.demoapi.service;

import com.example.demoapi.entity.DataEntity;
import com.example.demoapi.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DataServiceImp implements DataService{
@Autowired
    private DataRepository dataRepository;
    @Override
    public DataEntity saveData(DataEntity dataEntity) {
        return dataRepository.save(dataEntity);
    }

    @Override
    public List<DataEntity> fetchAllData() {
        return dataRepository.findAll();
    }

    @Override
    public DataEntity getDataById(Long id) {
        Optional<DataEntity> data = dataRepository.findById(id);
        if (data.isPresent()) {
            return data.get();
        }
        return null;

    }

    @Override
    public DataEntity updateData(DataEntity dataEntity) {
        Optional<DataEntity> data1 = dataRepository.findById(dataEntity.getId());

        if (data1.isPresent()) {
            DataEntity originalData = data1.get();

            if (Objects.nonNull(dataEntity.getName()) && !"".equalsIgnoreCase(dataEntity.getName())) {
                originalData.setName(dataEntity.getName());
            }
            return dataRepository.save(originalData);
        }
        return null;
    }

    @Override
    public boolean deleteCDataById(Long id) {
        try {
            dataRepository.deleteById(id);
            return true;
        } catch (Exception e) {

            throw new RuntimeException("Failed to delete Data: " + e.getMessage());
        }
    }




}
