package lab.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
public class SpringTCFAppTest {

    @Autowired
    private UsualPerson person;

    private UsualPerson expectedPerson;


    @BeforeEach
    public void setUp() throws Exception {
        expectedPerson = SimpleAppTest.getExpectedPerson();
    }

    @Test
    public void testInitPerson() {
        System.out.println(expectedPerson);
        assertThat(expectedPerson, is(person));
        System.out.println(person);
    }
}
