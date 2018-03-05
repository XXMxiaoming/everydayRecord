package com.yfwl.everydayRecord.service;

import java.util.List;

import com.yfwl.everydayRecord.model.FuturesTraderec;



public interface FuturesTraderecService {
	public Integer insertFuturesTraderec(FuturesTraderec futuresTraderec);

	public List<FuturesTraderec> getAllFutures();

	public List<FuturesTraderec> getAllShares();
	
	public List<FuturesTraderec> getAllFutures2(Integer pageCount);
	public List<FuturesTraderec> getAllFutures3(Integer pageCount,Integer count);
	
	public List<FuturesTraderec> getAllShares2(Integer pageCount);
	public List<FuturesTraderec> getAllShares3(Integer pageCount,Integer count);
	public Integer insertFuturesTraderec2(FuturesTraderec futuresTraderec);
}
