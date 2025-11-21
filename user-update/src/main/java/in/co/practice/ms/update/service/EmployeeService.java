package in.co.practice.ms.update.service;

import in.co.practice.ms.update.dto.EmployeeDto;
import in.co.practice.ms.update.exceptions.DuplicateEmployeePresent;

public interface EmployeeService {

	public EmployeeDto saveEmployee(EmployeeDto dto) throws DuplicateEmployeePresent;

}
