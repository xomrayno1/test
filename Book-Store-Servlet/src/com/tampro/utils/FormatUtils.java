package com.tampro.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tampro.model.Users;

public class FormatUtils {
	/*
	 * Mục đich : Format  input .
	 */
	
	public static boolean formatRegister(Users user) {
		if(user.getUserName().isEmpty() || user.getPassWord().isEmpty() || user.getName().isEmpty() || user.getPhone().isEmpty() || user.getEmail().isEmpty()) {
			return false;
		}else {
			if(user.getUserName().length() >= 15 || user.getUserName().length()  <= 6 ) {
				return false;
			}
			if(user.getPassWord().length() >= 15 || user.getPassWord().length()  <= 3 ) {
				return false;
			}
			if(user.getName().length() >= 25 || user.getName().length()  <= 3 ) {
				return false;
			}
			if( user.getPhone().length() >= 13 ||  user.getPhone().length()  <= 9 ) {
				return false;
			}
			if(user.getEmail().length() >= 30 || user.getEmail().length()  <= 6 ) {
				return false;
			}
		}		
		return true;
	}
	public static boolean formatEditUserFull(String name,String phone,String email,String passwordOld,String passwordNew,String passwordRepeat) {
		if( name.isEmpty() || phone.isEmpty() || email.isEmpty() || passwordOld.isEmpty() || passwordRepeat.isEmpty() || passwordNew.isEmpty()) {
			return false;
		}else {
			if(passwordNew.length() >= 15 || passwordNew.length()  <= 3 ) {
				return false;
			}
			if(passwordOld.length() >= 15 || passwordOld.length()  <= 3 ) {
				return false;
			}
			if(passwordRepeat.length() >= 15 || passwordRepeat.length()  <= 3 ) {
				return false;
			}
			if(name.length() >= 25 || name.length()  <= 3 ) {
				return false;
			}
			if( phone.length() >= 13 ||  phone.length()  <= 9 ) {
				return false;
			}
			if(email.length() >= 30 || email.length()  <= 6 ) {
				return false;
			}
		}		
		return true;
	}
	public static boolean formatEditUserPart(String name,String phone,String email) {
		if( name.isEmpty() || phone.isEmpty() || email.isEmpty() ) {
			return false;
		}else {
			if(name.length() >= 25 || name.length()  <= 3 ) {
				return false;
			}
			if( phone.length() >= 13 ||  phone.length()  <= 9 ) {
				return false;
			}
			if(email.length() >= 30 || email.length()  <= 6 ) {
				return false;
			}
		}		
		return true;
	}
	public static boolean formatAddress(String name,String sdt,String description) {
		if(name.isEmpty() || sdt.isEmpty() || description.isEmpty() ) {
			return false;
		}else {
			if(name.length() < 2  || name.length() > 40 ) {
				return false;
			}
			if( sdt.length() < 8 ||  sdt.length()  > 12 ) {
				return false;
			}
			if(description.length() < 2 || description.length()  > 50 ) {
				return false;
			}
		}
		return true;
	}
	
	 public static void main(String[] args) {
		 //[abc]	Find one character from the options between the brackets
		// [^abc]	Find one character NOT between the brackets
		// [0-9]	Find one character from the range 0 to 9
		 
		    Pattern pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
		    Matcher matcher = pattern.matcher("Visit W3Schools!");
		    boolean matchFound = matcher.find();
		    if(matchFound) {
		      System.out.println("Match found");
		    } else {
		      System.out.println("Match not found");
		    }
		  }
	public static String getDisplayStatus(int status) {
		
		switch (status) {
		case 3:
			return "Đang Xử Lý";
			
		case 2:
			return "Thành Công";
			
		case 1:
			return "Hủy Đơn Hàng";
			
		default:
			return "";
		}

	}

}
