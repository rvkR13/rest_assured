package steps;

import dto.AddNewBookRequest;
import io.restassured.specification.RequestSpecification;
import utils.ResponseWrapper;

import static io.restassured.RestAssured.given;

public class Steps {

    /**
     * Часть URL для запросов /pet
     */
    private static final String ADD_BOOK = "booking";


    private final RequestSpecification requestSpecification;
    /**
     * Конструктор для создания экземпляра класса
     *
     * @param requestSpecification спецификация RestAssured
     */
    public Steps(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public ResponseWrapper createNewBook(AddNewBookRequest request) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .body(request)
                .with()
                .contentType("application/json; charset=utf-8")
                .post(ADD_BOOK)
                .andReturn());
    }
}