package lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class AirportApp {
    public static void main(String[] args) {
        Person person = new Person.Builder().setName("Joe").setSurname("Parkinson").setPatronymic("Jacks").setPassportID(UUID.randomUUID()).build();
        System.out.println(person);

        Employee employee = new Employee.Builder().setPerson(person).setPosition("Top-manager").setWorkerID(UUID.randomUUID()).build();
        System.out.println(employee);

        Person person1 = new Person.Builder().setName("Artur").setSurname("Washington").setPatronymic("John")
               .setPassportID(UUID.randomUUID()).build();
        Passenger passenger = new Passenger.Builder().setPerson(person1).setPassengerID(UUID.randomUUID()).build();
        System.out.println(passenger);

        //Employee employee1 = new Employee.Builder().setSurname("Adams").build();   //Exception - IllegalArgument
        //System.out.println(employee1);
    }
}
