package code.employee.emrs_backend.service;
//1//
import code.employee.emrs_backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto>getAllEmployees();
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto update);
    void deleteEmployee(Long employeeId);
}
