package olaven.function;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import sun.plugin.dom.exception.InvalidStateException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class FunctionTest {

    @TestTemplate
    private<First, Second, ExceptionType extends Throwable> void
    methodAcceptingConsumer(First first, Function<First, Second, ExceptionType> function) throws ExceptionType {
        function.apply(first);
    }

    @Test
    public void someCustomException() {
        assertThatExceptionOfType(InvalidStateException.class).isThrownBy(() -> {
            methodAcceptingConsumer(-1, first -> {
                throw new InvalidStateException("");
            });
        });
    }


    @Test
    public void someOtherCustomException() {
        assertThatExceptionOfType(InvalidArgumentException.class).isThrownBy(() -> {
            methodAcceptingConsumer(-1, first -> {
                throw new InvalidArgumentException(new String[]{});
            });
        });
    }
}
