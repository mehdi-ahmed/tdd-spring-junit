package com.hanselnpetal.service;

import com.hanselnpetal.data.repos.CustomerContactRepository;
import com.hanselnpetal.domain.CustomerContact;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ContactsManagementServiceMockUnitTest {


    @InjectMocks
    private ContactsManagementService contactsManagementService;

    @Mock
    private CustomerContactRepository customerContactRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testAddContactHappyPath() {

        // Create a contact
        CustomerContact aMockContact = new CustomerContact();
        aMockContact.setFirstName("Jenny");
        aMockContact.setLastName("Johnson");

        when(customerContactRepository.save(any(CustomerContact.class))).thenReturn(aMockContact);

        // do the save
        CustomerContact newContact = contactsManagementService.addWithoutCheck(null);

        //verify the save
        assertEquals("Jenny", newContact.getFirstName());

    }
}
