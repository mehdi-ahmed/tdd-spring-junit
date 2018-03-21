package com.hanselnpetal.data.repos;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.hanselnpetal.domain.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Mehdi on 3/1/18.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class
        , DirtiesContextTestExecutionListener.class
        , TransactionalTestExecutionListener.class
        , DbUnitTestExecutionListener.class})
@DatabaseSetup("classpath:test-datasets.xml")

public class CustomerContactRepositoryDbUnitTest {

    @Autowired
    private CustomerContactRepository customerContactRepository;

    @Test
    public void testFindByEmail() {

        //Find an inserted record using repository class
        CustomerContact foundContact = customerContactRepository.findByEmail("elaine@myemail.com");

        assertThat(foundContact.getEmail(), is(equalTo("elaine@myemail.com")));


    }

}
