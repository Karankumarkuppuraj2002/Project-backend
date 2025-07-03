package code.employee.emrs_backend.repository;

import code.employee.emrs_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    void deleteById(Long employeeId);
}
