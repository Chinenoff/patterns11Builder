import java.util.OptionalInt;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(OptionalInt.of(31))
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        //Проверяем день рождения - happyBirthday()
        System.out.println("У мамы день рождения! Сейчас её возраст  " + mom.getAge().getAsInt());
        mom.happyBirthday();
        System.out.println("Маме теперь " + mom.getAge().getAsInt());

        //Проверяем hasAge() и hasAddress()
        Person pap = new PersonBuilder()
                .setName("Лев")
                .setSurname("Толстой")
                .build();
        System.out.println("У " + pap + " возраст, " + pap.hasAge() + " он из города " + pap.hasAddress() + " " + pap.getAddress());

        //Проверяем исключения
        try {
            // Не хватает обяхательных полей
            new PersonBuilder()
                    .build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(OptionalInt.of(-100)).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}