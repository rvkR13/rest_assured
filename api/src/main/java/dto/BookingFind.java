package dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingFind {
    private String firstname;
    private String additionalneeds;
    private Bookingdates bookingdates;
    private Integer totalprice;
    private Boolean depositpaid;
    private String lastname;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Bookingdates {
        private String checkin;
        private String checkout;
    }
}