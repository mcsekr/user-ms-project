package in.co.practice.ms.read.all.util;

import in.co.practice.ms.read.all.dto.EmployeeDto;
import in.co.practice.ms.read.all.entity.Employee;

public class EmployeeUtils {

	public static Employee getEmployeeFromDto(EmployeeDto dto) {
		return new Employee(dto.getId(), dto.getName(), dto.getAge(), dto.getQualification());
	}

	public static EmployeeDto getEmployeeDtoFromEntity(Employee entity) {
		return new EmployeeDto(entity.getId(), entity.getName(), entity.getAge(), entity.getQualification());
	}

}
