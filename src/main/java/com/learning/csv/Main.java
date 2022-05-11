package com.learning.csv;

import com.learning.csv.entity.Interaction;
import com.learning.csv.entity.Person;
import com.learning.csv.service.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        List<Person> people = List.of(new Person(1, "Antoha", "MC", 15),
        new Person(2, "Max", "Last", 43),
        new Person(3, "Victor", "Shtil", 32));


//        Converter<Person> personConverter = new CSVConverter<>(new CSVWriter("src/test/resources/test.csv"));
//        personConverter.convert(new Person(1, "Antoha", "MC", 15));



    }


}
