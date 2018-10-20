package olaven.function;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ConsumerTest {


    @Test
    public void someCustomException() {
        Consumer consumer = new Consumer() {
            @Override
            public void accept(Object o) throws Throwable {
                
            }
        }
    }

}
