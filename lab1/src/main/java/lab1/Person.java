package lab1;


import java.util.Objects;
import java.util.UUID;

/**
 * @toString
 */

public class Person {
    protected String name;
    protected String surname;
    protected String patronymic;

    protected UUID passportID;

    protected Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                name + ", " +
                surname + ',' +
                patronymic + ',' +
                passportID +
                '}';
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
