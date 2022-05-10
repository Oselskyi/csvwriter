package com.learning.csv.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Interaction extends ConverterEntity {

    String id;
    Time startTime;
    Time stopTime;
    String archivingLocation;
    String initiator;
    List<String> participants;

    @Override
    public String toString() {
        return
                id + ',' +
                 startTime + ',' +
                 stopTime + ',' +
                 archivingLocation + ',' +
                 initiator + ',' +
                 "'" + participants + "'";
    }
}
