package in.co.practice.ms.read.single.record.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.practice.ms.read.single.record.dto.EmployeeDto;
import in.co.practice.ms.read.single.record.entity.Employee;
import in.co.practice.ms.read.single.record.exceptions.NoEmployeePresentException;
import in.co.practice.ms.read.single.record.repo.EmployeeRepo;
import in.co.practice.ms.read.single.record.service.EmployeeService;
import in.co.practice.ms.read.single.record.util.EmployeeUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public EmployeeDto getSingleEmployee(int empId) throws NoEmployeePresentException {
		Optional<Employee> results = employeeRepo.findById(empId);
		if (results.isEmpty()) {
			throw new NoEmployeePresentException("No employee present with the id " + empId);
		}
		return EmployeeUtils.getEmployeeDtoFromEntity(results.get());
	}

}
