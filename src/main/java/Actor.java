import java.time.LocalDate;
import java.util.Objects;

public class Actor {
    private String name;
    private String surname;
    private LocalDate birthdate;
    private String birthplace;
    private double rowth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirth_place(String birthplace) {
        this.birthplace = birthplace;
    }

    public double getRowth() {
        return rowth;
    }

    public void setRowth(double rowth) {
        this.rowth = rowth;
    }

    public static class Builder{

        private Actor newactor;

        public Builder(){
            newactor = new Actor();
        }

        public Builder withname(String name) {
            newactor.name = name;
            return this;
        }

        public Builder withsurname(String surname) {
            newactor.surname = surname;
            return this;
        }

        public Builder withbirthdate(LocalDate birthdate){
            newactor.birthdate = birthdate;
            return this;
        }

        public Builder withbirthplace(String birthplace){
            newactor.birthplace = birthplace;
            return this;
        }

        public Builder withrowth(double rowth){
            newactor.rowth = rowth;
            return this;
        }

        public Actor build(){

            return newactor;
        }
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birth_date=" + birthdate +
                ", birth_place='" + birthplace + '\'' +
                ", rowth=" + rowth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(name, actor.name) &&
                Objects.equals(surname, actor.surname) &&
                Objects.equals(birthdate, actor.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthdate);
    }
}


