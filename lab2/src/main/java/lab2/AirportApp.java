package lab2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class AirportApp {
    public static void main(String[] args) {

        String filename = "persons.txt";


        Person p1 = new Person.Builder().setName("Joe").setSurname("Parkinson").setPatronymic("Jacks").setPassportID(UUID.randomUUID()).build();
        Person p2 = new Person.Builder().setName("Artur").setSurname("Washington").setPatronymic("John").setPassportID(UUID.randomUUID()).build();
        Person p3 = new Person.Builder().setName("Roman").setSurname("Steel").setPatronymic("Andrew").setPassportID(UUID.randomUUID()).build();
        Person p4 = new Person.Builder().setName("Alex").setSurname("Aaron").setPatronymic("John").setPassportID(UUID.randomUUID()).build();
        Person p5 = new Person.Builder().setName("Artur").setSurname("Smith").setPatronymic("Joe").setPassportID(UUID.randomUUID()).build();


        String json = "person.json", xml = "person.xml", text = "person.txt";

        System.out.println(p1.toJsonString());
        p1.toJsonFile();
        p1.fromJsonFile(json);
        System.out.println(p1);


        System.out.println(p2.toXmlString());
        p2.fromXmlString(p2.toXmlString());
        System.out.println(p2);

        p2.toXmlFile();


        System.out.println(p3.toTextString());

        String test = p3.toTextString();
        p3.fromTextString(test);
        System.out.println(p3);

        p4.toTextFile();

        p4.fromTextFile(text);
        System.out.println(p4);



    }
}
