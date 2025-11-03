package in.co.practice.ms.registration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.practice.ms.registration.dto.EmployeeDto;
import in.co.practice.ms.registration.entity.Employee;
import in.co.practice.ms.registration.exceptions.DuplicateEmployeePresent;
import in.co.practice.ms.registration.repo.EmployeeRepo;
import in.co.practice.ms.registration.service.EmployeeService;
import in.co.practice.ms.registration.util.EmployeeUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	

	@Override
	public EmployeeDto saveEmployee(EmployeeDto dto) throws DuplicateEmployeePresent {
		Employee entity = EmployeeUtils.getEmployeeFromDto(dto);
		System.out.println(entity.getId());
		if (employeeRepo.findById(entity.getId()).isPresent()) {
			throw new DuplicateEmployeePresent("The employee already exist with the id: " + dto.getId());
		}
		Employee emp = employeeRepo.save(EmployeeUtils.getEmployeeFromDto(dto));
		return EmployeeUtils.getEmployeeDtoFromEntity(emp);
	}

	

}
