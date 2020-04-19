package com.zmq;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * User: zmq
 * Date: 2020/4/19
 * <p>Stream常见操作API介绍
 *  1. 聚合操作
 *
 *  2. stream的处理流程
 *      数据源
 *      数据转换
 *      获取结果
 *  3. 获取Stream对象
 *      1. 从集合或者数组中获取[**]
 *          Collection.stream()，如accounts.stream()
 *          Collection.parallelStream()
 *          Arrays.stream(T t)
 *      2. BufferReader
 *          BufferReader.lines()-> stream()
 *      3. 静态工厂
 *          java.util.stream.IntStream.range()..
 *          java.nio.file.Files.walk()..
 *      4. 自定构建
 *          java.util.Spliterator
 *      5. 更多的方式..
 *          Random.ints()
 *          Pattern.splitAsStream()..
 *   4. 中间操作API{intermediate}
 *      操作结果是一个Stream，中间操作可以有一个或者多个连续的中间操作，需要注意的是，中间操作
 *          只记录操作方式，不做具体执行，直到结束操作发生时，才做数据的最终执行。
 *          中间操作：就是业务逻辑处理。
 *      中间操作过程：无状态：数据处理时，不受前置中间操作的影响。
 *                      map/filter/peek/parallel/sequential/unordered
 *                  有状态：数据处理时，受到前置中间操作的影响。
 *                      distinct/sorted/limit/skip
 *   5. 终结操作|结束操作{Terminal}
 *      需要注意：一个Stream对象，只能有一个Terminal操作，这个操作一旦发生，就会真实处理数据，生成对应的处理结果。
 *      终结操作：非短路操作：当前的Stream对象必须处理完集合中所有 数据，才能得到处理结果。
 *                  forEach/forEachOrdered/toArray/reduce/collect/min/max/count/iterator
 *              短路操作：当前的Stream对象在处理过程中，一旦满足某个条件，就可以得到结果。
 *                  anyMatch/allMatch/noneMatch/findFirst/findAny等
 *                  Short-circuiting，无限大的Stream-> 有限大的Stream。
 * </p>
 */
public class Test3 {
    public static void main(String[] args) {
        //1.批量数据-> Stream对象
        // 多个数据
        Stream<String> stream = Stream.of("tom", "xiaobai", "xiaohei");
        //数组
        String[] stringArray = new String[]{"xueqi","baibai"};
        Stream<String> stream1 = Arrays.stream(stringArray);
        //列表
        List<String> list = new ArrayList<>();
        list.add("小白");
        list.add("小何");
        list.add("小黑");
        Stream<String> stream2 = list.stream();
        //集合
        HashSet<String> set = new HashSet<>();
        set.add("小白");
        set.add("小何");
        set.add("小黄");
        Stream<String> stream3 = set.stream();
        //map
        Map<String,Integer> map = new HashMap<>();
        map.put("xiaobai",18);
        map.put("xiaohuang",20);
        map.put("xiaohei",21);
        Stream<Map.Entry<String, Integer>> stream4 = map.entrySet().stream();
        // 2.stream对象用于基本数据类型功能封装
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1,5).forEach(System.out::println);
        IntStream.rangeClosed(1,5).forEach(System.out::println);
        // 3.stream对象转换得到指定的数据类型
        //数组
        //String[] strings = stream.toArray(String[]::new);
        //字符串
        //String collect = stream.collect(Collectors.joining());
        //列表
        //List<String> stringList = stream.collect(Collectors.toList());
        //集合
        //Set<String> stringSet = stream.collect(Collectors.toSet());
        //map
        //Map<String, String> stringMap = stream.collect(Collectors.toMap(x -> x, y -> "value:" + y));
        //4. Stream中常见的api
        List<String> accountList = new ArrayList<>();
        accountList.add("小白");
        accountList.add("小何");
        accountList.add("小黑");
        //map() 中间操作，map()方法接收一个Functional接口
        //accountList=accountList.stream().map(account->"name:"+account).collect(Collectors.toList());
        // filter 添加过滤条件，过滤符合条件的用户
//        accountList = accountList.stream().filter(x->x.length()>0).collect(Collectors.toList());
        //foreach增强型循环
//        accountList.forEach(account-> System.out.println("ForEach->"+account));
        // peek()中间操作，迭代数据完成数据的依次处理
//        accountList.stream().peek(x-> System.out.println("peek1"+x))
//        .peek(x-> System.out.println("peek2"+x))
//        .forEach(System.out::println);
//        accountList.forEach(System.out::println);

        //Stream 中对于数字运算的支持
        List<Integer> integerList = new ArrayList<>();
        integerList.add(20);
        integerList.add(21);
        integerList.add(23);
        integerList.add(27);
        //skip() 中间操作，有状态，跳过部分数据
//        integerList.stream().skip(2).forEach(System.out::println);
        //limit() 中间操作，有状态，限制输出数据量
//        integerList.stream().skip(2).limit(1).forEach(System.out::println);
        // distinct() 中间操作，有状态，剔除重复数据
//        integerList.stream().distinct().forEach(System.out::println);
        // sorted() 中间操作，有状态，排序
        // max() 获取最大值
        Optional<Integer> optional = integerList.stream().max((x, y) -> x - y);
        System.out.println(optional.get());
        // min() 获取最小值
        // reduce() 合并处理数据
        Optional<Integer> optional1 = integerList.stream().reduce((sum, x) -> sum += x);
        System.out.println(optional1.get());
    }


}
