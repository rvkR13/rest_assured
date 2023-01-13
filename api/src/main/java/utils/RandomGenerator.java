package utils;

import com.github.javafaker.Faker;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RandomGenerator {
    /**
     * Статус код успешного результата запроса
     */
    public static final int STATUS_CODE_OK = 200;
    /**
     * Статус код не успешного результата запроса
     */
    public static final int STATUS_CODE_ERROR_500 = 500;


    /**
     * Экземпляр класса Faker
     */
    private static final Faker faker = new Faker();

    /**
     *получение рандомного Firstname
     * @return
     */
    public static String getRandomFirstname() {
        return faker.name().firstName();
    }
    /**
     *получение рандомного lastname
     * @return
     */
    public static String getRandomLastname() {
        return faker.name().lastName();
    }
    /**
     * генерация totalPrice
     */

    static int RandomTotalPrice(){
        int min = 1;
        int max = 200;
        int number = max - min;
        Random random = new Random();
        int i = random.nextInt(number + 1);
        i += min;
        return i;
    }

    /**
     * генерация Depositpaid
     * @return
     */
    public static boolean getDepositpaid(){
        return faker.random().nextBoolean();
    }
    /**
     * генерация additionalneeds
     * @return
     */
    public static String getRandomAdditionalneeds(){
        return faker.friends().character();
    }
    /**
     * Метод получения текущей даты начала
     *
     * @return случайную дату
     */
    private static final DateTimeFormatter format = DateTimeFormatter.ISO_LOCAL_DATE.withZone(ZoneId.systemDefault());

    public static String getRandomDataIN() {
        return ZonedDateTime.now().format(format);
    }
    /**
     * Метод получения текущей даты начала
     *
     * @return случайную дату
     */
    public static String getRandomDataOUT(){
        int a= 1;
        int b= 99;
        int num= (int) ((Math.random() * ( b - a )) + a);
         return ZonedDateTime.now().plusWeeks(num).format(format);
    }
    /**
     * генерация чисел
     */
    static int InputNum(){
        int min = 1;
        int max = 10;
        int number = max - min;
        Random random = new Random();
        int i = random.nextInt(number + 1);
        i += min;
        return i;
    }

}
