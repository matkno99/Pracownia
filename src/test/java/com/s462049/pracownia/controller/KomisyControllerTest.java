package com.s462049.pracownia.controller;

import com.s462049.pracownia.model.Komisy;
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
class KomisyControllerTest {
    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }

    @Test
    void findAll() {
        RestAssured.get(uri + "/komisy/")
                .then()
                .statusCode(200);
    }

    @Test
    void addKomis() {
        Komisy komisy = new Komisy();
        komisy.setNazwaKomisu("uStacha");
        komisy.setMiasto("Wilno");

        Komisy newKomis = given()
                .when()
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .body(komisy)
                .post(uri + "/komisy/")
                .then()
                .statusCode(201)
                .extract().body().as(Komisy.class);

        assertNotNull(newKomis);
        assertNotNull(newKomis.getID());
    }

    @Test
    void deleteKomiswheniddoesnotexist() {
        given()
                .pathParam("id", 1000)
                .delete(uri + "/komisy/{id}")
                .prettyPeek()
                .then()
                .statusCode(404);
    }
}

