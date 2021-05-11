package com.info.sky.quizbattle.service.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

public class Uqid 
{
	public static String getuqid()
	{
		return UUID.randomUUID()+"";
	}
	
	public static String genrateOTP() {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 6 character.
	    return String.format("%06d", number);
	}
	
	public static String genrateOderId() {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
	    Random rnd = new Random();
	    int n1 = rnd.nextInt(999999);
	    int n2 = rnd.nextInt(999999);
	    int n3 = rnd.nextInt(999999);
	    // this will convert any number sequence into 6 character.
	    
	    String val=String.format("%06d", n1)+
	    		String.format("%06d", n2)+
	    		String.format("%06d", n3);
	    return "OD"+val;
	}
	
	public static String genratePaymentRecipt() {
	    // It will generate 8 digit random Number.
	    // from 0 to 999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(99999999);

	    // this will convert any number sequence into 6 character.
	    return "txn_"+String.format("%08d", number);
	}
	
	
	
	
	
	///////////////////
	public static String  genrateToken(String username,String password)
	{
		String token="";
		
		token=username(username)+password(password);
		
		return token;
	};
	
	
	private static String username(String username)
	{
		try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(username.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
	}
	
	
		private static String password(String password)
		{
			try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            byte[] messageDigest = md.digest(password.getBytes());
	            BigInteger number = new BigInteger(1, messageDigest);
	            String hashtext = number.toString(16);
	            while (hashtext.length() < 32) {
	                hashtext = "0" + hashtext;
	            }
	            return hashtext;
	        }
	        catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	       
	}
		
  }		
}
