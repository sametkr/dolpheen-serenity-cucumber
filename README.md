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
   git clone https://github.com/your-repo/serenity-bdd-framework.git
   cd serenity-bdd-framework
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