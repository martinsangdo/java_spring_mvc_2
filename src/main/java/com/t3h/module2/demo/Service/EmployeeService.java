package com.t3h.module2.demo.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public List<HashMap<String, Object>> searchEmployees(List<HashMap<String, Object>> employees, String keyword){
        List<HashMap<String, Object>> matched = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (HashMap<String, Object> emp : employees) {
            Object nameObj = emp.get("name");
            if (nameObj != null && nameObj.toString().toLowerCase().contains(lowerKeyword)) {
                matched.add(emp);
            }
        }

        return matched;
    }

    public List<HashMap<String, Object>> searchEmployees2(List<HashMap<String, Object>> employees, String department, Integer minSalary){
        List<HashMap<String, Object>> matched = new ArrayList<>();
        department = department.toLowerCase();

        for (HashMap<String, Object> emp : employees) {
            Object departmentObject = emp.get("department");
            Object salaryObject = emp.get("salary");

            if (departmentObject != null && departmentObject.toString().toLowerCase().contains(department) && 
                salaryObject != null && Integer.parseInt(salaryObject.toString()) >= minSalary) {
                matched.add(emp);
            }
        }

        return matched;
    }
    
}