package com.effecia.monitor.lottery.api.imp;

import java.util.ArrayList;
import java.util.List;



import com.effecia.monitor.lottery.api.LotteryBetApi_ig3;
import com.effecia.monitor.lottery.pojo.LotteryBetRecord;

//@Service(timeout=5000,retries=2)
public class LotteryBetApiImp  implements LotteryBetApi_ig3 {

	@Override
	public List<LotteryBetRecord> getLotteryBetRecord(String gameNo) {

		List<LotteryBetRecord> betRecordLists=new ArrayList<>();

		return betRecordLists;
	}

}
