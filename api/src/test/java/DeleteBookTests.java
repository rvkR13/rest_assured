import dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ResponseWrapper;

import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
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
    @BeforeEach
    public void setUp() {
        AuthRequest requestAuth = getSuccessAuth();
        ResponseWrapper responseWrapperAuth = steps.auth(requestAuth);
        token = responseWrapperAuth.as(AuthResponse.class).getToken();
        request = getAddBookRequestSuccess();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        bookId = responseWrapper.as(AddNewBookResponse.class).getBookingid();
    }

    @Test
    @DisplayName("Successful delete book")
    public void testDeleteBook() {
        steps.deleteBook(String.valueOf(bookId), token);
        ResponseWrapper responseWrapperFind = steps.findBook(String.valueOf(bookId));
        assertSoftly(
                softAssertions -> softAssertions
                        .assertThat(responseWrapperFind.getStatusCode())
                        .withFailMessage("статус код не совпадает")
                        .isEqualTo(SC_NOT_FOUND)
        );
    }

    @Test
    @DisplayName("Successful deleting an already deleted  book")
    public void testDeletingDRemote() {
        steps.deleteBook(String.valueOf(bookId), token);
        ResponseWrapper responseWrapper = steps.deleteBook(String.valueOf(bookId), token);
        assertSoftly(
                softAssertions -> softAssertions
                        .assertThat(responseWrapper.getStatusCode())
                        .withFailMessage("статус код не совпадает")
                        .isEqualTo(SC_METHOD_NOT_ALLOWED)
        );
    }
}