package com.example.restapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "meter_data")
public class MeterData {
    @Id
    private String contractNumber;

    private String meterNumber;
    @Column(name = "meter_reading")
    private String meterReading;
    private String photoPath;
    private LocalDateTime timestamp;

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setMeterReading(String meterReading) {
        this.meterReading = meterReading;
    }
}
