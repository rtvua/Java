package lab4;

import java.util.UUID;

public class AirportApp {
    public static void main(String[] args) {
        //Person person = new Person.Builder().setName("Joe").setSurname("Parkinson").setPatronymic("Jacks").setPassportID(UUID.randomUUID()).build();
        //System.out.println(person);

        //Employee employee = new Employee.Builder().setPerson(person).setPosition("Top-manager").setWorkerID(UUID.randomUUID()).build();
        //System.out.println(employee);

        //Person person1 = new Person.Builder().setName("Artur").setSurname("Washington").setPatronymic("John")
        //        .setPassportID(UUID.randomUUID()).build();
        //Passenger passenger = new Passenger.Builder().setPerson(person1).setPassengerID(UUID.randomUUID()).build();
        //System.out.println(passenger);

        try {
            Person person2 = new Person.Builder().setName("Joe").setSurname("jack").setPatronymic("john").setPassportID(UUID.randomUUID()).build();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Employee employee1 = new Employee.Builder().setSurname("Adams").build();   //Exception - IllegalArgument
        System.out.println(employee1);
    }
}
