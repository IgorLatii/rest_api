package com.example.restapi.controller;

import com.example.restapi.model.DataUploadRequest;
import com.example.restapi.model.MeterData;
import com.example.restapi.repository.MeterDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Calendar;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MeterDataController {

    @Autowired
    private MeterDataRepository repository;

    // Login
    /*@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String contractNumber = request.get("contractNumber");
        String meterNumber = request.get("meterNumber");

        if (!repository.existsByContractNumberAndMeterNumber(contractNumber, meterNumber)) {
            MeterData newRecord = new MeterData();
            newRecord.setContractNumber(contractNumber);
            newRecord.setMeterNumber(meterNumber);
            repository.save(newRecord);
        }
        return ResponseEntity.ok(Map.of("success", true, "message", "Авторизация успешна"));
    }*/

    // Data upload
    @PostMapping("/uploadData")
    public ResponseEntity<?> uploadData(@RequestBody DataUploadRequest request) {
        try {

            if (request.getContractNumber() == null || request.getMeterNumber() == null ||
                    request.getMeterReading() == null || request.getPhotoBase64() == null) {
                return ResponseEntity.badRequest().body(Map.of("success", false, "message", "Некорректные данные"));
            }

            byte[] decodedBytes = Base64.getDecoder().decode(request.getPhotoBase64());
            String fileName = setFileName(request);

            Path path = Paths.get("uploads/" + fileName);
            Files.createDirectories(path.getParent());
            Files.write(path, decodedBytes);

            // Saving data in DB
            MeterData data = new MeterData();
            data.setContractNumber(request.getContractNumber());
            data.setMeterNumber(request.getMeterNumber());
            data.setMeterReading(request.getMeterReading());
            data.setPhotoPath(path.toString());
            data.setTimestamp(LocalDateTime.now());
            repository.save(data);

            return ResponseEntity.ok(Map.of("success", true, "message", "Data saved"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", e.getMessage()));
        }
    }

    private String setFileName(DataUploadRequest request) {
        long actual_time = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(actual_time);

        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return year + "/" + month + "/" + request.getContractNumber() + "/" + request.getMeterNumber() + "_"
                + dayOfMonth + "_" + month + "_" + year + "_" + hour + "_" + minute + "_" + second + ".jpg";
    }
}
