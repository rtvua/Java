package lab4;

import jakarta.validation.constraints.Pattern;

import java.util.Objects;
import java.util.UUID;

public class Employee extends Person{
    @Pattern(regexp = "\\b[0-9a-f]{8}\\b-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-\\b[0-9a-f]{12}\\b", message = "WorkerID must be an UUID number")
    private UUID workerID;
    private String position;

    private Employee(Person person){
        name = person.name;
        surname = person.surname;
        patronymic = person.patronymic;
    }

    public Employee() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(workerID, employee.workerID) && Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), workerID, position);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "workerID=" + workerID +
                ", position='" + position + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", passportID=" + passportID +
                '}';
    }

    public static class Builder{
        private Employee employee;

        public Builder(){employee = new Employee(); }

        public Builder setPerson(Person person){
            employee.name = person.name;
            employee.surname = person.surname;
            employee.patronymic = person.patronymic;
            employee.passportID = person.passportID;
            return this;
        }

        public Builder setName(String name){
            employee.name = name;
            return this;
        }

        public Builder setSurname(String surname){
            employee.surname = surname;
            return this;
        }

        public Builder setPatronymic(String patronymic){
            employee.patronymic = patronymic;
            return this;
        }

        public Builder setPassportID(UUID passportID){
            employee.passportID = passportID;
            return this;
        }


        public Builder setPosition(String position){
            employee.position = position;
            return this;
        }

        public Builder setWorkerID(UUID workerID){
            employee.workerID = workerID;
            return this;
        }
        public Employee build(){
            return employee;
        }

    }

}
