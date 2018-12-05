package cn.itcast.shop.untils;

import java.util.UUID;

public class UUIDUtils {

	/**
	 * 获取随机生成的字符串
	 */
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
