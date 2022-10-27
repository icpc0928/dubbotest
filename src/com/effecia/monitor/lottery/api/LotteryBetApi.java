package com.effecia.monitor.lottery.api;

import java.util.List;

import com.effecia.lottery.enums.LotteryType;
import com.effecia.monitor.lottery.pojo.LotteryBetRecord;

public interface LotteryBetApi {

	List<LotteryBetRecord> getLotteryBetRecord(LotteryType gameType,String gameNo);
}
