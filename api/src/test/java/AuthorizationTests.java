import dto.AddNewBookRequest;
import dto.AuthError;
import dto.AuthRequest;
import dto.AuthResponse;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import utils.ResponseWrapper;

import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static utils.RandomGenerator.MESSAGE_ERROR_AUTH;
import static utils.TestObjectBuilder.*;

/**
 * Тесты авторизации
 * ручка http://restful-booker.herokuapp.com/apidoc/index.html#api-Auth-CreateToken
 */
public class AuthorizationTests extends BaseTest {

    @Test
    @DisplayName("Successful auth")
    public void testSuccessAuth() {
        AuthRequest request = getSuccessAuth();
        ResponseWrapper responseWrapper = steps.auth(request);
        AuthResponse response = responseWrapper.as(AuthResponse.class);
        assertSoftly(
                softAssertions -> {
                    softAssertions
                            .assertThat(response.getToken())
                            .withFailMessage("в ответе токен отсутствует")
                            .isNotNull().isNotEqualTo("");
                    softAssertions
                            .assertThat(responseWrapper.getStatusCode())
                            .withFailMessage("error")
                            .isEqualTo(SC_OK);
                }
        );
    }

    @Owner("rvk13")
    @ParameterizedTest(name = "{displayName}: {0}")
    @DisplayName("Auth with Error And Null Name")
    @MethodSource("utils.RandomGenerator#provideStringsForIsBlank")
    public void testErrorAndNullNameAuth(Object value) {
        AuthRequest request = AuthRequest.builder().username(value)
                .build();
        ResponseWrapper responseWrapper = steps.auth(request);
        AuthError response = responseWrapper.as(AuthError.class);
        assertSoftly(
                softAssertions -> {
                    softAssertions
                            .assertThat(response.getReason())
                            .withFailMessage("error")
                            .isEqualTo(MESSAGE_ERROR_AUTH);
                    softAssertions
                            .assertThat(responseWrapper.getStatusCode())
                            .withFailMessage("error")
                            .isEqualTo(SC_OK);
                }
        );
    }

    @ParameterizedTest(name = "{displayName}: {0}")
    @DisplayName("Auth with Error And Null Password")
    @MethodSource("utils.RandomGenerator#provideStringsForIsBlank")
    public void testErrorAndNullPasswordAuth(Object value) {
        AuthRequest request = AuthRequest.builder().password(value)
                .build();
        ResponseWrapper responseWrapper = steps.auth(request);
        AuthError response = responseWrapper.as(AuthError.class);
        assertSoftly(
                softAssertions -> {
                    softAssertions
                            .assertThat(response.getReason())
                            .withFailMessage("error")
                            .isEqualTo(MESSAGE_ERROR_AUTH);
                    softAssertions
                            .assertThat(responseWrapper.getStatusCode())
                            .withFailMessage("error")
                            .isEqualTo(SC_OK);
                }
        );
    }

    @Test
    @DisplayName("Error login ang pass auth")
    public void testErrorAllDataAuth() {
        AuthRequest request = getErrorAllDataAuth();
        ResponseWrapper responseWrapper = steps.auth(request);
        AuthError response = responseWrapper.as(AuthError.class);
        assertSoftly(
                softAssertions -> {
                    softAssertions
                            .assertThat(response.getReason())
                            .withFailMessage("error")
                            .isEqualTo(MESSAGE_ERROR_AUTH);
                    softAssertions
                            .assertThat(responseWrapper.getStatusCode())
                            .withFailMessage("error")
                            .isEqualTo(SC_OK);
                }
        );
    }
}