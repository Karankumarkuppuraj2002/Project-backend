package code.employee.emrs_backend.service;

import code.employee.emrs_backend.dto.EmployeeDto;
import code.employee.emrs_backend.entity.Employee;
import code.employee.emrs_backend.exception.ResourceNotFoundException;
import code.employee.emrs_backend.mapper.EmployeeMapper;
import code.employee.emrs_backend.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService{


    private EmployeeRepository employeeRepository;
@Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto){
    Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
    Employee createemployee=employeeRepository.save(employee);
    return EmployeeMapper.mapToEmployeeDto(createemployee);

}

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
    Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee is not exists with given Id"+ employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
    List<Employee>employees=employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }
    @Override
    public EmployeeDto updateEmployee(Long employeeId,EmployeeDto updateEmployee){
    Employee employee=employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee is not found with given id:"+ employeeId));
employee.setFirstName(updateEmployee.getFirstName());
employee.setLastName(updateEmployee.getLastName());
employee.setEmail(updateEmployee.getEmail());

Employee updatedEmployee=employeeRepository.save(employee);
return  EmployeeMapper.mapToEmployeeDto(updatedEmployee);

    }
    @Override
    public void deleteEmployee(Long employeeId){
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(()
                -> new ResourceNotFoundException("Employee is not found with given id:"+ employeeId));
        employeeRepository.deleteById(employeeId);



    }
}
