import dto.AddNewBookRequest;
import dto.AddNewBookResponse;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import utils.ResponseWrapper;

import static org.apache.http.HttpStatus.SC_INTERNAL_SERVER_ERROR;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import static utils.TestObjectBuilder.*;
@Epic("Добавление книг")
@Feature("Проверка раздела 'Добавление книг в магазин'")
public class AddNewBookTests extends BaseTest {
    /**
     * Тесты на добавление нового объекта book
     * ручка  http://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-CreateBooking
     */

    @Test
    @DisplayName("Успешное добавление книги с заполнением всех полей")
    public void testAddBook() {
        AddNewBookRequest request = getAddBookRequestSuccess();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        AddNewBookResponse response = responseWrapper.as(AddNewBookResponse.class);
        assertSoftly(
                softAssertions -> {
                    softAssertions
                            .assertThat(responseWrapper.getStatusCode())
                            .withFailMessage("статус код не совпадает")
                            .isEqualTo(SC_OK);
                    softAssertions
                            .assertThat(response.getBooking().getFirstname())
                            .withFailMessage("Firstname не совпадает")
                            .isEqualTo(request.getFirstname());
                    softAssertions
                            .assertThat(response.getBooking().getLastname())
                            .withFailMessage("Lastname не совпадает")
                            .isEqualTo(request.getLastname());
                    softAssertions
                            .assertThat(response.getBooking().getTotalprice())
                            .withFailMessage("Totalprice не совпадает")
                            .isEqualTo(request.getTotalprice());
                    softAssertions
                            .assertThat(response.getBooking().getAdditionalneeds())
                            .withFailMessage("Additionalneeds не совпадает")
                            .isEqualTo(request.getAdditionalneeds());
                    softAssertions
                            .assertThat(response.getBooking().getBookingdates().getCheckin())
                            .withFailMessage("Checkin не совпадает")
                            .isEqualTo(request.getBookingdates().getCheckin());
                    softAssertions
                            .assertThat(response.getBooking().getBookingdates().getCheckout())
                            .withFailMessage("Checkout не совпадает")
                            .isEqualTo(request.getBookingdates().getCheckout());
                    softAssertions
                            .assertThat(response.getBooking().getDepositpaid())
                            .withFailMessage("depositpaid не совпадает")
                            .isEqualTo(request.getDepositpaid());
                }
        );
    }

    @Test()
    @DisplayName("Успешное добавление книги с заполнение только обязательных полей")
    public void testAddBookNullAdditionalNeeds() {
        AddNewBookRequest request = getAddBookRequestNullAdditionalneeds();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        AddNewBookResponse response = responseWrapper.as(AddNewBookResponse.class);
        assertSoftly(
                softAssertions -> {
                    softAssertions
                            .assertThat(responseWrapper.getStatusCode())
                            .withFailMessage("статус код не совпадает")
                            .isEqualTo(SC_OK);
                    softAssertions
                            .assertThat(response.getBooking().getFirstname())
                            .withFailMessage("Firstname не совпадает")
                            .isEqualTo(request.getFirstname());
                    softAssertions
                            .assertThat(response.getBooking().getLastname())
                            .withFailMessage("Lastname не совпадает")
                            .isEqualTo(request.getLastname());
                    softAssertions
                            .assertThat(response.getBooking().getTotalprice())
                            .withFailMessage("Totalprice не совпадает")
                            .isEqualTo(request.getTotalprice());
                    softAssertions
                            .assertThat(response.getBooking().getAdditionalneeds())
                            .withFailMessage("Additionalneeds не совпадает")
                            .isEqualTo(request.getAdditionalneeds());
                    softAssertions
                            .assertThat(response.getBooking().getBookingdates().getCheckin())
                            .withFailMessage("Checkin не совпадает")
                            .isEqualTo(request.getBookingdates().getCheckin());
                    softAssertions
                            .assertThat(response.getBooking().getBookingdates().getCheckout())
                            .withFailMessage("Checkout не совпадает")
                            .isEqualTo(request.getBookingdates().getCheckout());
                    softAssertions
                            .assertThat(response.getBooking().getDepositpaid())
                            .withFailMessage("depositpaid не совпадает")
                            .isEqualTo(request.getDepositpaid());
                }
        );
    }

    @ParameterizedTest(name = "{displayName}: {0}")
    @DisplayName("Server Error response  without field FirstName or number value")
    @MethodSource("utils.RandomGenerator#provideStringsForIsBlank")
    public void testAddBookFirstNameNullOrInteger(Object value) {
        AddNewBookRequest request = AddNewBookRequest.builder().firstname(value)
                .build();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        assertSoftly(
                softAssertions -> softAssertions
                        .assertThat(responseWrapper.getStatusCode())
                        .withFailMessage("test fail")
                        .isEqualTo(SC_INTERNAL_SERVER_ERROR)
        );
    }

    @ParameterizedTest(name = "{displayName}: {0}")
    @DisplayName("Server Error response  without field LastName or number value")
    @MethodSource("utils.RandomGenerator#provideStringsForIsBlank")
    public void testAddBookLastNameNullOrInteger(Object value) {
        AddNewBookRequest request = AddNewBookRequest.builder().lastname(value)
                .build();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        assertSoftly(
                softAssertions -> softAssertions
                        .assertThat(responseWrapper.getStatusCode())
                        .withFailMessage("test fail")
                        .isEqualTo(SC_INTERNAL_SERVER_ERROR)
        );
    }

    @ParameterizedTest(name = "{displayName}: {0}")
    @DisplayName("Server Error response  without field TotalPrice ")
    @NullSource
    public void testAddBookTotalPriceNull(Object value) {
        AddNewBookRequest request = AddNewBookRequest.builder().totalprice((Integer) value)
                .build();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        assertSoftly(
                softAssertions -> softAssertions
                        .assertThat(responseWrapper.getStatusCode())
                        .withFailMessage("test fail")
                        .isEqualTo(SC_INTERNAL_SERVER_ERROR)
        );
    }

    @ParameterizedTest(name = "{displayName}: {0}")
    @DisplayName("Server Error response  without field DepositPaid")
    @NullSource
    public void testAddBookDepositPaidNull(Object value) {
        AddNewBookRequest request = AddNewBookRequest.builder().depositpaid(value)
                .build();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        assertSoftly(
                softAssertions -> softAssertions
                        .assertThat(responseWrapper.getStatusCode())
                        .withFailMessage("test fail")
                        .isEqualTo(SC_INTERNAL_SERVER_ERROR)
        );
    }

    @ParameterizedTest(name = "{displayName}: {0}")
    @DisplayName("Server Error response  without field CheckIn")
    @NullSource
    public void testAddBookCheckInNull(Object value) {
        AddNewBookRequest request = AddNewBookRequest.builder().bookingdates(AddNewBookRequest.Bookingdates.builder().checkin(value).build()).build();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        assertSoftly(
                softAssertions -> softAssertions
                        .assertThat(responseWrapper.getStatusCode())
                        .withFailMessage("test fail")
                        .isEqualTo(SC_INTERNAL_SERVER_ERROR)
        );
    }

    @ParameterizedTest(name = "{displayName}: {0}")
    @DisplayName("Server Error response  without field CheckOut")
    @NullSource
    public void testAddBookCheckOutNull(Object value) {
        AddNewBookRequest request = AddNewBookRequest.builder().bookingdates(AddNewBookRequest.Bookingdates.builder().checkout(value).build()).build();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        assertSoftly(
                softAssertions -> softAssertions
                        .assertThat(responseWrapper.getStatusCode())
                        .withFailMessage("test fail")
                        .isEqualTo(SC_INTERNAL_SERVER_ERROR)
        );
    }
}