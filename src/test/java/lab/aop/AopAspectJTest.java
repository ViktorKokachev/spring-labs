package lab.aop;

import lab.model.ApuBar;
import lab.model.Bar;
import lab.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
public class AopAspectJTest {

    @Autowired
    private Bar bar;

    @Autowired
    private Customer customer;

    @BeforeEach
    public void setUp() throws Exception {

        bar.sellSquishee(customer);
    }

    @Test
    public void testBeforeAdvice() {
        assertThat("Before advice is not good enought...", is(AopLog.getStringValue().contains("Hello")));
        assertThat("Before advice is not good enought...", is(AopLog.getStringValue().contains("How are you doing?")));
        System.out.println(AopLog.getStringValue());
    }

    @Test
    public void testAfterAdvice() {
        System.out.println(AopLog.getStringValue());
        assertThat("After advice is not good enought...", is(AopLog.getStringValue().contains("Good Bye!")));
    }

    @Test
    public void testAfterReturningAdvice() {
        assertThat("Customer is broken", is(AopLog.getStringValue().contains("Good Enough?")));
        System.out.println(AopLog.getStringValue());
    }

    @Test
    public void testAroundAdvice() {
        assertThat("Around advice is not good enought...", is(AopLog.getStringValue().contains("Hi!")));
        assertThat("Around advice is not good enought...", is(AopLog.getStringValue().contains("See you!")));
        System.out.println(AopLog.getStringValue());
    }

    @Test
    public void testAllAdvices() {
        assertFalse("barObject instanceof ApuBar", bar instanceof ApuBar);
    }
}