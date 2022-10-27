package com.effecia.monitor.lottery.api;

import java.util.List;

import com.effecia.monitor.lottery.pojo.LotteryBetRecord;

public interface LotteryBetApi_ig2 {

	List<LotteryBetRecord> getLotteryBetRecord(String gameNo);
}
