package com.example.restapi.model;

public class DataUploadRequest {
    private String contractNumber;
    private String meterNumber;
    private String meterReading;
    private String photoBase64;

    // Конструктор без аргументов
    public DataUploadRequest() {
    }

    // Конструктор с аргументами
    public DataUploadRequest(String contractNumber, String meterNumber, String meterReading, String photoBase64) {
        this.contractNumber = contractNumber;
        this.meterNumber = meterNumber;
        this.meterReading = meterReading;
        this.photoBase64 = photoBase64;
    }

    // Геттеры и сеттеры
    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public String getMeterReading() {
        return meterReading;
    }

    public void setMeterReading(String meterReading) {
        this.meterReading = meterReading;
    }

    public String getPhotoBase64() {
        return photoBase64;
    }

    public void setPhotoBase64(String photoBase64) {
        this.photoBase64 = photoBase64;
    }
}
