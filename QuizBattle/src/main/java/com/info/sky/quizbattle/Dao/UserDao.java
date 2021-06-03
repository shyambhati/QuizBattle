package com.info.sky.quizbattle.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.info.sky.quizbattle.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {

	boolean existsByPhone(String val);

	boolean existsByEmail(String val);

	boolean existsByPassword(String val);

	boolean existsByEmailAndOtp(String email, String otp);

	boolean existsByEmailAndPassword(String email, String password);

	boolean existsByToken(String val);

	boolean existsByReferCode(String val);

	UserEntity getByReferCode(String val);

	UserEntity getByEmailAndPassword(String email, String password);

	@Modifying
	@Query("update UserEntity u set u.otp = :otp where u.email =:email")
	void updateUserOtp(@Param("email") String email, @Param("otp") String otp);

	@Modifying
	@Query("update UserEntity u set u.password = :password,u.token = :token where u.email =:email")
	void updateUserPassword(@Param("email") String email, @Param("password") String password,@Param("token") String token);

}
