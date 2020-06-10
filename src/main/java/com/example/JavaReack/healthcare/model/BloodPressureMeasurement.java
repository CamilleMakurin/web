package com.example.JavaReack.healthcare.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "BLOOD_PRESURE_MSRMNT")
public class BloodPressureMesurement {

    @Id
    @GeneratedValue
    Long id;
    @Column
    LocalDateTime measurementTime;
    @Column
    String highPresure;
    @Column
    String lowPreasure;
    @Column
    String heartRate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    User user;

}
