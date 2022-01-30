package com.s462049.pracownia.controller;

import com.s462049.pracownia.model.Samochody;
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
class SamochodyControllerTest {
    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }

    @Test
    void findAll() {
        RestAssured.get(uri + "/samochody/")
                .then()
                .statusCode(200);
    }

    @Test
    void addSamochod() {
        Samochody samochody = new Samochody();
        samochody.setNazwaSamochodu("Laguna");
        samochody.setPrzebieg("84555665");

        Samochody newSamochod = given()
                .when()
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .body(samochody)
                .post(uri + "/samochody/")
                .then()
                .statusCode(201)
                .extract().body().as(Samochody.class);

        assertNotNull(newSamochod);
        assertNotNull(newSamochod.getID());
    }

    @Test
    void deleteSamochodwheniddoesnotexist() {
        given()
                .pathParam("id", 1000)
                .delete(uri + "/samochody/{id}")
                .prettyPeek()
                .then()
                .statusCode(404);
    }
}

