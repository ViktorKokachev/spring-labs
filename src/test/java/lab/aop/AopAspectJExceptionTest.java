package lab.aop;

import lab.model.Bar;
import lab.model.Customer;
import lab.model.CustomerBrokenException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")

public class AopAspectJExceptionTest {

    @Autowired
    private Bar bar;

    @Autowired
    private Customer customer;

    @BeforeEach
    public void setUp() throws Exception {

//        customer.setBroke(true);
    }

    @Test
    public void testAfterThrowingAdvice() {

        bar.sellSquishee(customer);

        Throwable exception = assertThrows(CustomerBrokenException.class,
                () -> {
                    logic;
                });


        assertThat("Customer is not broken ", is(AopLog.getStringValue().contains("Hmmm...")));
        System.out.println(AopLog.getStringValue());
    }
}