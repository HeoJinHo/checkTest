package com.example.customex.repository;

import com.example.customex.model.CheckData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckDataRepository extends JpaRepository<CheckData, Integer>
{
    void deleteByCheckValue(String checkValue);

    List<CheckData> findByCheckType (String checkType);

    Long countByCheckValue(String checkValue);


    Long countByCheckType(String checkValue);



}
