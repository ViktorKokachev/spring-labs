package lab.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleAppTest {

    protected static final String APPLICATION_CONTEXT_XML_FILE_NAME = "classpath:application-context.xml";

    private AbstractApplicationContext context;

    private UsualPerson expectedPerson;

    @BeforeEach
    public void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);
        expectedPerson = getExpectedPerson();
    }

    @Test
    public void testInitPerson() {
        UsualPerson person = (UsualPerson) context.getBean("person");
        assertThat(expectedPerson, is(person));
        System.out.println(person);
        System.out.println(expectedPerson);
    }

    static UsualPerson getExpectedPerson() {
        UsualPerson person = new UsualPerson();
        person.setAge(35);
        person.setHeight(1.78F);
        person.setIsProgrammer(true);
        person.setName("John Smith");

        Country country = new Country();
        country.setId(1);
        country.setName("Russia");
        country.setCodeName("RU");

        person.setCountry(country);

        List<String> contacts = new ArrayList<String>();
        contacts.add("asd@asd.ru");
        contacts.add("+7-234-456-67-89");

        person.setContacts(contacts);

        return person;
    }
}
