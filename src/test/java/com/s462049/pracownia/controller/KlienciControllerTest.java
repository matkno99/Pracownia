package com.s462049.pracownia.controller;

import com.s462049.pracownia.model.Klienci;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;

import javax.annotation.PostConstruct;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class KlienciControllerTest {
    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }

    @Test
    void findAll() {
        RestAssured.get(uri + "/klienci/")
                .then()
                .statusCode(200);
    }

    @Test
    void addKlient() {
        Klienci klienci = new Klienci();
        klienci.setClientName("Zbychu");
        klienci.setMiasto("Poznań");

        Klienci newKlient = given()
                .when()
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .body(klienci)
                .post(uri + "/klienci/")
                .then()
                .statusCode(201)
                .extract().body().as(Klienci.class);

        assertNotNull(newKlient);
        assertNotNull(newKlient.getID());
    }

    @Test
    void deleteKlientwheniddoesnotexist() {
        given()
                .pathParam("id", 1000)
                .delete(uri + "/klienci/{id}")
                .prettyPeek()
                .then()
                .statusCode(404);
    }
}
