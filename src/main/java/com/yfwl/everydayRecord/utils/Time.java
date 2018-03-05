package com.yfwl.everydayRecord.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {
	private static SimpleDateFormat sdf=null;
	//当前时间转换为时间戳
	public static int nowTime(){
		Date datenow = new Date();
		long times=datenow.getTime();
		int time = Integer.parseInt(String.valueOf(times).substring(0, 10));
		return time;
	}
	
	//时间戳转换为日期
	public static String timeToDate(int time){
		Long times=Long.valueOf(time+"000");
		sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=sdf.format(times);
		return date;
	}
	
	/**
	 * 给一个日期返回星期几
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public  static int timeToDate2(String time) throws ParseException{
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	  Calendar c = Calendar.getInstance();
	  c.setTime(format.parse(time));
	  int dayForWeek = 0;
	  if(c.get(Calendar.DAY_OF_WEEK) == 1){
	   dayForWeek = 7;
	  }else{
	   dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
	  }
	  return dayForWeek;
	}
	
	
	public  static int timeToDate3(String a,String b) throws ParseException{
	SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
	Long c = sf.parse(b).getTime()-sf.parse(a).getTime();
	int d = (int) (c/1000/60/60/24);//天
	return d;
	}
	
	
	public static String dateToStamp(String s) throws ParseException{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
	
	/**
	 * 订单查询专用  返回如：10/01/2018
	 * @param s
	 * @return
	 */
	 public static String stampToDate(String s){
		 	s=s+"000";
	        String res;
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        long lt = new Long(s);
	        Date date = new Date(lt);
	        res = simpleDateFormat.format(date);
	        String[] s1 =res.split(" ");
	    	String[] s2 = s1[0].split("/");
	    	String time;
	    	time = s2[0]+","+s2[1]+","+s2[2];
	    	//time =s2[2]+"/"+s2[1]+"/"+s2[0];
	        return time;
	    }
	 
	 
	 //时间戳转换为日期2
	 public static String timeToDate2(int time){
			Long times=Long.valueOf(time+"000");
			sdf=new SimpleDateFormat("yyyy,MM,dd");
			String date=sdf.format(times);
			return date;
		}
}
