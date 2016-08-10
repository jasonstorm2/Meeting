package utils;

public class util {
	
	/**
	 * 使字符串没有空格
	 * @param str
	 * @return
	 */
	public static String getString(String str){
		String s = null;
		s = str.trim();
		s.replace(" ", "");
		return s;		
	}

}
