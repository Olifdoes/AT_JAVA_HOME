
package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServeRestTest {

    static String userId;
    static String userEmail;
    static String userPassword = "123456";
    static String token;

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://serverest.dev";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    // Тест 1. Получение списка всех пользователей
    @Test
    @Order(1)
    void shouldGetAllUsers() {
        given()
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .contentType(containsString("application/json"))
                .body("quantidade", greaterThan(0))
                .body("usuarios", not(empty()));
    }

    // Тест 2. Поиск пользователя по email
    @Test
    @Order(2)
    void shouldFindUserByEmail() {
        String email = given()
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .extract()
                .path("usuarios[0].email");

        given()
                .queryParam("email", email)
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .body("quantidade", equalTo(1))
                .body("usuarios[0].email", equalTo(email));
    }

    // Тест 3. Создание нового пользователя
    @Test
    @Order(3)
    void shouldCreateNewUser() {
        userEmail = "spy_" + System.currentTimeMillis() + "@qa.com";

        String requestBody = """
            {
                "nome": "Тестовый Покупатель",
                "email": "%s",
                "password": "%s",
                "administrador": "true"
            }
            """.formatted(userEmail, userPassword);

        userId = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/usuarios")
                .then()
                .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"))
                .body("_id", not(empty()))
                .extract()
                .path("_id");
    }

    // Тест 4. Изменение пользователя
    @Test
    @Order(4)
    void shouldUpdateUser() {
        String requestBody = """
            {
                "nome": "Обновлённый Покупатель",
                "email": "%s",
                "password": "%s",
                "administrador": "false"
            }
            """.formatted(userEmail, userPassword);

        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/usuarios/" + userId)
                .then()
                .statusCode(200)
                .body("message", equalTo("Registro alterado com sucesso"));
    }

    // Тест 5. Авторизация пользователя
    @Test
    @Order(5)
    void shouldLogin() {
        String requestBody = """
            {
                "email": "%s",
                "password": "%s"
            }
            """.formatted(userEmail, userPassword);

        token = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .body("message", equalTo("Login realizado com sucesso"))
                .body("authorization", not(empty()))
                .extract()
                .path("authorization");
    }

    // Тест 6. Удаление пользователя и проверка удаления
    @Test
    @Order(6)
    void shouldDeleteUser() {
        given()
                .header("Authorization", token)
                .when()
                .delete("/usuarios/" + userId)
                .then()
                .statusCode(200)
                .body("message", equalTo("Registro excluído com sucesso"));

        given()
                .when()
                .get("/usuarios/" + userId)
                .then()
                .statusCode(400)
                .body("message", equalTo("Usuário não encontrado"));
    }

    // Тест 7. Получение и проверка списка товаров
    @Test
    @Order(7)
    void shouldGetAllProducts() {
        var response = given()
                .when()
                .get("/produtos")
                .then()
                .statusCode(200)
                .extract()
                .response();

        Number quantidade = response.path("quantidade");

        org.junit.jupiter.api.Assertions.assertTrue(
                quantidade.intValue() > 0,
                "Список товаров не должен быть пустым"
        );

        List<Number> prices =
                response.jsonPath().getList("produtos.preco");

        for (Number price : prices) {
            org.junit.jupiter.api.Assertions.assertTrue(
                    price.doubleValue() > 0,
                    "Цена товара должна быть больше нуля"
            );
        }

        List<String> names =
                response.jsonPath().getList("produtos.nome");

        org.junit.jupiter.api.Assertions.assertFalse(
                names.isEmpty(),
                "Список названий не должен быть пустым"
        );

        for (String name : names) {
            org.junit.jupiter.api.Assertions.assertNotNull(
                    name,
                    "Название товара не должно быть null"
            );

            org.junit.jupiter.api.Assertions.assertFalse(
                    name.isBlank(),
                    "Название товара не должно быть пустым"
            );
        }

        org.junit.jupiter.api.Assertions.assertTrue(
                names.contains(names.get(0)),
                "Список должен содержать хотя бы одно название товара"
        );
    }
}
