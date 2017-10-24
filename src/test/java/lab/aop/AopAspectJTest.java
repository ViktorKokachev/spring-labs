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

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context-aop.xml")
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
        assertTrue(AopLog.getStringValue().contains("Hello"), "Before advice is not good enough...");
        assertTrue(AopLog.getStringValue().contains("How are you doing?"), "Before advice is not good enough...");
        System.out.println(AopLog.getStringValue());
    }

    @Test
    public void testAfterAdvice() {
        System.out.println(AopLog.getStringValue());
        assertTrue(AopLog.getStringValue().contains("Good Bye!"), "After advice is not good enough...");
    }

    @Test
    public void testAfterReturningAdvice() {
        assertTrue(AopLog.getStringValue().contains("Good Enough?"), "Customer is broken");
        System.out.println(AopLog.getStringValue());
    }

    @Test
    public void testAroundAdvice() {
        assertTrue(AopLog.getStringValue().contains("Hi!"), "Around advice is not good enought...");
        assertTrue(AopLog.getStringValue().contains("See you!") ,"Around advice is not good enought...");
        System.out.println(AopLog.getStringValue());
        assertTrue(true);
    }

    @Test
    public void testAllAdvices() {
        assertFalse(bar instanceof ApuBar, "barObject instanceof ApuBar");
    }
}