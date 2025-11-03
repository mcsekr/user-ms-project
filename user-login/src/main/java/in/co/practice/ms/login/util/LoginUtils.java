package in.co.practice.ms.login.util;

import in.co.practice.ms.login.dto.LoginDto;
import in.co.practice.ms.login.entity.LoginEntity;

public class LoginUtils {

	public static LoginEntity getEntityeFromDto(LoginDto dto) {
		LoginEntity entity = new LoginEntity();
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		return entity;
	}

	public static LoginDto getDtoFromEntity(LoginEntity entity) {
		return new LoginDto(entity.getEmail(), entity.getPassword());
	}

}
