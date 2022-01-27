package lab3;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class AirportApp {
    public static List<Employee> employees = new ArrayList<Employee>();
    public static List<Person> persons = new ArrayList<Person>();

    List<Person> getByName(String name){
        List<Person> newList = new ArrayList<Person>();
        for (Person p:persons){
            if(p.getName() == name) newList.add(p);
        }
        for (Employee e:employees){
            if(e.getName() == name) newList.add(e);
        }
        return newList;
    }

    List<Employee> getByPosition(String position){
        List<Employee> newList = new ArrayList<Employee>();
        for (Employee e:employees){
            if(e.getPosition() == position) newList.add(e);
        }
        return newList;
    }

    List<Employee> sortByPosition(){
        List<Employee> newList = new ArrayList<Employee>();
        List<String> posList = new ArrayList<String>();
        String position = null;
        for (Employee e:employees){
            position = e.getPosition();
            if(!posList.contains(position)) posList.add(position);
        }
        posList.sort(Comparator.naturalOrder());
        for (String pos:posList){
            for(Employee e:employees){
                if(e.getPosition() == pos) newList.add(e);
            }
        }
        return newList;
    }


    public static void main(String[] args) {
        Person p1 = new Person.Builder().setName("Joe").setSurname("Parkinson").setPatronymic("Jacks").setPassportID(UUID.randomUUID()).build();
        Person p2 = new Person.Builder().setName("Artur").setSurname("Washington").setPatronymic("John").setPassportID(UUID.randomUUID()).build();
        Person p3 = new Person.Builder().setName("Roman").setSurname("Steel").setPatronymic("Andrew").setPassportID(UUID.randomUUID()).build();
        Person p4 = new Person.Builder().setName("Alex").setSurname("Aaron").setPatronymic("John").setPassportID(UUID.randomUUID()).build();
        Person p5 = new Person.Builder().setName("Artur").setSurname("Smith").setPatronymic("Joe").setPassportID(UUID.randomUUID()).build();



        Employee e1 = new Employee.Builder().setPerson(p1).setPosition("Top-manager").setWorkerID(UUID.randomUUID()).build();
        Employee e2 = new Employee.Builder().setPerson(p2).setPosition("Pilot").setWorkerID(UUID.randomUUID()).build();
        Employee e3 = new Employee.Builder().setPerson(p3).setPosition("Manager").setWorkerID(UUID.randomUUID()).build();
        Employee e4 = new Employee.Builder().setPerson(p4).setPosition("Air controller").setWorkerID(UUID.randomUUID()).build();
        Employee e5 = new Employee.Builder().setPerson(p5).setPosition("Pilot").setWorkerID(UUID.randomUUID()).build();


        AirportApp airport = new AirportApp();

        airport.persons.add(p1);
        airport.persons.add(p2);
        airport.persons.add(p3);
        airport.persons.add(p4);
        airport.persons.add(p5);


        airport.employees.add(e1);
        airport.employees.add(e2);
        airport.employees.add(e3);
        airport.employees.add(e4);
        airport.employees.add(e5);

        System.out.println(airport.getByPosition("Pilot") + "\n");
        System.out.println(airport.getByName("Artur") + "\n");
        System.out.println("Sorting: " + airport.sortByPosition() + "\n");

        Stream<Person> p = airport.persons.stream();
        Stream<Employee> e = airport.employees.stream();



        p.filter(x -> x.getName().length() < 5).forEach(System.out::println);
        e.filter(x -> x.getName() == "Alex").forEach(System.out::println);


        e = airport.employees.stream();
        e.filter(x -> x.getPosition() == "Top-manager").forEach(System.out::println);

        e = airport.employees.stream();
        Map<String, List<Employee>> positions = e.collect(groupingBy(x-> x.getPosition()));
        System.out.println(positions);
    }
}
