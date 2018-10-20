package olaven.function;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PredicateTest {

    @TestTemplate
    private<Item, ExceptionType extends Throwable> void
    methodAcceptingConsumer(Item item, Predicate<Item, ExceptionType> consumer) throws ExceptionType {
        consumer.test(item);
    }

    @Test
    public void someCustomException() {
        assertThatExceptionOfType(InvalidArgumentException.class).isThrownBy(() -> {
            methodAcceptingConsumer(0, item -> {
                throw new InvalidArgumentException(new String[]{});
            });
        });
    }


    @Test
    public void someOtherCustomException() {
        assertThatExceptionOfType(InvalidArgumentException.class).isThrownBy(() -> {
            methodAcceptingConsumer(0, item -> {
                throw new InvalidArgumentException(new String[]{});
            });
        });
    }
}
