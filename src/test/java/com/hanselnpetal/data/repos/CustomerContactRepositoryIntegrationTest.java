package com.hanselnpetal.data.repos;

import com.hanselnpetal.domain.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Mehdi on 3/1/18.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerContactRepositoryIntegrationTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerContactRepository customerContactRepository;

    @Test
    //@Rollback(false)
    public void testFindByEmail() {

        //setup data
        CustomerContact aContact = new CustomerContact();
        aContact.setEmail("fred@myemail.com");
        aContact.setLastName("Ahmed");
        aContact.setFirstName("Mehdi");
        entityManager.persist(aContact);

        //Find an inserted record using repository class
        CustomerContact foundContact = customerContactRepository.findByEmail("fred@myemail.com");

        //Assertion
        assertThat(foundContact.getEmail(), is(equalTo("fred@myemail.com")));

    }
}
