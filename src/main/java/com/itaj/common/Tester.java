package com.itaj.common;

import java.util.function.Consumer;
import java.util.function.Function;

public abstract class Tester<T, TESTER extends Tester> {

    public static <T> ConsumerTester<T> create(Consumer<T> testFunction) {
        return new ConsumerTester<>(testFunction);
    }

    public static <T, R> FunctionTester<T, R> create(Function<T, R>  testFunction) {
        return new FunctionTester<>(testFunction);
    }

    public abstract TESTER test(T target);

    public static class ConsumerTester<T> extends Tester<T, ConsumerTester<T>> {

        private Consumer<T> testFunction;

        private ConsumerTester(Consumer<T> testFunction) {
            this.testFunction = testFunction;
        }

        @Override
        public ConsumerTester<T> test(T target) {
            TimeMonitor timeMonitor = new TimeMonitor(target.getClass());
            timeMonitor.start();
            testFunction.accept(target);
            timeMonitor.end();
            return this;
        }
    }

    public static class FunctionTester<T, R> extends Tester<T, FunctionTester<T, R>>{

        private Function<T, R> testFunction;

        private FunctionTester(Function<T, R> testFunction) {
            this.testFunction = testFunction;
        }

        public FunctionAndThenTester<T, R> andThen(Consumer<R> then) {
            return new FunctionAndThenTester<T, R>(testFunction, then);
        }

        @Override
        public FunctionTester<T, R> test(T target) {
            TimeMonitor timeMonitor = new TimeMonitor(target.getClass());
            timeMonitor.start();
            testFunction.apply(target);
            timeMonitor.end();
            return this;
        }
    }

    public static class FunctionAndThenTester<T, R> extends  Tester<T, FunctionAndThenTester<T, R>>{

        private Function<T, R> testFunction;
        private Consumer<R> then;

        private FunctionAndThenTester(Function<T, R> testFunction, Consumer<R> then) {
            this.testFunction = testFunction;
            this.then = then;
        }

        @Override
        public FunctionAndThenTester<T, R> test(T target) {
            TimeMonitor timeMonitor = new TimeMonitor(target.getClass());
            timeMonitor.start();
            R r = testFunction.apply(target);
            timeMonitor.end();
            then.accept(r);
            return this;
        }
    }
}
