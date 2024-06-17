# "Serenity Cucumber Framework"
## Overview
* This is a robust, flexible, and extensible test automation framework using Serenity BDD, Cucumber-Gherkin, RestAssured, and Selenium WebDriver. It is designed to be user-friendly for testers who are not proficient in coding and uses Maven for build management.


## Key Features

- **Serenity BDD**: Provides detailed and explanatory test reports.
- **Cucumber**: Allows writing test scenarios in Gherkin language.
- **RestAssured**: For RESTful API testing.
- **Selenium WebDriver**: For browser interactions.
- **Maven**: Manages dependencies and build processes.

## Setup:
* Install [Java 17](https://www.oracle.com/java/technologies/downloads/#java17)
* Install Maven [Maven](https://maven.apache.org/)

* **Clone the repository**:
   ```sh
   git clone https://github.com/sametkr/dolpheen-serenity-cucumber.git
* **Install dependencies**:
    ```sh
  mvn clean install

* **Run the tests**:
    ```sh
  mvn clean verify

## Run tests:
* `mvn clean verify` 
* OR 
* `mvn clean verify -Dwebdriver.driver=chrome`  - Run test scripts using Chrome browser.
* `mvn clean verify -Dwebdriver.driver=firefox`  - Run test scripts using Firefox browser.

## View HTML Report
* HTML report will be generated and report link displayed on terminal once execution with `mvn clean verify`
* or
* .../dolpheen-serenity-cucumber/target/site/serenity/index.html


# Writing tests:
    
    1. Create Gherkin feature files in src/test/resources//features.
    2. Define step implementations in src/test/java/dolpheen/stepdefinitions.
    3. Create Page Object classes in src/test/java/dolpheen/pages.


# Sample Feature:
    Feature: OrangeHRM app login feature

    Background: For the scenarios in the feature file, user is expected to be on login page
    Given user is on the home page
    
    Scenario: User logs in to his OrangeHRM account
    When user enters email "Admin"
    And user enters password "admin123"
    And user clicks Log in button
    Then user should see "Dashboard" on the homepage
# Sample Web Elements:
    public static Target USER_USERNAME = Target.the("Username").locatedBy("//input[@name='username']");
    public static Target USER_PASSWORD = Target.the("Password").locatedBy("//input[@name='password']");
    public static Target LOG_IN_BUTTON = Target.the("Log in").locatedBy("//button[@type='submit']");
    public static Target ERROR_MESSAGE = Target.the("Invalid Credentials").locatedBy("//div[@class='orangehrm-login-error']/div/div/p");

# Sample Definitions:
    @Given("{actor} is on the home page")
    public void user_is_on_the_login_page(Actor actor) {
        actor.wasAbleTo(NavigateTo.orangeHrmHomePage());
    }

    @When("{actor} enters email {string}")
    public void user_enters_email(Actor actor, String string) {
        actor.attemptsTo(Enter.theValue(string).into(OrangeHrmHomePage.USER_USERNAME));
    }

    @When("{actor} enters password {string}")
    public void user_enters_password(Actor actor, String string) {
        actor.attemptsTo(Enter.theValue(string).into(OrangeHrmHomePage.USER_PASSWORD));
    }

    @When("{actor} clicks Log in button")
    public void user_clicks_log_in_button(Actor actor) {
        actor.wasAbleTo(Click.on(OrangeHrmHomePage.LOG_IN_BUTTON));
    }

    @Then("{actor} should see {string} on the homepage")
    public void user_should_see_on_the_homepage(Actor actor, String string) {
        actor.attemptsTo(Ensure.that(DashboardPage.DASHBOARD_PAGE_TITLE).hasText(string));
    }

    @Then("{actor} should see {string} message")
    public void user_should_see_message(Actor actor, String string) {
        actor.attemptsTo(Ensure.that(OrangeHrmHomePage.ERROR_MESSAGE).hasText(string));
    }

# Sample POJO:
    public Spartan() {}

        public Spartan(String name, String gender, long phone) {
            this.name = name;
            this.gender = gender;
            this.phone = phone;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getGender() {
            return gender;
        }
    
        public void setGender(String gender) {
            this.gender = gender;
        }
    
        public long getPhone() {
            return phone;
        }
    
        public void setPhone(long phone) {
            this.phone = phone;
        }
    }

# Sample API Definitions:
    @Given("a new Spartan is created with name {string}, gender {string}, phone {string} details")
        public void a_new_spartan_is_created_with_name_gender_phone_details(String name, String gender, String phone) {
        Spartan spartan = new Spartan(name, gender, phone2);
        Response response = SerenityRest.given().contentType("application/json").body(spartan)
                  .when().post(baseURI + "/api/spartans")
                  .then().log().body().extract().response();

        spartanId = response.getBody().path("data.id");
    }


# Screenshots Configuration:
    serenity {
      take.screenshots = FOR_FAILURES
    }

    or other screenshot settings,

    - FOR_EACH_ACTION: Saves a screenshot at every web element action (like click(), typeAndEnter(), type(), typeAndTab() etc.).
    - BEFORE_AND_AFTER_EACH_STEP: Saves a screenshot before and after every step.
    - AFTER_EACH_STEP: Saves a screenshot after every step
    - FOR_FAILURES: Saves screenshots only for failing steps.
    - DISABLED: Doesn't save screenshots for any steps.

# Setting jenkins pipeline for Selenium(Cucumber serenity project)
* This project is example how can setup jenkins pipeline for selenium project step by step
## Setup
* Download latest jenkins.war [Jenkins download link](https://updates.jenkins-ci.org/download/war/)
* Start jenkins.jar on default port using command 'java -jar jenkins.war'
* Start jenkins.jar on specific port using command 'java -jar jenkins.war --httpPort=portnumber'
* Open localhost:portnumber and login using displayed insructions on browser screens
* Now install all default plugin and set user & password
## Installing required plugins
* Navigate to jenkins home and click on "Manage jenkins" tab
* Now click on "Manage plugins"
* In "Available plugins" tab, perform serach for "Pipeline Maven Integration" and install
* Follwing above steps, install "HTML Publisher" plugin
## Setting up Java-jdk and maven
* Navigate to "Manage jenkins->Global Tool configuration"
* Configure java-jdk & maven with java17 & maven{version}
## Global configuration for Github
* Navigate to "Manage jenkins->Configure System" and in Github section configure github credentials


## Running created pipeline
* Click build now and execution will be started
* Pipeline steps will be displayed on jenkins screen
* Once execution finish, Click on "HTML Report" tab to view serenity HTML Reports