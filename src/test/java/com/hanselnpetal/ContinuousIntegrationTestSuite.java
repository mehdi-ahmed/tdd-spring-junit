package com.hanselnpetal;

import com.hanselnpetal.controller.ContactsManagementControllerIntegrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({DatastoreSystemsHealthTest.class,
        ContactsManagementControllerIntegrationTest.class})

public class ContinuousIntegrationTestSuite {

    // intentionally empty - Test Suite Setup (annotations) is sufficient
}
