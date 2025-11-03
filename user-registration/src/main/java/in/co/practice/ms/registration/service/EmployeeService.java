package in.co.practice.ms.registration.service;

import in.co.practice.ms.registration.dto.EmployeeDto;
import in.co.practice.ms.registration.exceptions.DuplicateEmployeePresent;

public interface EmployeeService {

	public EmployeeDto saveEmployee(EmployeeDto dto) throws DuplicateEmployeePresent;

}
