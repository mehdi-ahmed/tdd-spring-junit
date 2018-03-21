
################ Exercise-Related Database Setup Instructions  ############################

Be sure you have installed a MySQL Community Edition Server, and that you have done the following:

	1. The database server is up and running on port 3306
	2. There is a scheme named:  "spring-tdd"
	3. There is a user with proper privileges granted to the "spring-tdd" scheme.  The exercises assume a usernmae of "tddshonna".  Feel free to change the actual username to suit your preferences.
	4. The user's password is set to "booth" or whatever value you prefer.

Finally, modify the application.properties files to have the correct database connection URL with accurate schema name and port number; plus correct username and password values too, e.g.:

	spring.datasource.url = jdbc:mysql://localhost:3306/spring-tdd
	spring.datasource.username = root
	spring.datasource.password = erec$$$$$$$$$ ? Mond$$$$?


################


 - Chap 2 -  ** TESTING SPRING SERVICES **

Testing @Services
    - ContactsManagementServiceIntegrationTest.java
    - Integration Test with @SpringRunner and @SpringBootTest(webEnvironment = WebEnvironment.NONE) ==> no controllers will be loaded
    - With real database create table.

   !!  Mocking !!
   - ContactsManagementServiceMockUnitTest.java
   - MockitoJUnitRunner
   - No data source

  -Chap 3 -  ** TESTING SPRING CONTROLLER **

    - What kind of @controllers? Mcv(ViewModel return) or Restfull(return JSON or XML) ?
    - ContactsManagementControllerIntegrationTest.java
        ==> (@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT))
    - assertThat(addContactSubmit, is(equalTo("success")));


       Unit Test Mocks
        - ContactsManagementControllerUnitTest.java
        - Mimic Web Browser
        - Load @controllers
        Load mocks for @service

        - @WebMvcTest(ContactsManagementController.class)

              mockMvc.perform(post("/addContact", aContact))
               .andExpect(status().is(302))
               .andReturn();

    -Chap 4 - ** TESTING DATA ACCESS COMPONENT

            @DataJpaTest
            @AutoConfigureDataJpa : JPA testing
            @AutoConfigureTestDatabase (embedded db or not? )
            @AutoConfigureTestEntityManager : direct access to Entity Manager
            @Transactionnal (rollback behavior repeatable test)

                unit tests are useless for data access tests
                INTEGRATION tests are the way to go

                Entity mapping are fine ?
                Query semantics?
                Transactions are fine?

                Load JPA testing config
                LOAD @Repository but NOT @Service NOR @Service



                DBUNIT focuses on data before and after data
                @DatabaseSetup("classpath:test-datasets.xml")


