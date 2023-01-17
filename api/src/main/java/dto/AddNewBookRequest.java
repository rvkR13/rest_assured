package dto;

import lombok.Builder;
import lombok.Value;

import static utils.RandomGenerator.*;

@Value
@Builder
public class AddNewBookRequest {
    @Builder.Default
    Object firstname = getRandomFirstname();
    @Builder.Default
    Object lastname = getRandomLastname();
    @Builder.Default
    Integer totalprice = randomTotalPrice();
    @Builder.Default
    Object depositpaid = getDepositPaid();
    @Builder.Default
    Object additionalneeds = getRandomAdditionalNeeds();
    @Builder.Default
    Bookingdates bookingdates = Bookingdates.builder().build();

    @Value
    @Builder
    public static class Bookingdates {
        @Builder.Default
        Object checkin = getRandomDataIN();
        @Builder.Default
        Object checkout = getRandomDataOUT();
    }
}