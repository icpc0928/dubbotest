package com.effecia.monitor.lottery.api;

import com.effecia.lottery.enums.LotteryType;
import com.effecia.monitor.lottery.pojo.LotteryGameInfo;

public interface LotteryGameApi {
	
	
	LotteryGameInfo getGameInfo(LotteryType gameType);
}
