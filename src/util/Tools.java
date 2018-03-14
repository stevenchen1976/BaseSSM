package util;

import java.awt.Color;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;




public class Tools {
	
	
	
	public static void main(String argc[]){
		testInt();
	}

	public static void testInt(){
		int a = 32768;//15
		int aa = a*a;//30
		out(aa, "30");
		out(aa-1+aa, "31-1");//31-1
		out(aa+aa-1, "31-1 flow 不影响");//31-1
		out(aa+aa, "31");//31
		out(-aa+1-aa, "-31+1");//-31+1
		out(-aa-aa, "-31");//-31
		out(-aa-aa-1, "-31-1");//-31
			
		out("-31", -2*aa, "31-1", aa*2-1);
		out(aa*4);//33
	}
	
 
	private static int toolong = 350; 
	public static String tooLongCut(String str) {
		if (str.length() > toolong)
			return   "len." + str.length() + " size." + Tools.calcSize(str.length()) + str.substring(0, toolong);
		return str;
	}
	//通过字符串长度，计算大概的 流量大小 MB KB B char=B 
	public static String calcSize(int filesize) {
		return calcSize(filesize);
	}

	public static String calcSize(long filesize) {
		return filesize > 1024 * 1024 * 1024 ? (float) (10 * filesize / (1024 * 1024 * 1024))
				/ 10 + "G" : (filesize > 1024 * 1024 ? filesize / 1024 / 1024 + "M"
						: filesize / 1024 + "K");
	}

	public static String calcTime(long filesize) {
		return filesize > 60 * 1000 ? (float) (10 * filesize / (60 * 1000))
				/ 10 + "M " + filesize % (60 * 1000) / 1000 + "S "
				: (filesize > 1000 ? filesize / 1000 + "S " + filesize
						% 1000 + "Ms " : filesize + "Ms ");
	}
	/**
	 * 把对象集合组装为字符串
	 * @param objs
	 * @return
	 */
	public static String getString(Object... objs) {
		if (objs == null)
			return "[null]";
		String res = "[";
		for (Object s : objs) {
			res += (s == null? "null":s.toString()) + ", ";
		}
		res = res.substring(0, res.length() - 2);
		res += "]";
		return res;
	}
	

	public static String cutString(String str, int i) {
		if(str != null && str.length() > i){
			str = str.substring(0, i);
		}
		return str;
	}
	/***
	 * 字符串为null -> "" 否则不变
	 * @param str
	 * @return
	 */
	public static String makeString(String str){
		return str == null? "" : str;
	}
	
	public static String getValueEncoded(String value)   {
	    if (value == null) return "null";
	    String newValue = value.replace("\n", "");
        try {
			return URLEncoder.encode(newValue, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "";

	}
 
	@SuppressWarnings("deprecation")
	public static void out(String str) {
		System.out.println(new java.util.Date().toLocaleString() + "." + str);
	}
	public static void out(Object...objects){
		out(objects2string(objects));
	} 
	public static String ints2string(int[] arr){
		String res = "[ ";
		for(int str: arr){
			res += str + ", ";
		}
		if(arr != null && arr.length > 0){
			res = res.substring(0, res.length() - 2);
		}
		res += " ]";
		return res;
	}
	public static String strings2string(String[] strs){
		String res = "[ ";
		for(String str: strs){
			res += str + ", ";
		}
		if(strs != null && strs.length > 0){
			res = res.substring(0, res.length() - 2);
		}
		res += " ]";

		return res;
	}
	public static String objects2string(Object...objects) {
		String[] res = objects2strings(objects);
		return strings2string(res);
	}
	public static String[] objects2strings(Object...objects) {
		if(objects == null)return null;
		String[] objs = new  String[objects.length] ;
		for(int i = 0; i < objects.length; i++){
			if(objects[i] != null)
				objs[i] = objects[i].toString();
			else
				objs[i] = "null!";
		}
		return objs;
	}
	 
	public static java.util.Date getDate(String s) {
		try {
			java.util.Date d = new SimpleDateFormat("yyyy-MM-dd") .parse(s);
			return new java.util.Date(d.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	} 
	public static java.sql.Timestamp getDate2(String s) {
		try {
			java.util.Date d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") .parse(s);
			return new java.sql.Timestamp(d.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	} 
	 
	  
 
  /**
   * 都不为null 且不为” “
   * @param objects
   * @return 不为null且不为"" 返回true,都为有效字符串
   */
	public static boolean isNull(Object...objects) {
		for(int i = 0; i < objects.length; i++){
			if(objects[i] == null){
				return false;
			}
			if(objects[i].toString().equals("")){
				return false;
			}
		}
		return true;
	}
 

	
	/**
	 * 空行 x i
	 * @param i
	 * @return
	 */
	public static String getLines(int i) {
		String res = "";
		for(int j = 0; j < i; j++){
			res += "-\n";
		}
		return res;
	}
	/**
	 * 空格 x i
	 * @param i
	 * @return
	 */
	public static String getSpace(int i) {
		String res = ""; 
		for(int j = 0; j < i; j++){
			res += " ";
		}  
		return res;
	}
	/**
	 * str x i
	 * @param i str
	 * @return
	 */
	public static String getFill(int i, String str) {
		String res = ""; 
		for(int j = 0; j < i; j++){
			res += str;
		}  
		return res;
	}
	
	
	 
	
	
	
	
	/**
	 * priorOrNext 0标识 在后面填充
	 * 
	 */
	public static String fillStringBy(String str, String by, int tolen, int priorOrNext){
		if(str.length() > tolen){
			str = str.substring(0, tolen);
		}else{
			int fromlen = str.length();
			for(int i = 0; i < (tolen - fromlen)/by.length(); i++){
				if(priorOrNext == 0){
					str = str + by;
				}else{
					str = by + str;
				}
			}
		}
		return str;
	}
	
	public static int getARandomProfileId() {
		return (int) (Math.random() * 23);
	}

	public static int getARandomRoomProfileId() {
		return (int) (Math.random() * 10);
	}

 	

	public static String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(new Date());
	}
 
	
	/**
	 * 获取随机数，从到，补齐位数
	 * @param fromNum
	 * @param toNum
	 * @param num
	 * @return
	 */
	public static String getRandomNum(int fromNum, int toNum, int num){
		int ii = (int) (Math.random() * (toNum-fromNum) + fromNum);
		String res = "" + ii;
		for(int i = res.length(); i < num; i++){
			res = "0" + res;
		}
		return res;
	}

	public static int getCount(String[] array, String str){
		if(array == null) return -1;
		if(str == null) return -1;
		for(int i = 0; i < array.length; i++){
			if(array[i].equals(str)){
				return i;
			}
		}
		return -1;
	}
	public static long parseLong(String num) {
		long res = 0;
		 if(num == null){
			 res = 0;
		 }else{
			 try{
				 res = Long.parseLong(num);
			 }catch(Exception e){
				 Tools.out("解析:" + num + "数字失败");
				 res = 0;
			 }
		 }
		return res;
	}
	public static double parseDouble(String num) {
		double res = 0;
		 if(num == null){
			 res = 0;
		 }else{
			 try{
				 res = Double.parseDouble(num);
			 }catch(Exception e){
				 Tools.out("解析:" + num + "数字失败");
				 res = 0;
			 }
		 }
		return res;
	}
	public static int parseInt(String num) {
		int res = 0;
		 if(num == null){
			 res = 0;
		 }else{
			 try{
				 res = Integer.parseInt(num);
			 }catch(Exception e){
				 Tools.out("解析:" + num + "数字失败");
				 res = 0;
			 }
		 }
		return res;
	}
 
	public static String getTimeSequence(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String res = sdf.format(new Date());
		return res;
	}
	public static String getNowTimeS( ) {
		return dateFormatS(new Date());
	}
	public static String getNowTime( ) {
		return dateFormat(new Date());
	}
	/**
	 * 获取当前时间
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getNowTimeL( ) {
		return dateFormatL(new Date());
	} 
	/**
	 * 获取当前时间
	 * @return HH:mm:ss
	 */
	public static String dateFormatS(java.util.Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String res = sdf.format(d);
		return res;
	}
	/**
	 * 获取当前时间
	 * @return yyyy-MM-dd 
	 */
	public static String dateFormat(java.util.Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String res = sdf.format(d);
		return res;
	}
	public static String dateFormatL(java.util.Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String res = sdf.format(d);
		return res;
	}
	public static Date dateFormat(String time, String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date res = new Date();
		try {
			res = sdf.parse(time);
		} catch (ParseException e) {
			//e.printStackTrace();
		}
		return res;
	}
	public static long getCurrentTime(){
		return System.currentTimeMillis();
	}
	/**
	 * 将int数值转换为占四个字节的byte数组，本方法适用于(高位在前，低位在后)的顺序。 和bytesToInt2（）配套使用
	 */
	public static byte[] int2bytes(int value) {
		byte[] b = new byte[4];
		for (int i = 0; i < 4; i++) {
			b[i] = (byte) (value >> (24 - i * 8));
		}
		return b;
	}

	public static int bytes2int(byte[] b) {
		return (((int) b[0] << 24) + (((int) b[1]) << 16) + (((int) b[2]) << 8) + b[3]);
	}
	public static String color2string(int r, int g, int b){
		String res = Tools.fillStringBy(Integer.toHexString(r)+"", "0", 2, 0) 
		+Tools.fillStringBy(Integer.toHexString(g)+"", "0", 2, 0) 
		+Tools.fillStringBy(Integer.toHexString(b)+"", "0", 2, 0) ;
		return res;
	}
	public static String color2string(Color c){
		return color2string(c.getRed(),c.getGreen(),c.getBlue());
	}

 
	public static String getServerIp(String localIp) {
		String ip = localIp;
		if (ip != null) {
			if (ip.length() >= 7) {// 231.132.131.n?,wifi主机往往那个是尾数为1
				String ss[] = ip.split("\\."); // 特殊字符分割转义##########################
				if (ss.length >= 4) {
					ip = ss[0] + "." + ss[1] + "." + ss[2] + ".1"; // 因为主机往往是 尾号  寻找当前ip的主机
				}
			}
		}
		return ip;
	}

 
	 
	 

/**
 * 获取指定格式的时间 yyyy-MM-dd 
 */
	public static String getTime(String format) {
		   Date d = new Date();  
	        SimpleDateFormat sdf = new SimpleDateFormat(format);  
	       return sdf.format(d);  
	}
	
	public static String getTimeYYYYMMDD() {
		   Date d = new Date();  
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	       return sdf.format(d);  
	}

	
	
	/**
	 * 取得当月天数
	 * */
	public static int getDaysNow()
	{
		Calendar a = Calendar.getInstance();
		a.set(Calendar.DATE, 1);//把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	/**
	 * 得到指定月的天数
	 * */
	public static int getDays(String yyyymmdd) {
		int year = parseInt(yyyymmdd.substring(0, 4));
		int month = parseInt(yyyymmdd.substring(5, 7));
		
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);//把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}		
}
