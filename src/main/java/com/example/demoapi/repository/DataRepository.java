package com.example.demoapi.repository;

import com.example.demoapi.entity.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<DataEntity,Long> {
}
