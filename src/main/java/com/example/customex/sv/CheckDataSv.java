package com.example.customex.sv;

import com.example.customex.model.CheckData;

import java.util.List;

public interface CheckDataSv
{

    void insertCheckData(CheckData checkData);

    void deleteCheckData(CheckData checkData);

    void delCustomData(String id);

    Long getCount(String type);

    List<CheckData> getList(String findByCheckType);


}
