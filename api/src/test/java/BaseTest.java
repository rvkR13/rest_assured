import config.BaseConfig;
import dto.AddNewBookRequest;
import dto.AddNewBookResponse;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import steps.Steps;
import utils.ResponseWrapper;

/**
 * Базовый тестовый класс с общими настройками
 */
public class BaseTest {
    /**
     * Экземпляр интерфейса с конфигурацией
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());
    /**
     * Экземпляр класса с REST шагами
     */

    protected final Steps steps = new Steps(getRequestSpecification());

    /**
     * экземпляр класса с телом запроса
     */
    protected AddNewBookRequest request;
    /**
     * экземпляр класса с телом ответа
     */
    protected AddNewBookResponse response;

    /**
     * экземпляр класса с оболочкой ответа
     */
    protected ResponseWrapper responseWrapper;


    /**
     * Метод для получения спецификации RestAssured
     * <p>
     * baseUrl - базовый URL
     * contentType - параметр в header со значением JSON
     * accept - параметр в header со значением JSON
     * filter - создает фильтр для allure
     * log - логирование всех деталей
     *
     * @return спецификация
     */

    private RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(config.url())
                .setContentType(ContentType.ANY)
                .setAccept(ContentType.ANY)
//                .setContentType("application json;charset = UTF-8")
//                .setAccept("application json;charset = UTF-8")


                .addFilter(new AllureRestAssured())
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .build();
    }
}