package com.example.customex.imp;

import com.example.customex.model.CheckData;
import com.example.customex.repository.CheckDataRepository;
import com.example.customex.sv.CheckDataSv;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckDataSvImp implements CheckDataSv
{
    private final CheckDataRepository checkDataRepository;

    @Override
    public void insertCheckData(CheckData checkData) {

        Long byCheckValue = checkDataRepository.countByCheckValue(checkData.getCheckValue());

        // 중복일 경우는 저장하지 않음
        // 따로 사용자에게 메세지 처리 안함
        // 이유 : 이미 저장 되어있는 값이면 사용자에게 메세지 처리를 안해도 사용자는 저장되어있는줄 알아야함. 그리고 실제로 저장도 되어있으니 문제 안될꺼라고 판단
        if(byCheckValue == 0){
            checkDataRepository.save(checkData);
        }
    }

    @Override
    @Transactional
    public void deleteCheckData(CheckData checkData) {
        checkDataRepository.deleteByCheckValue(checkData.getCheckValue());
    }

    @Override
    public List<CheckData> getList(String findByCheckType) {
        return checkDataRepository.findByCheckType(findByCheckType);
    }

    @Override
    @Transactional
    public void delCustomData(String id) {
        checkDataRepository.deleteByCheckValue(id);
    }

    @Override
    public Long getCount(String type) {
        return checkDataRepository.countByCheckType(type);
    }
}
