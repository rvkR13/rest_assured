import dto.AddNewBookRequest;
import dto.AddNewBookResponse;
import dto.AuthRequest;
import dto.AuthResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ResponseWrapper;

import static io.qameta.allure.Allure.step;
import static org.apache.http.HttpStatus.*;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.TestObjectBuilder.getAddBookRequestSuccess;
import static utils.TestObjectBuilder.getSuccessAuth;

/**
 * Тесты на удаление объекта
 * ручка http://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-DeleteBooking
 */
public class DeleteBookTests extends BaseTest {
    private Integer bookId;
    private String token;
    private AddNewBookRequest request;

    /**
     * Метод выполняемый перед каждым тестом.
     * getSuccessAuth - получение токена авторизации
     * getAddBookRequestSuccess- создание объекта для его последующего удаления
     */
//    @BeforeEach
//    public void setUp() {
//        AuthRequest requestAuth = getSuccessAuth();
//        ResponseWrapper responseWrapperAuth = steps.auth(requestAuth);
//        token = responseWrapperAuth.as(AuthResponse.class).getToken();
//        request = getAddBookRequestSuccess();
//        ResponseWrapper responseWrapper = steps.createNewBook(request);
//        bookId = responseWrapper.as(AddNewBookResponse.class).getBookingid();
//    }
    @Test
    @DisplayName("Successful delete book")
    public void testDeleteBook() {
        step("Проверка получения токена авторизации", () ->
        {
            AuthRequest requestAuth = getSuccessAuth();
            ResponseWrapper responseAuth = steps.auth(requestAuth);
            token = responseAuth.as(AuthResponse.class).getToken();
            assertEquals(responseAuth.getStatusCode(), SC_OK);
        });
        step("Проверка создания новой книги", () ->
        {
            request = getAddBookRequestSuccess();
            ResponseWrapper responseCreate = steps.createNewBook(request);
            AddNewBookResponse response = responseCreate.as(AddNewBookResponse.class);
            bookId = responseCreate.as(AddNewBookResponse.class).getBookingid();
            assertEquals(responseCreate.getStatusCode(), SC_OK);
            assertEquals(request.getFirstname(),response.getBooking().getFirstname());
            assertEquals(request.getLastname(),response.getBooking().getLastname());
        });
        step("Удаление созданной книги", () ->
        {
            ResponseWrapper responseDelete = steps.deleteBook(String.valueOf(bookId), token);
            assertEquals(responseDelete.getStatusCode(), SC_CREATED);
        });
        step("Удаление  ранее удаленной книги", () ->
        {
            ResponseWrapper responseDelete = steps.deleteBook(String.valueOf(bookId), token);
            assertEquals(responseDelete.getStatusCode(), SC_METHOD_NOT_ALLOWED);
        });
    }
}