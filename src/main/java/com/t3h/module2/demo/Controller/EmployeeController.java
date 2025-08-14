package com.t3h.module2.demo.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.t3h.module2.demo.Service.EmployeeService;

@RestController
public class EmployeeController {
    public List<HashMap<String, Object>> getData(){
       List<HashMap<String, Object>> EMPLOYEES = new ArrayList<>();
       //Employee 1
       HashMap<String, Object> employee1 = new HashMap<>();
       employee1.put("name", "Alice");
       employee1.put("email", "alice.smith@example.com");
       employee1.put("department", "HR");
       employee1.put("salary", 7000);
       EMPLOYEES.add(employee1);
       //Employee 2
       HashMap<String, Object> employee2 = new HashMap<>();
       employee2.put("name", "Johnson");
       employee2.put("email", "js.me@gmail.com");
       employee2.put("department", "HR");
       employee2.put("salary", 5000);
       EMPLOYEES.add(employee2);
       //Employee 3
       HashMap<String, Object> employee3 = new HashMap<>();
       employee3.put("name", "Bob");
       employee3.put("email", "bod.dylan@dylan.com");
       employee3.put("department", "IT");
       employee3.put("salary", 3000);
       EMPLOYEES.add(employee3);
       return EMPLOYEES;
   }

   @Autowired
    EmployeeService employeeService;

    @GetMapping("/api/search_employees")
    public ResponseEntity<List<HashMap<String, Object>>> searchEmployees(@RequestParam String keyword){
        List<HashMap<String, Object>> employees = getData();
        List<HashMap<String, Object>> results = employeeService.searchEmployees(employees, keyword);
        return new ResponseEntity<List<HashMap<String, Object>>>(results, HttpStatus.OK);
    }
    @GetMapping("/api/search_employees_2")
    public ResponseEntity<List<HashMap<String, Object>>> searchEmployees2(@RequestParam String department, @RequestParam Integer min_salary){
        List<HashMap<String, Object>> employees = getData();
        List<HashMap<String, Object>> results = employeeService.searchEmployees2(employees, department, min_salary);
        return new ResponseEntity<List<HashMap<String, Object>>>(results, HttpStatus.OK);
    }

    @PostMapping("/api/employee/create")
    public ResponseEntity<List> createNewData(@RequestParam String name,
        @RequestParam String email, @RequestParam String department, @RequestParam Integer salary){
        HashMap<String, Object> employee = new HashMap<>();
        employee.put("name", name);
        employee.put("email", email);
        employee.put("department", department);
        employee.put("salary", salary);
        List<HashMap<String, Object>> employees = getData();
        employees.add(employee);
        return new ResponseEntity<List>(employees, HttpStatus.OK);
    }

    @PostMapping("/api/employee/create_2")
    public ResponseEntity<List> createNewDataByBody(@RequestBody Map<String, Object> param){
        HashMap<String, Object> employee = new HashMap<>();
        employee.put("name", param.get("name"));
        employee.put("email", param.get("email"));
        employee.put("department", param.get("department"));
        employee.put("salary", param.get("salary"));
        List<HashMap<String, Object>> employees = getData();
        employees.add(employee);
        return new ResponseEntity<List>(employees, HttpStatus.OK);
    }

    @PutMapping("/api/employee/update")
    public ResponseEntity<HashMap<String, Object>> changeEmployeeInfo(@RequestBody Object newData){
        List<HashMap<String, Object>> employees = getData();
        //todo
        //
        return new ResponseEntity<HashMap<String, Object>>(employees.get(0), HttpStatus.OK);
    }
}
