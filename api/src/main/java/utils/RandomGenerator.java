package utils;

import com.github.javafaker.Faker;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

/**
 * Вспомогательный класс с генерацией тестовых данных
 */
public class RandomGenerator {
    /**
     * Экземпляр класса Faker
     */
    private static final Faker faker = new Faker();

    private static final DateTimeFormatter format = DateTimeFormatter.ISO_LOCAL_DATE.withZone(ZoneId.systemDefault());

    /**
     * получение рандомного Firstname
     *
     * @return
     */
    public static String getRandomFirstname() {
        return faker.name().firstName();
    }

    /**
     * получение рандомного lastname
     *
     * @return
     */
    public static String getRandomLastname() {
        return faker.name().lastName();
    }

    /**
     * Генерация TotalPrice
     *
     * @return random TotalPrice
     */
    public static int randomTotalPrice() {
        return faker.random().nextInt(1, 200);
    }

    /**
     * генерация Depositpaid
     *
     * @return DepositPaid true or false
     */
    public static boolean getDepositPaid() {
        return faker.random().nextBoolean();
    }

    /**
     * генерация additionalneeds
     *
     * @return AdditionalNeeds
     */
    public static String getRandomAdditionalNeeds() {
        return faker.friends().character();
    }

    /**
     * Метод получения текущей даты начала
     *
     * @return случайную дату
     */

    public static String getRandomDataIN() {
        return ZonedDateTime.now().format(format);
    }

    /**
     * Метод получения текущей даты начала
     *
     * @return случайную дату
     */
    public static String getRandomDataOUT() {
        int a = 1;
        int b = 99;
        int num = (int) ((Math.random() * (b - a)) + a);
        return ZonedDateTime.now().plusWeeks(num).format(format);
    }

    /**
     * генерация случайных числел для негативных тестов
     */
    static int InputNum() {
        return faker.random().nextInt(1, 200);
    }

    /**
     * Невалидный иsername
     */
    public static final String ERROR_USERNAME = "admin1";
    /**
     * Невалидный PASSWORD
     */
    public static final String ERROR_PASSWORD = "password1231";
    /**
     * Сообщение при неудачном запросе авторизации
     */
    public static final String MESSAGE_ERROR_AUTH = "Bad credentials";
    /**
     * несуществующий  id
     */
    public static String INVALID_ID_FOR_FIND_BOOK = "888888888";

    private static Stream<Object> provideStringsForIsBlank() {
        return Stream.of(
                null, 1);
    }
}