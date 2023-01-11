package com.employees.service.api;

import com.employees.service.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/employees")
public class EmployeeApi {

    final private List<Employee> employees = new ArrayList<>();

    @PostMapping(value = "")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
        employees.add(employee);
        return ResponseEntity.ok(employee);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable(value = "id")Integer id) throws Exception {
        Optional<Employee> emp = employees.stream().filter(employee -> employee.getId().equals(id)).findFirst();
        if(emp.isEmpty()){
            throw new Exception("Employee not found");
        }else{
            return ResponseEntity.ok(emp.get());
        }
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getEmployee(){
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEmployee(@PathVariable(value = "id")Integer id){
        employees.removeIf(e -> e.getId().equals(id));
    }
}
