package com.api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class A {
    public static void main(String[] args) {
        //  Pradicate fuctional Interface
        //It takes input & produces boolean value output

        Predicate<Integer> val = x -> x > 3;
        boolean result = val.test(100);
        System.out.println(result);

        Predicate<String> vals = x->x.equals("mike");
        boolean results = vals.test("mike");
        System.out.println(result);

        List<Integer> data = Arrays.asList(100, 10, 35, 5, 500, 700);
        List<Integer> newdata = data.stream().filter(x -> x > 100).collect(Collectors.toList());
        System.out.println(newdata);

        List<String> data1 = Arrays.asList("mike", "adam", "madam", "bike", "me");
        List<String> newdata1 = data1.stream().filter(x -> x.startsWith("m")).collect(Collectors.toList());
        System.out.println(newdata1);
        //odd and even number in stream API

        //Function Functional Interface
          //It takes input & produces an output
        Function<String,Integer> x= s->s.length();
        Integer val1 = x.apply("mike");
        System.out.println(val1);

        Function<Integer,Integer> xdata= s->s*s;
        Integer val2 = xdata.apply(100);
        System.out.println(val2);

        List<Integer> xdata1 = Arrays.asList(10, 20, 30, 12, 14);
        List<Integer> collect = data.stream().map(y -> y*y).collect(Collectors.toList());
        System.out.println(collect);

        List<String> data2= Arrays.asList("mike", "stallin","admin");
        List<Integer> collect1 = data2.stream().map(d -> d.length()).collect(Collectors.toList());
        System.out.println(collect1);
        //sorted(),d.toUpperCase(),d.length()
        //stream.sorted(),.distint(),filter(s->s.lenth())

        //Consumer Fucrional interface
        //It takes one input & produces no output

        Consumer<String> xs= s-> System.out.println(s);
        xs.accept("mike");

        List<String> names= Arrays.asList("allan", "pw", "kota");
        Consumer<String> vall= s-> System.out.print(s);
        names.forEach((vall));


    }

}