package com.t3h.module2.demo.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    public HashMap createNewEmployee(Map param){
        HashMap<String, Object> employee = new HashMap<>();
        employee.put("name", param.get("name"));
        employee.put("email", param.get("email"));
        employee.put("department", param.get("department"));
        employee.put("salary", param.get("salary"));
        return employee;
    }

    public HashMap updateEmployee(List<HashMap<String, Object>> employees, Map newParams){
        HashMap<String, Object> newEmp = new HashMap<>();
        for (HashMap<String, Object> emp : employees) {
            Object nameObj = emp.get("name");
            if (nameObj != null && nameObj.toString().toLowerCase().equalsIgnoreCase(newParams.get("name").toString())) {
                //update info
                newEmp.put("name", emp.get("name"));
                newEmp.put("department", emp.get("department"));
                newEmp.put("email", emp.get("email"));
                newEmp.put("salary", newParams.get("salary"));
                break;
            }
        }
        return newEmp;
    }
}