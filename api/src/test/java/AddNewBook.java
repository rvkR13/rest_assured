import dto.AddNewBookRequest;
import dto.AddNewBookResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ResponseWrapper;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static utils.RandomGenerator.STATUS_CODE_ERROR_500;
import static utils.RandomGenerator.STATUS_CODE_OK;
import static utils.TestObjectBuilder.*;

public class AddNewBook extends BaseTest {
    @DisplayName("Successful response with optional all field ")
    @Test
    public void testAddBook() {
        AddNewBookRequest request = getAddBookRequestSuccess();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        AddNewBookResponse response = responseWrapper.as(AddNewBookResponse.class);
        assertSoftly(
                softAssertions -> {
                    softAssertions
                            .assertThat(responseWrapper.getStatusCode())
                            .withFailMessage("статус код не совпадает")
                            .isEqualTo(STATUS_CODE_OK);
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
    @DisplayName("Server Error response without optional field Firstname")
    @Test
    public void testAddBookNullFirstname() {
        AddNewBookRequest request = getAddBookRequestNullFirstname();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        assertSoftly(
                softAssertions -> {
                    softAssertions
                            .assertThat(responseWrapper.getStatusCode())
                            .withFailMessage("test fail")
                            .isEqualTo(STATUS_CODE_ERROR_500);
                }
        );
    }
    @DisplayName("Server Error response without optional field Totalprice")
    @Test
    public void testAddBookNullTotalprice() {
        AddNewBookRequest request = getAddBookRequestNullTotalprice();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        assertSoftly(
                softAssertions -> {
                    softAssertions
                            .assertThat(responseWrapper.getStatusCode())
                            .withFailMessage("test fail")
                            .isEqualTo(STATUS_CODE_ERROR_500);
                }
        );
    }
    @DisplayName("Server Error response without optional field Lastname")
    @Test
    public void testAddBookNullLastname() {
        AddNewBookRequest request = getAddBookRequestNullLastname();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        assertSoftly(
                softAssertions -> {
                    softAssertions
                            .assertThat(responseWrapper.getStatusCode())
                            .withFailMessage("test fail")
                            .isEqualTo(STATUS_CODE_ERROR_500);
                }
        );
    }
    @DisplayName("Server Error response without optional field Depositpaid")
    @Test
    public void testAddBookNullDepositpaid() {
        AddNewBookRequest request = getAddBookRequestNullDepositpaid();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        assertSoftly(
                softAssertions -> {
                    softAssertions
                            .assertThat(responseWrapper.getStatusCode())
                            .withFailMessage("test fail")
                            .isEqualTo(STATUS_CODE_ERROR_500);
                }
        );
    }
    @DisplayName("Successful response without optional field Additionalneeds")
    @Test()
    public void testAddBookNullAdditionalneeds() {
        AddNewBookRequest request = getAddBookRequestNullAdditionalneeds();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        AddNewBookResponse response = responseWrapper.as(AddNewBookResponse.class);
        assertSoftly(
                softAssertions -> {
                    softAssertions
                            .assertThat(responseWrapper.getStatusCode())
                            .withFailMessage("статус код не совпадает")
                            .isEqualTo(STATUS_CODE_OK);
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
    @DisplayName("Server Error response without optional field Checkin")
    @Test
    public void testAddBookNullCheckin() {
        AddNewBookRequest request = getAddBookRequestNullCheckin();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        assertSoftly(
                softAssertions -> {
                    softAssertions
                            .assertThat(responseWrapper.getStatusCode())
                            .withFailMessage("test fail")
                            .isEqualTo(STATUS_CODE_ERROR_500);
                }
        );
    }
    @DisplayName("Server Error response without optional field Checkout")
    @Test
    public void testAddBookNullCheckout() {
        AddNewBookRequest request = getAddBookRequestNullCheckout();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        assertSoftly(
                softAssertions -> {
                    softAssertions
                            .assertThat(responseWrapper.getStatusCode())
                            .withFailMessage("test fail")
                            .isEqualTo(STATUS_CODE_ERROR_500);
                }
        );
    }
    @DisplayName("Server Error response with ErrorFirstname")
    @Test
    public void testAddBookErrorFirstname() {
        AddNewBookRequest request = getAddBookRequestErrorFirstname();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        assertSoftly(
                softAssertions -> {
                    softAssertions
                            .assertThat(responseWrapper.getStatusCode())
                            .withFailMessage("test fail")
                            .isEqualTo(STATUS_CODE_ERROR_500);
                }
        );
    }
    @DisplayName("Server Error response with ErrorLastname")
    @Test
    public void testAddBookErrorCheckin() {
        AddNewBookRequest request = getAddBookRequestErrorLastname();
        ResponseWrapper responseWrapper = steps.createNewBook(request);
        assertSoftly(
                softAssertions -> {
                    softAssertions
                            .assertThat(responseWrapper.getStatusCode())
                            .withFailMessage("test fail")
                            .isEqualTo(STATUS_CODE_ERROR_500);
                }
        );
    }
}