package utils;

import config.BaseConfig;
import dto.AddNewBookRequest;
import dto.AuthRequest;
import org.aeonbits.owner.ConfigFactory;

import static utils.RandomGenerator.*;

/**
 * Вспомагательный класс для формирования тестовых объектов
 * Сваггер http://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-CreateBooking
 */
public class TestObjectBuilder {
    private static final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * успешный запрос на создание записи
     *
     * @return
     */
    public static AddNewBookRequest getAddBookRequestSuccess() {
        return AddNewBookRequest.builder()
                .firstname(getRandomFirstname())
                .lastname(getRandomLastname())
                .totalprice(randomTotalPrice())
                .depositpaid(getDepositPaid())
                .additionalneeds(getRandomAdditionalNeeds())
                .bookingdates(AddNewBookRequest.Bookingdates.builder()
                        .checkin(getRandomDataIN())
                        .checkout(getRandomDataOUT())
                        .build())
                .build();
    }

    /**
     * запрос на создание записи с additionalneeds(null)
     *
     * @return
     */
    public static AddNewBookRequest getAddBookRequestNullAdditionalneeds() {
        return AddNewBookRequest.builder()
                .firstname(getRandomFirstname())
                .lastname(getRandomLastname())
                .totalprice(randomTotalPrice())
                .depositpaid(getDepositPaid())
                .additionalneeds(null)
                .bookingdates(AddNewBookRequest.Bookingdates.builder()
                        .checkin(getRandomDataIN())
                        .checkout(getRandomDataOUT())
                        .build())
                .build();
    }

    /**
     * успешная Авторизация
     */
    public static AuthRequest getSuccessAuth() {
        return AuthRequest.builder()
                .username(config.username())
                .password(config.password())
                .build();
    }

    /**
     * невалидный логин для Авторизации
     */
    public static AuthRequest getErrorAllDataAuth() {
        return AuthRequest.builder()
                .username(ERROR_USERNAME)
                .password(ERROR_PASSWORD)
                .build();
    }
}