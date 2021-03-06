package com.yfwl.everydayRecord.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yfwl.everydayRecord.dao.FuturesSharesMapper;
import com.yfwl.everydayRecord.model.FuturesShares;
import com.yfwl.everydayRecord.service.FuturesSharesService;



@Service
public class FuturesSharesServiceImpl implements FuturesSharesService {
	@Autowired
	FuturesSharesMapper futuresSharesMapper;

	@Override
	public Integer insertFuturesShares(FuturesShares futuresShares) {
		// TODO Auto-generated method stub
		return futuresSharesMapper.insertFuturesShares(futuresShares);
	}
	/**
	 * 获取云南白药的最后一条数据
	 */
	@Override
	public FuturesShares getLastSameName() {
		// TODO Auto-generated method stub
		return futuresSharesMapper.getLastSameName();
	}
	/**
	 * 获取国金证券的最后一条数据
	 */
	@Override
	public FuturesShares getLastSameName2() {
		// TODO Auto-generated method stub
		return futuresSharesMapper.getLastSameName2();
	}
	@Override
	public List<FuturesShares> getAllShares() {
		// TODO Auto-generated method stub
		return futuresSharesMapper.getAllShares();
	}
	@Override
	public List<FuturesShares> getAllFutures() {
		// TODO Auto-generated method stub
		return futuresSharesMapper.getAllFutures();
	}
	@Override
	public List<FuturesShares> getSharesByPage(Integer pageCount, Integer count) {
		// TODO Auto-generated method stub
		return futuresSharesMapper.getSharesByPage(pageCount, count);
	}
	@Override
	public List<FuturesShares> getSharesOnlyPage(Integer pageCount) {
		// TODO Auto-generated method stub
		return futuresSharesMapper.getSharesOnlyPage(pageCount);
	}
	@Override
	public List<FuturesShares> getSharesByPageOnfu(Integer pageCount,
			Integer count) {
		// TODO Auto-generated method stub
		return futuresSharesMapper.getSharesByPageOnfu(pageCount, count);
	}
	@Override
	public List<FuturesShares> getSharesOnlyPageOnfu(Integer pageCount) {
		// TODO Auto-generated method stub
		return futuresSharesMapper.getSharesOnlyPageOnfu(pageCount);
	}


}
