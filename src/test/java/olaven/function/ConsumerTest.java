package olaven.function;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.InvalidPropertiesFormatException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class ConsumerTest {

    private<Item, ExceptionType extends Throwable> void
        methodAcceptingConsumer(Item item, Consumer<Item, ExceptionType> consumer) throws ExceptionType {
        consumer.accept(item);
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
