package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddNewBookRequest {
    private final Object firstname;
    private final Object lastname;
    private final Integer totalprice;
    private final Object depositpaid;// Boolean  или boolean?
    private final Object additionalneeds;
    private final  Bookingdates bookingdates;

    @Data
    @Builder
    public static class Bookingdates {
        private final Object checkin;
        private final Object checkout;
    }
}
