package lab4;

import jakarta.validation.constraints.Pattern;

import java.util.Objects;
import java.util.UUID;

public class Passenger extends Person {
    @Pattern(regexp = "\\b[0-9a-f]{8}\\b-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-\\b[0-9a-f]{12}\\b", message = "PassengerID must be an UUID number")
    private UUID passengerID;

    private Passenger(){
        name = null;
        surname = null;
        patronymic = null;
        passengerID = null;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        if (!super.equals(o)) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(passengerID, passenger.passengerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengerID);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerID=" + passengerID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", passportID=" + passportID +
                '}';
    }


    public static class Builder{
        private Passenger passenger;

        public Builder(){ passenger = new Passenger();}

        public Builder setPerson(Person person){
            passenger.name = person.name;
            passenger.surname = person.surname;
            passenger.patronymic = person.patronymic;
            passenger.passportID = person.passportID;
            return this;
        }

        public Passenger.Builder setName(String name){
            passenger.name = name;
            return this;
        }

        public Passenger.Builder setSurname(String surname){
            passenger.surname = surname;
            return this;
        }

        public Passenger.Builder setPatronymic(String patronymic){
            passenger.patronymic = patronymic;
            return this;
        }

        public Passenger.Builder setPassportID(UUID passportID){
            passenger.passportID = passportID;
            return this;
        }

        public  Builder setPassengerID(UUID passengerID){
            passenger.passengerID = passengerID;
            return this;
        }


        public Passenger build(){
            return passenger;
        }

    }
}

