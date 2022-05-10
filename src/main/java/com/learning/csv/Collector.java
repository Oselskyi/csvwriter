package com.learning.csv;

import com.learning.csv.entity.Interaction;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Collector {

    public static List<Interaction> getList(){
        Interaction interaction1 = new Interaction(
                "2",
                Time.valueOf(LocalTime.now().minusHours(4)),
                Time.valueOf(LocalTime.now()),
                "c/users/java",
                "LG",
                List.of("4", "5", "6"));

        Interaction interaction2 = new Interaction("3", Time.valueOf(LocalTime.now().minusHours(8)),
                Time.valueOf(LocalTime.now().minusHours(2)),
                "users/source/java", "Dell", List.of("7", "8", "9"));
        Interaction interaction3 = new Interaction("4", Time.valueOf(LocalTime.now().minusHours(2)),
                Time.valueOf(LocalTime.now().minusHours(5)),
                "users/samsung/java", "Samsung", List.of("7", "22", "24"));
        Interaction interaction4 = new Interaction("5", Time.valueOf(LocalTime.now().minusHours(10)),
                Time.valueOf(LocalTime.now().minusHours(6)),
                "users/source/asus", "Asus", List.of("10", "11", "9"));

        List<Interaction> list = new ArrayList<>();

        list.add(new Interaction("1", Time.valueOf(LocalTime.now().minusHours(1)),
                Time.valueOf(LocalTime.now()), "src/java/com/learning",
                "HP", List.of("1", "2", "3")));
        list.add(interaction1);
        list.add(interaction2);
        list.add(interaction3);
        list.add(interaction4);
        return list;
    }
}
