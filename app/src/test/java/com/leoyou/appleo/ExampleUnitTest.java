package com.leoyou.appleo;

import android.support.annotation.NonNull;
import android.support.v7.util.SortedList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static android.R.attr.max;
import static android.R.attr.x;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        initData();
        next();
    }

    List<UserBean> mData;

    public void initData() {

        mData = new ArrayList<>();
        UserBean userBean1 = new UserBean("王尼玛", "1101=", 1, 10);
        UserBean userBean2 = new UserBean("李老三si", "2231=", 21, 14);
        UserBean userBean3 = new UserBean("王二小ada", "=", 2, 10);
        UserBean userBean4 = new UserBean("小猪", "qew=", 3, 101);
        UserBean userBean5 = new UserBean("主", "dadad=", 5, 80);
        UserBean userBean6 = new UserBean("", "1101=", 7, 120);
        UserBean userBean7 = new UserBean("hahahaha", "qeqwead=", 124, 50);
        mData.add(userBean1);
        mData.add(userBean2);
        mData.add(userBean3);
        mData.add(userBean4);
        mData.add(userBean5);
        mData.add(userBean6);
        mData.add(userBean7);
    }

    public void next() {
//        Stream<UserBean> stream = mData.stream().filter(s -> s.getAge() > 10);
////        stream.forEach(userBean -> System.out.println(userBean.getName()));
//        String name1 = stream.max((o1, o2) -> o1.getAge() - o2.getAge()).get().getName();
//        String name2 = mData.stream().min((o1, o2) -> o1.getAge() - o2.getAge()).get().getName();
//        System.out.println(name1 + "===" + name2);
//        System.out.println("===================");
//        Stream<Integer> integerStream = mData.stream().map(userBean -> userBean.getId());
//        Stream<String> integerStream1 = mData.stream().map(userBean -> userBean.getName());
//        IntStream intStream = integerStream.mapToInt((x) -> x);
//        IntStream intStream1 = integerStream1.mapToInt(value -> value.length());
//        intStream1.forEach(value -> System.out.println(value + ""));
//
//
//        System.out.println("===================");
////        integerStream1.forEach(x-> System.out.println(x));
//        int sum = intStream.sum();
//        System.out.println(sum);
//
//        mData.stream().filter(new Predicate<UserBean>() {
//            @Override
//            public boolean test(UserBean userBean) {
//                return userBean.getId() > 0;
//            }
//        });
//        mData.stream().forEach(new Consumer<UserBean>() {
//            @Override
//            public void accept(UserBean userBean) {
//                System.out.println(userBean.toString());
//            }
//        });
//        mData.stream().map(new Function<UserBean, UserBean>() {
//            /**
//             * Applies this function to the given argument.
//             *
//             * @param userBean the function argument
//             * @return the function result
//             */
//            @Override
//            public UserBean apply(UserBean userBean) {
//                return new UserBean("userBean", "ADA", 11, 111);
//            }
//        });
//        mData.stream().allMatch(new Predicate<UserBean>() {
//            @Override
//            public boolean test(UserBean userBean) {
//                return userBean.getAge() > 10;
//            }
//        });
//        mData.stream().anyMatch(new Predicate<UserBean>() {
//            @Override
//            public boolean test(UserBean userBean) {
//                return userBean.getAge() > 10;
//            }
//        });
//        mData.stream().collect(new Collector<UserBean, String, String>() {
//            /**
//             * A function that creates and returns a new mutable result container.
//             *
//             * @return a function which returns a new, mutable result container
//             */
//            @Override
//            public Supplier<String> supplier() {
//                return new Supplier<String>() {
//                    @Override
//                    public String get() {
//                        return "111";
//                    }
//                };
//            }
//
//            /**
//             * A function that folds a value into a mutable result container.
//             *
//             * @return a function which folds a value into a mutable result container
//             */
//            @Override
//            public BiConsumer<String, UserBean> accumulator() {
//                return new BiConsumer<String, UserBean>() {
//                    @Override
//                    public void accept(String s, UserBean userBean) {
//                        System.out.println(s + "=====" + userBean.getName());
//                    }
//                };
//            }
//
//            /**
//             * A function that accepts two partial results and merges them.  The
//             * combiner function may fold state from one argument into the other and
//             * return that, or may return a new result container.
//             *
//             * @return a function which combines two partial results into a combined
//             * result
//             */
//            @Override
//            public BinaryOperator<String> combiner() {
//                return new BinaryOperator<String>() {
//                    @Override
//                    public String apply(String s, String s2) {
//                        System.out.println(s + "====" + s2);
//                        return s + s2;
//                    }
//                };
//            }
//
//            /**
//             * Perform the final transformation from the intermediate accumulation type
//             * {@code A} to the final result type {@code R}.
//             * <p>
//             * <p>If the characteristic {@code IDENTITY_TRANSFORM} is
//             * set, this function may be presumed to be an identity transform with an
//             * unchecked cast from {@code A} to {@code R}.
//             *
//             * @return a function which transforms the intermediate result to the final
//             * result
//             */
//            @Override
//            public Function<String, String> finisher() {
//                return new Function<String, String>() {
//                    @Override
//                    public String apply(String s) {
//                        return s;
//                    }
//                };
//            }
//
//            /**
//             * Returns a {@code Set} of {@code Collector.Characteristics} indicating
//             * the characteristics of this Collector.  This set should be immutable.
//             *
//             * @return an immutable set of collector characteristics
//             */
//            @Override
//            public Set<Characteristics> characteristics() {
//                return new Set<Characteristics>() {
//                    @Override
//                    public int size() {
//                        return 0;
//                    }
//
//                    @Override
//                    public boolean isEmpty() {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean contains(Object o) {
//                        return false;
//                    }
//
//                    @NonNull
//                    @Override
//                    public Iterator<Characteristics> iterator() {
//                        return null;
//                    }
//
//                    @NonNull
//                    @Override
//                    public Object[] toArray() {
//                        return new Object[0];
//                    }
//
//                    @NonNull
//                    @Override
//                    public <T> T[] toArray(@NonNull T[] a) {
//                        return null;
//                    }
//
//                    @Override
//                    public boolean add(Characteristics characteristics) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean remove(Object o) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean containsAll(@NonNull Collection<?> c) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean addAll(@NonNull Collection<? extends Characteristics> c) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean retainAll(@NonNull Collection<?> c) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean removeAll(@NonNull Collection<?> c) {
//                        return false;
//                    }
//
//                    @Override
//                    public void clear() {
//
//                    }
//                };
//            }
//        });
//        mData.stream().count();
//        Stream<UserBean> distinct = mData.stream().distinct();
//
//        mData.stream().forEachOrdered(new Consumer<UserBean>() {
//            @Override
//            public void accept(UserBean userBean) {
//                userBean.getName();
//            }
//        });
////        Stream<UserBean> limit = mData.stream().limit(10);
//        Stream<UserBean> peek = mData.stream().peek(new Consumer<UserBean>() {
//            @Override
//            public void accept(UserBean userBean) {
//                userBean.getName().toLowerCase();
//            }
//        });
//        peek.forEach(userBean -> System.out.println(userBean.getName()));
//
//
//        Optional<UserBean> reduce = mData.stream().reduce((userBean, userBean2) -> {
//            if (userBean2.getAge() > userBean.getAge())
//                return userBean;
//            else
//                return userBean2;
//        });

        Stream<UserBean> sorted = mData.stream().sorted(new Comparator<UserBean>() {
            @Override
            public int compare(UserBean o1, UserBean o2) {
                return o1.getName().length()-o2.getName().length();
            }
        });
        sorted.forEach(userBean -> System.out.println(userBean.getName()));

        mData.stream().max(new Comparator<UserBean>() {
            @Override
            public int compare(UserBean o1, UserBean o2) {
                return o1.getAge()-o2.getAge();
            }
        });
//        mData.stream().peek(new Consumer<UserBean>() {
//            @Override
//            public void accept(UserBean userBean) {
//                userBean
//            }
//        });

//        reduce.get();

//        Stream<String> limit = a.limit(10);
//        limit.collect()
//        List<String> collect = a.collect(Collectors.toList());
//        Set<UserBean> collect1 = a.collect(Collectors.toSet());

    }

    private Set<String> toSet() {

        return null;
    }
}