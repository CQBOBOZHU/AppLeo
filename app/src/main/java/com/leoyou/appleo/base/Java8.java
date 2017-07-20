package com.leoyou.appleo.base;

import com.leoyou.appleo.bean.UserBean;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by BoBoZhu on 2017/7/18.
 */

public class Java8 {
    /**
     * Predicate 接口只有一个参数，返回boolean类型。
     * 该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）：
     */
    public void Predicate() {

        Predicate<List<UserBean>> predicate = s -> s.size() > 0;
        boolean test = predicate.test(new ArrayList<>());
//        boolean wadad = predicate.negate().test("WADAD");
//        boolean wadad1 = predicate.or(predicate).test("ADADAD");
//        boolean android = predicate.and(predicate).test("android");
    }

    /**
     * Function 接口有一个参数并且返回一个结果，
     * 并附带了一些可以和其他函数组合的默认方法（compose, andThen）：
     */
    public void Function() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        String apply = backToString.apply("123");// "123"
        Function<String, String> stringFunction = String::new;
        String aadajd = stringFunction.apply("AADAJD");
    }

    /**
     * Supplier 接口返回一个任意范型的值，和Function接口不同的是该接口没有任何参数
     */
    public void Supplier() {
        Supplier<String> s = String::new;
        Supplier<Integer> supplier = null;
        Integer integer = supplier.get();

    }

    /**
     * Consumer 接口表示执行在单个参数上的操作。
     */
    public void Consumer() {
        Consumer<String> greeter = (p) -> System.out.println("Hello, " + p);
        greeter.accept("WADADADAD");
    }

    /**
     * Comparator 是老Java中的经典接口， Java 8在此之上添加了多种默认方法：
     */
    public void Comparator() {
        Comparator<UserBean> userBeanComparator = (user1, user2) -> user1.getName().compareTo(user2.getName());
        UserBean userBean1 = new UserBean("王老三", "男", 1);
        UserBean userBean2 = new UserBean("李老四", "男", 1);
        int compare = userBeanComparator.compare(userBean1, userBean2);
    }

    /**
     * Optional 不是函数是接口，这是个用来防止NullPointerException异常的辅助类型，
     * 这是下一届中将要用到的重要概念，
     * 现在先简单的看看这个接口能干什么：
     * Optional 被定义为一个简单的容器，
     * 其值可能是null或者不是null。
     * 在Java 8之前一般某个函数应该返回非空对象但是偶尔却可能返回了null，
     * 而在Java 8中，不推荐你返回null而是返回Optional。
     */
    public void Optional() {
        Optional<String> optional = Optional.of("bam");
        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
    }

    /**
     * java.util.Stream 表示能应用在一组元素上一次执行的操作序列。
     * Stream 操作分为中间操作或者最终操作两种，
     * 最终操作返回一特定类型的计算结果
     * ，而中间操作返回Stream本身，这样你就可以将多个操作依次串起来。
     * Stream 的创建需要指定一个数据源，比如 java.util.Collection的子类，List或者Set，
     * Map不支持。
     * Stream的操作可以串行执行或者并行执行。
     */
    public void Stream() {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
    }

    /**
     * Filter 过滤
     * 过滤通过一个predicate接口来过滤并只保留符合条件的元素，
     * 该操作属于中间操作，所以我们可以在过滤后的结果来应用其他Stream操作（比如forEach）。
     * forEach需要一个函数来对过滤后的元素依次执行。forEach是一个最终操作，
     * 所以我们不能在forEach之后来执行其他Stream操作。
     */
    public void filter(List<String> stringCollection) {
        Stream<String> aaa = stringCollection.stream().filter(s -> s.equals("AAA"));
        aaa.forEach(s -> System.out.println(s));
        List<UserBean> userBeens = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userBeens.add(new UserBean("xiaoming" + i, "nan", i));
        }
        userBeens.stream().filter(userBean -> userBean.getId() % 10 == 0).mapToInt(UserBean::getId).sum();
    }

    /**
     * 排序是一个中间操作，返回的是排序好后的Stream。
     * 如果你不指定一个自定义的Comparator则会使用默认排序。
     * <p>
     * 需要注意的是，排序只创建了一个排列好后的Stream，
     * 而不会影响原有的数据源，排序之后原数据stringCollection是不会被修改的：
     *
     * @param stringCollection
     */
    public void Sort(List<String> stringCollection) {
        Stream<String> sorted = stringCollection.stream().sorted();
        sorted.forEach(s -> System.out.println(s));
    }

    /**
     * 中间操作map会将元素根据指定的Function接口来依次将元素转成另外的对象，
     * 下面的示例展示了将字符串转换为大写字符串。
     * 你也可以通过map来讲对象转换成其他类型，
     * map返回的Stream类型是根据你map传递进去的函数的返回值决定的。
     *
     * @param stringCollection
     */
    public void Map(List<String> stringCollection) {
        Stream<String> stringStream = stringCollection.stream().map(s -> s.toUpperCase());
        stringStream.forEach(s -> System.out.println(s));
    }

    /**
     * Stream提供了多种匹配操作，允许检测指定的Predicate是否匹配整个Stream。
     * 所有的匹配操作都是最终操作，并返回一个boolean类型的值。
     *
     * @param stringCollection
     */
    public void Match(List<String> stringCollection) {
        boolean a = stringCollection.stream().allMatch(s -> s.contains("A"));
        boolean b = stringCollection.stream().anyMatch(s -> s.contains("B"));
        boolean c = stringCollection.stream().noneMatch(s -> s.contains("B"));
    }

    /**
     * Count
     * 计数是一个最终操作，返回Stream中元素的个数，
     * 返回值类型是long。
     */
    public void Count(List<String> stringCollection) {
        long count = stringCollection.stream().count();
    }

    /**
     * 这是一个最终操作，允许通过指定的函数来讲stream中的多个元素规约为一个元素，
     * 规越后的结果是通过Optional接口表示的：
     */
    public void Reduce(List<String> stringCollection) {
//        stringCollection.stream().reduce()
    }

    public void text(List<UserBean> userBeens) {
//        userBeens.stream().fl
    }

    /**
     * peek
     * peek: 生成一个包含原Stream的所有元素的新Stream，
     * 同时会提供一个消费函数（Consumer实例），
     * 新Stream每个元素被消费的时候都会执行给定的消费函数；
     */
    public void peek() {

    }
}
