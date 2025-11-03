package in.co.practice.ms.registration.util;

import in.co.practice.ms.registration.dto.EmployeeDto;
import in.co.practice.ms.registration.entity.Employee;

public class EmployeeUtils {

	public static Employee getEmployeeFromDto(EmployeeDto dto) {
		return new Employee(dto.getId(), dto.getName(), dto.getAge(), dto.getQualification());
	}

	public static EmployeeDto getEmployeeDtoFromEntity(Employee entity) {
		return new EmployeeDto(entity.getId(), entity.getName(), entity.getAge(), entity.getQualification());
	}

}
