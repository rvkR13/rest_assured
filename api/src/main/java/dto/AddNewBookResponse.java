package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddNewBookResponse {
    private Integer bookingid;
    private Booking booking;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Booking {
        private String firstname;
        private int totalprice;
        private Boolean depositpaid;
        private String lastname;
        private String additionalneeds;//необязательное поле
        private Bookingdates bookingdates;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Bookingdates {
        private String checkin;
        private String checkout;
    }
}