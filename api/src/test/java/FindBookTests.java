import dto.AddNewBookRequest;
import dto.AddNewBookResponse;
import dto.BookingFind;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ResponseWrapper;

import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static utils.RandomGenerator.*;
import static utils.TestObjectBuilder.getAddBookRequestSuccess;

/**
 * Тесты по поиску объекта. Booking - GetBooking
 * http://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-GetBooking
 */
public class FindBookTests extends BaseTest {
    private Integer bookId;
    private AddNewBookRequest request;
    /**
     * Метод выполняемый перед каждым тестом.
     * getAddBookRequestSuccess- создание объекта для его последующего поиска
     */
    @BeforeEach
    public void setUp() {
        request = getAddBookRequestSuccess();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        bookId = responseWrapper.as(AddNewBookResponse.class).getBookingid();
    }

    @Test
    @DisplayName("Successful find book")
    public void testFindBook() {
        ResponseWrapper responseWrapper = steps.findBook(String.valueOf(bookId));
        BookingFind getBook = responseWrapper.as(BookingFind.class);

        assertSoftly(
                softAssertions -> {
                    softAssertions
                            .assertThat(responseWrapper.getStatusCode())
                            .withFailMessage("статус код не совпадает")
                            .isEqualTo(SC_OK);
                    softAssertions
                            .assertThat(getBook.getFirstname())
                            .withFailMessage("Firstname не совпадает")
                            .isEqualTo(request.getFirstname());
                    softAssertions
                            .assertThat(getBook.getLastname())
                            .withFailMessage("Lastname не совпадает")
                            .isEqualTo(request.getLastname());
                    softAssertions
                            .assertThat(getBook.getDepositpaid())
                            .withFailMessage("Depositpaid не совпадает")
                            .isEqualTo(request.getDepositpaid());
                    softAssertions
                            .assertThat(getBook.getAdditionalneeds())
                            .withFailMessage("Additionalneeds не совпадает")
                            .isEqualTo(request.getAdditionalneeds());
                    softAssertions
                            .assertThat(getBook.getTotalprice())
                            .withFailMessage("Totalprice не совпадает")
                            .isEqualTo(request.getTotalprice());
                    softAssertions
                            .assertThat(getBook.getBookingdates().getCheckin())
                            .withFailMessage("Checkin не совпадает")
                            .isEqualTo(request.getBookingdates().getCheckin());
                    softAssertions
                            .assertThat(getBook.getBookingdates().getCheckout())
                            .withFailMessage("Checkout не совпадает")
                            .isEqualTo(request.getBookingdates().getCheckout());
                }
        );
    }

    @Test
    @DisplayName("Book not found")
    public void testFindBookNotFound() {
        ResponseWrapper responseWrapper = steps.findBook(String.valueOf(INVALID_ID_FOR_FIND_BOOK));
        assertSoftly(
                softAssertions -> softAssertions
                        .assertThat(responseWrapper.getStatusCode())
                        .withFailMessage("статус код не совпадает")
                        .isEqualTo(SC_NOT_FOUND)
        );
    }
}