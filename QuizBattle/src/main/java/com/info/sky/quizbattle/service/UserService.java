package com.info.sky.quizbattle.service;

import java.util.List;
import com.info.sky.quizbattle.entity.UserEntity;

public interface UserService {
	public String save(UserEntity entity);

	public List<UserEntity> getList();

	/* validation */

	public UserEntity login(String email, String password);
	
	
	public UserEntity getUserByUqid(String uqid);

	public boolean existsByToken(String token);

	/* reset password */
	public String sendOtp(String email);

	public boolean existsByEmailAndOtp(String email, String otp);

	public String updatePassword(String email, String password);

}
