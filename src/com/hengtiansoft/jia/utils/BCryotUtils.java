package com.hengtiansoft.jia.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;

/*
 * md5加密
 * */

public class BCryotUtils {
	/*static的用法*/
	public static final String ADDRESs="1";
	/*
	 * 把普通密码转化为加密密码
	 * */
	public static String getHashedPasswd(String oriPass) {
		if (StringUtils.isNotBlank(oriPass)) {
			return BCrypt.hashpw(oriPass, BCrypt.gensalt());
		}
		return "";
	}
/*
 * 判断密码是否一致，其中一个是普通密码，另外一个是从数据库中提取的已加密密码
 * */
	public static boolean checkPwd(String oriPass, String hashedPass) {
		if (StringUtils.isNotBlank(oriPass)) {
			return BCrypt.checkpw(oriPass, hashedPass);
		}
		return false;
	}
/*
 * 测试是否成功
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pass = "123456";
		String passHash = getHashedPasswd(pass);
		System.out.println(passHash);

		System.out.println(checkPwd(pass, passHash));
	}

}
