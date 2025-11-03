package in.co.practice.ms.read.single.record.util;

import in.co.practice.ms.read.single.record.dto.EmployeeDto;
import in.co.practice.ms.read.single.record.entity.Employee;

public class EmployeeUtils {

	public static Employee getEmployeeFromDto(EmployeeDto dto) {
		return new Employee(dto.getId(), dto.getName(), dto.getAge(), dto.getQualification());
	}

	public static EmployeeDto getEmployeeDtoFromEntity(Employee entity) {
		return new EmployeeDto(entity.getId(), entity.getName(), entity.getAge(), entity.getQualification());
	}

}
