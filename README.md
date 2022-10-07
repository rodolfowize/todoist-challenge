# todoist-challenge
This is an UI test application for the Todoist web application built with Java 11, Selenium 4, Spring 5, Junit 5, Maven and Allure. 
In regards to browser support, it currently is setup to work with Chrome nad Safari only, but it is open to add support for other browsers.
The app covers the validations of different positive and negative scenarios for logging in into the app and creating new tasks in an already existent project, making up a total of 7 automated tests:

- Login
   * successfulLoginTest
   * nonExistentUsernameLoginTest
   * noUsernameLoginTest
   * wrongPasswordLoginTest
   * noPasswordLoginTest

- Task
   * createNewTaskTest
   * create10NewTasks

The project structure is as follows:

- Config package: All classes related to the application configuration should go in here.
- Driver package: All the code that has to do with the WebDriver will is placed here.
- Enums package: Store all your enums if here in case it doesn't make much sense having them in a different package along with other classes.
- Page.object.model package: It contains all the Application pages involved in the testing coverage in the app, as well as a Base class from which all the other page classes inherit from.
- Reporting package: It contains all the code related to reporting support and configuration.
- Test package: This is where all the test classes are found, including a BaseTest class which serves as parent class for the other test classes.
- Utils package: This package has all utility and helper classes.

Under the resources folder, you'll find the test.properties file which holds general config values and a directory called drivers, where all the required drivers executable files will be located. 

Each test class in the project (with the exception of the BaseTest class) will represent a test suite which can be executed independently. 
Parallel execution will be only available through Jenkins, by running the test suites in different nodes/slaves at the same time.

The test application takes advantage of the Dependency Injection and bean lifecycle management that Spring offers, so the creation and destruction of the java objects is handled by Spring itself. It also makes use of the @Value annotation to read values from the properties files. 

Besides Spring annotations, you'll find in the project Allure annotations such as @Step and @Attachment, which help with generating the test report easily.

Finally, the app follows the Page Object Model to represent the UI pages involved in the different tested flows.
