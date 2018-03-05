package com.yfwl.everydayRecord.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yfwl.everydayRecord.model.FuturesShares;
import com.yfwl.everydayRecord.model.FuturesTraderec;
import com.yfwl.everydayRecord.service.FuturesSharesService;
import com.yfwl.everydayRecord.service.FuturesTraderecService;

@Controller
@RequestMapping("/record")
public class FuturesSharesController extends BaseController {
	@Autowired
	FuturesSharesService futuresSharesService;
	@Autowired
	FuturesTraderecService futuresTraderecService;
	/**
	 * 添加股票
	 * @param request
	 * @param response
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	@RequestMapping(value = "/insertFuturesShares", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> insertFuturesShares(HttpServletRequest request,
			HttpServletResponse response) throws NumberFormatException, IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		Double money = Double.parseDouble(request.getParameter("money"));
		System.out.println("fgsdjfk");
		try {
			InputStreamReader in = new InputStreamReader(new FileInputStream(new File("C:\\Users\\xxm\\Desktop\\发哥每日记录程序\\股票添加.txt")),"gb2312");
			BufferedReader bf = new BufferedReader(in);
			String lineTxt = null;
			String s[];
			while ((lineTxt = bf.readLine()) != null) {
				//以空格分隔
				s = lineTxt.split("\\s+");
				
				String number = s[0].startsWith("6") ? s[0] + ".SS" : s[0]
						+ ".SZ";
				String name = s[1];
				Double price = Double.parseDouble(s[2]);
				Double marketvalue = Double.parseDouble(s[3]);
				FuturesShares fu = new FuturesShares();
				fu.setName(name);
				fu.setNumber(number);
				fu.setPrice(price);
				fu.setPosiscale(marketvalue / money);
				fu.setMarketvalue(marketvalue);
				fu.setManyempty("0");
				fu.setDeposit(0.00);
				System.out.println(fu);
				futuresSharesService.insertFuturesShares(fu);
			}
			map = rspFormat("", SUCCESS);
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;

	}
	/**
	 * 添加期货
	 * @param request
	 * @param response
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	@RequestMapping(value = "/insertFuturesShares2", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> insertFuturesShares2(HttpServletRequest request,
			HttpServletResponse response) throws NumberFormatException, IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		//Double money = Double.parseDouble(request.getParameter("money"));
		System.out.println("fgsdjfk");
		try {
			InputStreamReader in = new InputStreamReader(new FileInputStream(new File("C:\\Users\\xxm\\Desktop\\发哥每日记录程序\\期货添加.txt")),"gb2312");
			BufferedReader bf = new BufferedReader(in);
			String lineTxt = null;
			String s[];
			while ((lineTxt = bf.readLine()) != null) {
				s = lineTxt.split("\\s+");
				
				String name = s[0];
				String number = s[1];
				Double posiscale =Double.parseDouble(s[2]);
				Double deposit = Double.parseDouble(s[3]);
				String action = s[4];
				String manyempty ="";
				if(action.equals("空")){
					manyempty="1";
				}else{
					manyempty="2";
				}
				//Double price = Double.parseDouble(s[2]);
				//Double marketvalue = Double.parseDouble(s[3]);
				FuturesShares fu = new FuturesShares();
				fu.setName(name);
				fu.setNumber(number);
				fu.setPrice(0.0);
				fu.setPosiscale(posiscale);
				fu.setMarketvalue(0.0);
				fu.setManyempty(manyempty);
				fu.setDeposit(deposit);
				//System.out.println(fu);
				futuresSharesService.insertFuturesShares(fu);
			}
			map = rspFormat("", SUCCESS);
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;

	}
	
	/**
	 * 添加股票交易记录
	 * @param request
	 * @param response
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	@RequestMapping(value = "/insertFuturesTraderec", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> insertFuturesTraderec(HttpServletRequest request,
			HttpServletResponse response) throws NumberFormatException, IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		//Double money = Double.parseDouble(request.getParameter("money"));
		
		try {
			InputStreamReader in = new InputStreamReader(new FileInputStream(new File("C:\\Users\\xxm\\Desktop\\发哥每日记录程序\\股票交易记录.txt")),"gb2312");
			BufferedReader bf = new BufferedReader(in);
			String lineTxt = null;
			String s[];
			while ((lineTxt = bf.readLine()) != null) {
				s = lineTxt.split("\\s+");
				
				String action  = s[0].trim();
				System.out.println(action+"fgsdjfgsh");
				Integer buyorsell =1;
				if(action.equals("卖")){
					buyorsell=3;
				}else{
					buyorsell=1;
				}
				String number = s[1].startsWith("6") ? s[1] + ".SS" : s[1]+ ".SZ";
				String name = s[2];
				System.out.println(s[4]);
				Double price =Double.parseDouble(s[4]);
				FuturesTraderec fu = new FuturesTraderec();
				fu.setBuysell(buyorsell);
				fu.setName(name);
				fu.setNumber(number);
				fu.setPrice(price);
				fu.setStatus("2");
				futuresTraderecService.insertFuturesTraderec(fu);

			}
			map = rspFormat("", SUCCESS);
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;

	}
	
	/**
	 * 添加期货交易记录
	 * @param request
	 * @param response
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/insertFuturesTraderec2", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> insertFuturesTraderec2(HttpServletRequest request,
			HttpServletResponse response) throws NumberFormatException, IOException, ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		//Double money = Double.parseDouble(request.getParameter("money"));
		
		try {
			InputStreamReader in = new InputStreamReader(new FileInputStream(new File("C:\\Users\\xxm\\Desktop\\发哥每日记录程序\\期货交易记录.txt")),"gb2312");
			BufferedReader bf = new BufferedReader(in);
			String lineTxt = null;
			String s[];
			while ((lineTxt = bf.readLine()) != null) {
				s = lineTxt.split("\\s+");
				String name = s[0];
				String number = s[1];
				System.out.println(s[0]+"gdsjflkjgjfdkl");
				System.out.println(s[1]+"gdsjflkjgjfdkl");
				String action  = s[2].trim();
				System.out.println(action+"dasgdh");
				Integer buyorsell =1;
				if(action.equals("卖")){
					buyorsell=3;
				}else{
					buyorsell=1;
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				
				Double price =Double.parseDouble(s[3]);
				String date = s[4];
				Date date2 = sdf.parse(date);
				FuturesTraderec fu = new FuturesTraderec();
				fu.setBuysell(buyorsell);
				fu.setName(name);
				fu.setNumber(number);
				fu.setPrice(price);
				fu.setStatus("1");
				fu.setTime(date2);
				futuresTraderecService.insertFuturesTraderec2(fu);

			}
			map = rspFormat("", SUCCESS);
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;

	}
	
}
