package lab4;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import javax.validation.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Person {
    @Size(min = 3, max = 15, message = "Name must be more than 3 and less than 15 symbols")
    protected String name;
    @Size(min = 2, max = 15, message = "Surname must be more than 2 and less than 15 symbols")
    protected String surname;
    @Size(min = 3, max = 15, message = "Patronymic must be more than 3 and less than 15 symbols")
    protected String patronymic;

    @Pattern(regexp = "\\b[0-9a-f]{8}\\b-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-\\b[0-9a-f]{12}\\b", message = "PassportID must be an UUID number")
    protected UUID passportID;

    protected Person() {
    }
    public Person(Builder builder){
        this.name = builder.person.name;
        this.surname = builder.person.surname;
        this.patronymic = builder.person.patronymic;
        this.passportID = builder.person.passportID;
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

        public void validate() throws IllegalArgumentException{
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Person person = new Person(this);
            Set<ConstraintViolation<Person>> violations = validator.validate(person);

            StringBuilder mb = new StringBuilder();
            for (ConstraintViolation<Person> violation:violations){
                mb.append("Error for " + violation.getInvalidValue() + ": " + violation.getMessage()).append("\n");
            }
            if (mb.length() > 0){
                throw new IllegalArgumentException(mb.toString());
            }

        }


//        public void validate() throws IllegalArgumentException{
//            jakarta.validation.ValidatorFactory factory = jakarta.validation.Validation.buildDefaultValidatorFactory();
//            jakarta.validation.Validator validator = factory.getValidator();
//            Person person = new Person(this);
//            Set<jakarta.validation.ConstraintViolation<Person>> violations = validator.validate(person);
//
//            StringBuilder mb = new StringBuilder();
//            for (ConstraintViolation<Person> violation:violations){
//                mb.append("Error for " + violation.getInvalidValue() + ": " + violation.getMessage()).append("\n");
//            }
//            if (mb.length() > 0){
//                throw new IllegalArgumentException(mb.toString());
//            }
//
//        }


        public Person build() throws IllegalArgumentException{
            validate();
            return person;
        }
    }

}
