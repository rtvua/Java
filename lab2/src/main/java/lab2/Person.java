package lab2;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import serizalize.Serializer;

import java.io.*;
import java.util.*;

public class Person implements Serializer {
    protected String name;
    protected String surname;
    protected String patronymic;

    protected UUID passportID;

    protected Person() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPassportID(UUID passportID) {
        this.passportID = passportID;
    }

    @Override
    public String toString() {
        return "Person{" +
                name + ", " +
                surname + ", " +
                patronymic + ", " +
                passportID +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return passportID == person.passportID && name.equals(person.name) && surname.equals(person.surname) && patronymic.equals(person.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronymic, passportID);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public UUID getPassportID() {
        return passportID;
    }

    @Override
    public String toJsonString() {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Person fromJsonString(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = null;
        try {
            person = objectMapper.readValue(json, Person.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public void toJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("person.json");
            file.createNewFile();
            objectMapper.writeValue(file, this);
        }
        catch (FileNotFoundException e){
            System.out.println("Error making json file");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Error making json");
            e.printStackTrace();
        }
    }

    @Override
    public Person fromJsonFile(String filename) {
        try{
            File file = new File(filename);
            Scanner myReader = new Scanner(file);
            if (myReader.hasNextLine()){
                String json = myReader.nextLine();
                Person person = new Person();
                ObjectMapper objectMapper = new ObjectMapper();
                person = objectMapper.readValue(json, Person.class);
                myReader.close();
                return person;
            }

        }
        catch (IOException e){
            System.out.println("Error occurred.");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toXmlString(){
        XmlMapper xmlMapper = new XmlMapper();
        String xml = null;
        try {
            xml = xmlMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return xml;
    }

    @Override
    public Person fromXmlString(String xml){
        XmlMapper xmlMapper = new XmlMapper();
        Person person = null;
        try {
            person = xmlMapper.readValue(xml, Person.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public void toXmlFile() {
        try{
            XmlMapper xmlMapper = new XmlMapper();
            File file = new File("person.xml");
            file.createNewFile();
            xmlMapper.writeValue(file, this);

        }
        catch (IOException e){
            e.printStackTrace();
        }


    }

    @Override
    public Person fromXmlFile(String filename) {
        try{
            File file = new File(filename);
            Scanner myReader = new Scanner(file);
            if (myReader.hasNextLine()){
                String xml = myReader.nextLine();
                Person person = new Person();
                XmlMapper xmlMapper = new XmlMapper();
                person = xmlMapper.readValue(xml, Person.class);
                myReader.close();
                return person;
            }

        }
        catch (IOException e){
            System.out.println("Error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toTextString() {
        String text = this.toString();
        return text;
    }

    @Override
    public Person fromTextString(String text) {
            List<String> list = new ArrayList<String>();
            list = List.of(text.split(", ", 4));
            setName(list.get(0).toString().replace("Person{", ""));
            setSurname(list.get(1));
            setPatronymic(list.get(2));
            setPassportID(UUID.fromString(list.get(3).toString().replace("}", "")));
            return this;

    }

    @Override
    public void toTextFile() {
        String text = this.toString();
        File file = new File("person.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("person.txt");
            myWriter.write(text);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Person fromTextFile(String filename) {

        String text = new String();

        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            if(scanner.hasNextLine())text = scanner.nextLine();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        fromTextString(text);
        return this;
    }


    public static class Builder {
        private Person person;
        public Builder(){
            person = new Person();
        }
        public Builder setName(String name){
            person.name = name;
            return this;
        }
        public Builder setSurname(String surname){
            person.surname = surname;
            return this;
        }
        public Builder setPatronymic(String patronymic){
            person.patronymic = patronymic;
            return this;
        }
        public Builder setPassportID(UUID passportID){
            person.passportID = passportID;
            return this;
        }
        public Person build(){
            if(person.name == null) throw new IllegalArgumentException("Name can't be null");
            if(person.surname == null) throw new IllegalArgumentException("Surname can't be null");
            if(person.patronymic == null) throw new IllegalArgumentException("Patronymic can't be null");
            if(person.passportID == null) throw new IllegalArgumentException("Name can't be null");
            return person;
        }
    }




}
