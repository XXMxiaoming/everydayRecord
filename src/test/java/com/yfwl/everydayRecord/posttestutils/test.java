package com.yfwl.everydayRecord.posttestutils;

import java.util.HashMap;


import org.junit.Test;

public class test extends ControllerTest {

	//每天下午输入revenue
	@Test
	public void test151(){
		String url="https://www.fage18.com/YFfg/"+"incomeLoss/revenue.do";
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Ef", "-0.0056");//期货
		map.put("Ed", "0.00035");//债券(固定不用更改)
		map.put("Es", "-0.0036");//股票
		map.put("Ec", "0");//现金(固定不用更改)
		map.put("sharesmoney", "4003171.701");//每天的股票账户权益
		map.put("futuresmoney", "4108788.58");//每天的期货账户权益
		System.out.println(doPost(url, map));
	}
	
	
	
	//添加股票
	@Test
	public void test1(){
		String url = host+"record/insertFuturesShares.do";
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("money", "4003171.701");//每天的股票账户权益
		System.out.println(doPost(url, map));
	}
	//添加期货
	@Test
	public void test2(){
		String url = host+"record/insertFuturesShares2.do";
		HashMap<String, String> map = new HashMap<String, String>();
		System.out.println(doPost(url, map));
		System.out.println("fdvdfvdfvdf");

	}
	
	//添加股票交易记录
	@Test
	public void test3(){
		String url = host+"record/insertFuturesTraderec.do";
		HashMap<String, String> map = new HashMap<String, String>();
		//map.put("money", "4014721");
		System.out.println(doPost(url, map));
	}
	
	//添加期货交易记录
		@Test
		public void test4(){
			String url = host+"record/insertFuturesTraderec2.do";
			HashMap<String, String> map = new HashMap<String, String>();
			//map.put("money", "4014721");
			System.out.println(doPost(url, map));
		}
}
