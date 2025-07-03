package code.employee.emrs_backend.controller;

import code.employee.emrs_backend.dto.EmployeeDto;
import code.employee.emrs_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto>createEmployee(@RequestBody EmployeeDto employeeDto){
    EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
    return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto>getEmployeeById(@PathVariable("id")Long employeeId){
        EmployeeDto employeeDto=employeeService.getEmployeeById(employeeId);
        return new  ResponseEntity<>(employeeDto,HttpStatus.OK);
    }
    //Get All Employees Rest Api
     @GetMapping ResponseEntity<List<EmployeeDto>>getAllEmployees(){
         List<EmployeeDto>employees=employeeService.getAllEmployees();
         return new  ResponseEntity<>(employees,HttpStatus.OK);
     }
     //build updates employee
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto>updateEmployee(@PathVariable("id")Long employeeId,@RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto=employeeService.updateEmployee(employeeId,updatedEmployee);
        return new  ResponseEntity<>(employeeDto,HttpStatus.OK);
    }
//delete employee//
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable("id")Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted sucessFully");
    }
}