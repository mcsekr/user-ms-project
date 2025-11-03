package in.co.practice.ms.login.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.co.practice.ms.login.entity.LoginEntity;

@Repository
public interface LoginRepo extends JpaRepository<LoginEntity, String> {

}
