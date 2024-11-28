package com.example.restapi.service;

import com.example.restapi.model.BorderInfo;
import com.example.restapi.repository.BorderInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorderInfoService {

    @Autowired
    private BorderInfoRepository borderInfoRepository;

    /*public List<BorderInfo> getAllBorderInfo() {
        return borderInfoRepository.findAll();
    }*/

    public Optional<BorderInfo> getBorderInfoById(String keyWord) {
        return borderInfoRepository.findById(keyWord);
    }

    public BorderInfo createBorderInfo(BorderInfo borderInfo) {
        return borderInfoRepository.save(borderInfo);
    }

    public BorderInfo updateBorderInfo(String keyWord, BorderInfo borderInfoDetails) {
        BorderInfo borderInfo = borderInfoRepository.findById(keyWord)
                .orElseThrow(() -> new RuntimeException("KeyWord not found"));
        borderInfo.setResponseEng(borderInfoDetails.getResponseEng());
        borderInfo.setResponseRo(borderInfoDetails.getResponseRo());
        borderInfo.setResponseRu(borderInfoDetails.getResponseRu());
        return borderInfoRepository.save(borderInfo);
    }

    public void deleteBorderInfo(String keyWord) {
        BorderInfo borderInfo = borderInfoRepository.findById(keyWord)
                .orElseThrow(() -> new RuntimeException("BorderInfo not found"));
        borderInfoRepository.delete(borderInfo);
    }
}