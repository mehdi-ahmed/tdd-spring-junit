package com.hanselnpetal.controller;

import com.hanselnpetal.domain.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by Mehdi on 2/27/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactsManagementControllerIntegrationTest {

    @Autowired
    ContactsManagementController contactsManagementController;

    @Test
    public void testAddContactHappyPath() {

        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("Jenny");
        aContact.setLastName("johnson");

        //POST
        String addContactSubmit = contactsManagementController.processAddContactSubmit(aContact);

        assertThat(addContactSubmit, is(equalTo("success")));
    }

    @Test
    public void testAddContactFirstNameMissing() {

        CustomerContact aContact = new CustomerContact();

        //POST
        String outcome = contactsManagementController.processAddContactSubmit(aContact);

        assertThat(outcome, is(equalTo("failure")));


    }
}
