package com.api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class B {
    public static void main(String[] args) {
        List<Employee> data = Arrays.asList(
                new Employee(1, "mike", 5000),
                new Employee(2, "stallin", 4000),
                new Employee(3, "adam", 7000)

        );
        List<Employee> newdata = data.stream().filter(e -> e.getSal() > 4000).collect(Collectors.toList());
        for (Employee emp: newdata) {
            System.out.println(emp.getId());
            System.out.println(emp.getName());
            System.out.println(emp.getSal());
        }
        Map<Integer, List<Employee>> newdata1 = data.stream().collect(Collectors.groupingBy(e -> e.getSal()));

        List<Integer> list = Arrays.asList(10, 20, 13, 15);
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        List<Integer> list1 = Arrays.asList(3, 5, 65, 234, 34);
        Optional<Integer> max = list1.stream().max(Integer::compareTo);
        System.out.println(max.get());




    }
}
