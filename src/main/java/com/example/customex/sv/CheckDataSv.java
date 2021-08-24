package com.example.customex.sv;

import com.example.customex.model.CheckData;

import java.util.List;

public interface CheckDataSv
{

    /**
     * 고정확장자 및 커스텀 확장자 db추가
     * @param checkData
     */
    void insertCheckData(CheckData checkData);

    /**
     * 고정 확장자 check 해제
     * @param checkData
     */
    void deleteCheckData(CheckData checkData);

    /**
     * 확장자 타입별 리스트 조회
     * @param findByCheckType
     * @return
     */
    List<CheckData> getList(String findByCheckType);

    /**
     * 커스텀 확장자 제거
     * @param id
     */
    void delCustomData(String id);

    /**
     * 타입별 확장자 조회
     * @param type
     * @return
     */
    Long getCount(String type);




}
