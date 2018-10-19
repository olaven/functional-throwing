package olaven.function;

import java.util.Objects;

/**
 * Represents an operation that accepts a single input argument and returns no
 * result. Unlike most other functional interfaces, {@code Consumer} is expected
 * to operate via side-effects.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #accept(Object)}.
 *
 * @param <Type> the type of the input to the operation.
 * @param <Throwable> the type of exception that may be thrown
 *
 */
@FunctionalInterface
public interface Consumer<Type, Throwable extends java.lang.Throwable> {

    /**
     * Performs this operation on the given argument.
     *
     * @param type the input argument
     */
    void accept(Type type) throws Throwable;

    /**
     * Returns a composed {@code Consumer} that performs, in sequence, this
     * operation followed by the {@code after} operation. If performing either
     * operation throws an exception, it is relayed to the caller of the
     * composed operation.  If performing this operation throws an exception,
     * the {@code after} operation will not be performed.
     *
     * @param after the operation to perform after this operation
     * @return a composed {@code Consumer} that performs in sequence this
     * operation followed by the {@code after} operation
     * @throws NullPointerException if {@code after} is null
     */
    default olaven.function.Consumer<Type, Throwable> andThen(olaven.function.Consumer<? super Type, Throwable> after) {
        Objects.requireNonNull(after);
        return (Type type) -> { accept(type); after.accept(type); };
    }
}



