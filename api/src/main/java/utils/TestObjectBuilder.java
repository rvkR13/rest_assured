package utils;

import dto.AddNewBookRequest;

import static utils.RandomGenerator.*;

public class TestObjectBuilder {
    /**
     * успешный запрос
     * @return
     */
    public static AddNewBookRequest getAddBookRequestSuccess() {
        return AddNewBookRequest.builder()
                .firstname(getRandomFirstname())
                .lastname(getRandomLastname())
                .totalprice(RandomTotalPrice())
                .depositpaid(getDepositpaid())
                .additionalneeds(getRandomAdditionalneeds())
                .bookingdates(AddNewBookRequest.Bookingdates.builder()
                        .checkin(getRandomDataIN())
                        .checkout(getRandomDataOUT())
                        .build())
                .build();
    }
    /**
     *  запрос с firstname(null)
     * @return
     */
    public static AddNewBookRequest getAddBookRequestNullFirstname() {
        return AddNewBookRequest.builder()
                .firstname(null)
                .lastname(getRandomLastname())
                .totalprice(RandomTotalPrice())
                .depositpaid(getDepositpaid())
                .additionalneeds(getRandomAdditionalneeds())
                .bookingdates(AddNewBookRequest.Bookingdates.builder()
                        .checkin(getRandomDataIN())
                        .checkout(getRandomDataOUT())
                        .build())
                .build();
    }
    /**
     *  запрос с firstname int
     * @return
     */
    public static AddNewBookRequest getAddBookRequestErrorFirstname() {
        return AddNewBookRequest.builder()
                 .firstname(InputNum())
                .lastname(getRandomLastname())
                .totalprice(RandomTotalPrice())
                .depositpaid(getDepositpaid())
                .additionalneeds(getRandomAdditionalneeds())
                .bookingdates(AddNewBookRequest.Bookingdates.builder()
                        .checkin(getRandomDataIN())
                        .checkout(getRandomDataOUT())
                        .build())
                .build();
    }
    /**
     *  запрос с .lastname(null)
     * @return
     */
    public static AddNewBookRequest getAddBookRequestNullLastname() {
        return AddNewBookRequest.builder()
                .firstname(getRandomFirstname())
                .lastname(null)
                .totalprice(RandomTotalPrice())
                .depositpaid(getDepositpaid())
                .additionalneeds(getRandomAdditionalneeds())
                .bookingdates(AddNewBookRequest.Bookingdates.builder()
                        .checkin(getRandomDataIN())
                        .checkout(getRandomDataOUT())
                        .build())
                .build();
    }
    /**
     *  запрос с totalprice(null)
     * @return
     */
    public static AddNewBookRequest getAddBookRequestNullTotalprice() {
        return AddNewBookRequest.builder()
                .firstname(getRandomFirstname())
                .lastname(getRandomLastname())
                .totalprice(null)
                .depositpaid(getDepositpaid())
                .additionalneeds(getRandomAdditionalneeds())
                .bookingdates(AddNewBookRequest.Bookingdates.builder()
                        .checkin(getRandomDataIN())
                        .checkout(getRandomDataOUT())
                        .build())
                .build();
    }
    /**
     *  запрос с depositpaid(null)
     * @return
     */
    public static AddNewBookRequest getAddBookRequestNullDepositpaid() {
        return AddNewBookRequest.builder()
                .firstname(getRandomFirstname())
                .lastname(getRandomLastname())
                .totalprice(RandomTotalPrice())
                .depositpaid(null)
                .additionalneeds(getRandomAdditionalneeds())
                .bookingdates(AddNewBookRequest.Bookingdates.builder()
                        .checkin(getRandomDataIN())
                        .checkout(getRandomDataOUT())
                        .build())
                .build();
    }
    /**
     *  запрос с additionalneeds(null)
     * @return
     */
    public static AddNewBookRequest getAddBookRequestNullAdditionalneeds() {
        return AddNewBookRequest.builder()
                .firstname(getRandomFirstname())
                .lastname(getRandomLastname())
                .totalprice(RandomTotalPrice())
                .depositpaid(getDepositpaid())
                .additionalneeds(null)
                .bookingdates(AddNewBookRequest.Bookingdates.builder()
                        .checkin(getRandomDataIN())
                        .checkout(getRandomDataOUT())
                        .build())
                .build();
    }
    /**
     *  запрос с checkin(null)
     * @return
     */
    public static AddNewBookRequest getAddBookRequestNullCheckin() {
        return AddNewBookRequest.builder()
                .firstname(getRandomFirstname())
                .lastname(getRandomLastname())
                .totalprice(RandomTotalPrice())
                .depositpaid(getDepositpaid())
                .additionalneeds(getRandomAdditionalneeds())
                .bookingdates(AddNewBookRequest.Bookingdates.builder()
                        .checkin(null)
                        .checkout(getRandomDataOUT())
                        .build())
                .build();
    }
    /**
     *  запрос с checkout(null)
     * @return
     */
    public static AddNewBookRequest getAddBookRequestNullCheckout() {
        return AddNewBookRequest.builder()
                .firstname(getRandomFirstname())
                .lastname(getRandomLastname())
                .totalprice(RandomTotalPrice())
                .depositpaid(getDepositpaid())
                .additionalneeds(getRandomAdditionalneeds())
                .bookingdates(AddNewBookRequest.Bookingdates.builder()
                        .checkin(getRandomDataIN())
                        .checkout(null)
                        .build())
                .build();
    }
    /**
     *  запрос с lastname int
     * @return
     */
    public static AddNewBookRequest getAddBookRequestErrorLastname() {
        return AddNewBookRequest.builder()
                .firstname(getRandomFirstname())
                .lastname(InputNum())
                .totalprice(RandomTotalPrice())
                .depositpaid(getDepositpaid())
                .additionalneeds(getRandomAdditionalneeds())
                .bookingdates(AddNewBookRequest.Bookingdates.builder()
                        .checkin(getRandomDataIN())
                        .checkout(getRandomDataOUT())
                        .build())
                .build();
    }
}