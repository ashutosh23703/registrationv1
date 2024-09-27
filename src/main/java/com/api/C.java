//package com.api;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class C {
//    public static void main(String[] args) {
//
//        List<Employee1> employee1s = Arrays.asList(
//                new Employee1(1, "mike"),
//                new Employee1(2, "stallin"),
//                new Employee1(3, "omme")
//        );
//
//        List<EmployeeDto> dtos = employee1s.stream().map(e -> mapToDto(e)).collect(Collectors.toList());
//        //map(A::maptoDto)
//    }
//     static EmployeeDto mapToDto(Employee1 employee){
//        EmployeeDto dto = new EmployeeDto();
//        dto.setId(employee.getId());
//        dto.setId(employee.getId());
//        dto.setName(employee.getName());
//        return dto;
//    }
//}
