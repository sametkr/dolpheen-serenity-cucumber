package api_spartan.stepdefinitions;

import api_spartan.POJO.Spartan;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;


import static org.hamcrest.Matchers.equalTo;

public class SpartanCrudDefinitions {

    private Response response;
    private int spartanId;
    private Spartan spartan;
    private int phone2;
    private String baseURI = "http://54.243.27.10:8000";



    @Given("a new Spartan is created with name {string}, gender {string}, phone {string} details")
    public void a_new_spartan_is_created_with_name_gender_phone_details(String name, String gender, String phone) {
        phone2 = (int) Long.parseLong(phone);
        spartan = new Spartan(name, gender, phone2);
        Response response = SerenityRest.given().contentType("application/json").body(spartan)
                .when().post(baseURI + "/api/spartans")
                .then().log().body().extract().response();

        spartanId = response.getBody().path("data.id");
    }

    @Then("the Spartan details should match the created details")
    public void validateSpartanDetails() {
        SerenityRest.given().when().get(baseURI + "/api/spartans/" + spartanId)
                .then().statusCode(200)
                .body("name", equalTo(spartan.getName()))
                .body("gender", equalTo(spartan.getGender()));
    }

    @When("I update the Spartan's name to {string}")
    public void updateSpartan(String newName) {
        spartan.setName(newName);
        SerenityRest.given().contentType("application/json").body(spartan)
                .when().put(baseURI + "/api/spartans/" + spartanId)
                .then().statusCode(204);
    }

    @Then("the Spartan's details should be updated")
    public void validateUpdatedSpartan() {
        SerenityRest.given().when().get(baseURI + "/api/spartans/" + spartanId)
                .then().statusCode(200)
                .body("name", equalTo(spartan.getName()));
    }

    @When("I delete the Spartan")
    public void deleteSpartan() {
        SerenityRest.given().when().delete(baseURI + "/api/spartans/" + spartanId)
                .then().statusCode(204);
    }

    @Then("the Spartan should no longer exist")
    public void validateSpartanDeletion() {
        SerenityRest.given().when().get(baseURI + "/api/spartans/" + spartanId)
                .then().statusCode(404);
    }


}
