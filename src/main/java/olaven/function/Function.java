/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package olaven.function;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Objects;

/**
 * Works exactly like java.util.function.Function,
 * except for that it accepts a Exception/Throwable
 * as second generic.
 *
 * @param <T> the type of the input to the function
 * @param <R> the type of the result of the function
 * @param <ExceptionType> exception that may be thrown
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Function<T, R, ExceptionType extends Throwable> {

    R apply(T t) throws ExceptionType;


    default <V> Function<V, R, ExceptionType> compose(Function<? super V, ? extends T, ExceptionType> before) throws ExceptionType {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }


    default <V> Function<T, V, ExceptionType> andThen(Function<? super R, ? extends V, ExceptionType> after) throws ExceptionType {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }


    static <T, ExceptionType extends Throwable> Function<T, T, ExceptionType> identity() throws ExceptionType {
        return t -> t;
    }
}
