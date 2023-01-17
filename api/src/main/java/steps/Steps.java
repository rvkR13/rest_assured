package steps;

import dto.AddNewBookRequest;
import dto.AuthRequest;
import io.restassured.specification.RequestSpecification;
import utils.ResponseWrapper;

import static io.restassured.RestAssured.given;
// TODO: 16.01.2023 todo добавить описание class Steps /**

/**
 * Класс с реализацией всех шагов
 */

public class Steps {

    /**
     * Часть URL для запросов /booking
     */
    private static final String ADD_BOOK = "booking";
    /**
     * Часть URL для запросов /auth
     */
    private static final String AUTH = "auth";
    /**
     * Часть URL для запросов /booking/{bookId}
     */
    private static final String FIND_BOOK = ADD_BOOK + "/{bookId}";

    private final RequestSpecification requestSpecification;

    /**
     * Конструктор для создания экземпляра класса
     *
     * @param requestSpecification спецификация RestAssured
     */
    public Steps(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    /**
     *  Создание новой книги
     * @param request тело запроса
     * @return {@link utils.ResponseWrapper}
     */
    public ResponseWrapper createNewBook(AddNewBookRequest request) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .body(request)
                .with()
                .contentType("application/json; charset=utf-8")
                .post(ADD_BOOK)
                .andReturn());
    }

    /**
     * Authorization
     *
     * @param request тело запроса
     * @return {@link utils.ResponseWrapper}
     */
    public ResponseWrapper auth(AuthRequest request) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .body(request)
                .with()
                .contentType("application/json; charset=utf-8")
                .post(AUTH)
                .andReturn());
    }

    /**
     * GET request , find book
     *
     * @param bookId id Book
     * @return {@link utils.ResponseWrapper}
     */
    public ResponseWrapper findBook(String bookId) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .pathParam("bookId", bookId)
                .get(FIND_BOOK)
                .andReturn());
    }

    /**
     * delete book
     *
     * @param bookId id book
     * @param token  Authorization token
     * @return {@link utils.ResponseWrapper}
     */
    public ResponseWrapper deleteBook(String bookId, String token) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .pathParam("bookId", bookId)
                .header("Cookie", "token=" + token)
                .delete(FIND_BOOK)
                .andReturn());
    }
}