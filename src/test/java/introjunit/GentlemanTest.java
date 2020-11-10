package introjunit;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GentlemanTest {

    @Test
    public void testCall() {

        Gentleman gentleman = new Gentleman();

        String s = gentleman.sayHello("John Doe");

        assertThat(s,equalTo("Hello John Doe"));
    }

    @Test
    public void testCallCaseNull() {
        assertThat(new Gentleman().sayHello(null),equalTo("Hello John Doe"));
    }
}
