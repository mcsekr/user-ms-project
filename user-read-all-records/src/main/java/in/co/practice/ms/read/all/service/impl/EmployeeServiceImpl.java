package in.co.practice.ms.read.all.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.practice.ms.read.all.dto.EmployeeDto;
import in.co.practice.ms.read.all.repo.EmployeeRepo;
import in.co.practice.ms.read.all.service.EmployeeService;
import in.co.practice.ms.read.all.util.EmployeeUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<EmployeeDto> emps = new ArrayList<EmployeeDto>();
		employeeRepo.findAll().forEach(e -> emps.add(EmployeeUtils.getEmployeeDtoFromEntity(e)));
		return emps;
	}

	

}
