package com.info.sky.quizbattle.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.sky.quizbattle.Dao.UserDao;
import com.info.sky.quizbattle.entity.UserEntity;
import com.info.sky.quizbattle.service.common.Config;
import com.info.sky.quizbattle.service.common.SendMailService;
import com.info.sky.quizbattle.service.common.Uqid;
import com.info.sky.quizbattle.service.common.UserCommonService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public String save(UserEntity entity) {

		if (userDao.existsByPhone(entity.getPhone()))
			return "Mobile Number allready exists !";
		else if (userDao.existsByEmail(entity.getEmail()))
			return "Email Address allready exists !";
		else if (userDao.existsByPassword(entity.getPassword()))
			return "Enter a valid password !";
		else {
			entity.setUqid(UUID.randomUUID() + "");
			entity.setOtp("000000");
			entity.setLogin(true);
			entity.setIsactive(true);

			entity.setWinning_amt(0);
			entity.setCash_amt(Config.cash_bonus);
			entity.setDeposit_amt(Config.deposit_cash);

			String token1 = UserCommonService.genrateToken(entity.getEmail(), entity.getPassword());
			entity.setToken(token1);

			String referCode = entity.getReferCode();
			if (userDao.existsByReferCode(referCode)) {

				UserEntity model = userDao.getByReferCode(referCode);
				entity.setReferBy(model);
				/* entity.setCash_amt(Config.cash_bonus + Config.refre_bonus);*/
				model.setReferCode(Uqid.genrateOTP());
				model.setCash_amt(model.getCash_amt() + Config.refre_bonus);

				userDao.save(model);
			}

			entity.setReferCode(Uqid.genrateOTP());
			userDao.save(entity);
			return "Registration Completed Successfully!";
		}
	}

	@Override
	public List<UserEntity> getList() {
		return userDao.findAll();
	}

	@Override
	public UserEntity login(String email, String password) {
		UserEntity model = new UserEntity();
		model.setToken("no");

		if (userDao.existsByEmailAndPassword(email, password))
			return userDao.getByEmailAndPassword(email, password);
		else
			return model;
	}

	
	
	@Override
	public UserEntity getUserByUqid(String uqid) {
		
			return userDao.getByUqid(uqid);
	
	}

	
	@Override
	public boolean existsByToken(String token) {
		return userDao.existsByToken(token);
	}
	
	@Override
	public boolean existsByEmailAndOtp(String email,String otp) {
		return userDao.existsByEmailAndOtp(email,otp);
	}

	@Override
	public String sendOtp(String email) {
		if(userDao.existsByEmail(email))
		{
			String otp = Uqid.genrateOTP();

			 boolean flag=SendMailService.sendOtp(email, otp); 
			 if(flag) {
				 userDao.updateUserOtp(email, otp); 
				 return "OTP sent Successfully!"; }
			else return "Something went wrong!";
		}
		else
		return "Record does't exists!";
	}
	
	@Override
	public String updatePassword(String email, String password) {
		String token=UserCommonService.genrateToken(email, password);	
		userDao.updateUserPassword(email, password,token); 
		return token;
	}
	
	
	
	

}
