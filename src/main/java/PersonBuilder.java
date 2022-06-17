import java.util.OptionalInt;

public class PersonBuilder {

    protected String name;
    protected String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected String address;

    public PersonBuilder() {
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(OptionalInt age) {
        if (age.getAsInt() < 0) {
            throw new IllegalArgumentException("Возраст не может быть меньше 0");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name != null && surname != null) {
            //if (!name.isBlank() || !surname.isBlank()) {
            // ??? почему при таком варианте не выбрасывается нужное исключение???
            return new Person(name, surname, age, address);
        }
        throw new IllegalStateException("Недостаточное количество данных");
    }
}
