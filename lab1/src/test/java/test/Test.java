package test;


import lab1.Employee;
import lab1.Person;
import lab1.Passenger;
import org.testng.annotations.DataProvider;

import java.rmi.server.ExportException;
import java.util.UUID;

public class Test {
    public static String name = "Peter", surname = "Morrison", patronymic = "Johnathan",
            position = "First pilot";

    @org.testng.annotations.Test(expectedExceptions = IllegalArgumentException.class)
    public void ExceptionWhenEmployeeNameIsNull(){
        Employee object = new Employee.Builder().setSurname(surname).setPatronymic(patronymic)
                .setWorkerID(UUID.randomUUID()).setPassportID(UUID.randomUUID()).setPosition(position).build();
    }

    @org.testng.annotations.Test(expectedExceptions = IllegalArgumentException.class)
    public void ExceptionWhenPassengerSurnameIsNull(){
        Passenger object1 = new Passenger.Builder().setName(name).setPatronymic(patronymic)
                .setPassportID(UUID.randomUUID()).setPassengerID(UUID.randomUUID()).build();
    }
    @org.testng.annotations.Test(expectedExceptions = IllegalArgumentException.class)
    public void ExceptionWhenNameIsNull(){
        Person object = new Person.Builder().setSurname(surname).setPatronymic(patronymic)
                .setPassportID(UUID.randomUUID()).build();
    }
    @org.testng.annotations.Test(expectedExceptions = IllegalArgumentException.class)
    public void ExceptionWhenSurnameIsNull(){
        Person object = new Person.Builder().setName(name).setPatronymic(patronymic).setPassportID(UUID.randomUUID()).build();
    }

    @org.testng.annotations.Test(expectedExceptions = IllegalArgumentException.class)
    public void ExceptionWhenPatronymicIsNull(){
        Person object = new Person.Builder().setName(name).setSurname(surname)
                .setPassportID(UUID.randomUUID()).build();
    }
    @org.testng.annotations.Test(expectedExceptions = IllegalArgumentException.class)
    public void ExceptionWhenIdIsNull(){
        Person object = new Person.Builder().setName(name).setSurname(surname).setPatronymic(patronymic).build();
    }

}
