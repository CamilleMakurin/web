package com.example.JavaReack.healthcare.model;

import com.example.JavaReack.jugtours.model.User;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "BLOOD_PRESURE_MSRMNT")
public class BloodPressureMeasurement {

    @Id
    @GeneratedValue
    Long id;
    @Column
    LocalDateTime measurementTime;
    @Column
    String highPressure;
    @Column
    String lowPressure;
    @Column
    String heartRate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USERID")
    User user;

}
