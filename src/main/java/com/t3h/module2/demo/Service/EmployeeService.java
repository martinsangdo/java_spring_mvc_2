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
    
}