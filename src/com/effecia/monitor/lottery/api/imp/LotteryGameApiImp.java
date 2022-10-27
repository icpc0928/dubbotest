package com.effecia.monitor.lottery.api.imp;

import com.effecia.lottery.GameBuffer;
import com.effecia.lottery.LotteryLogger;
import com.effecia.lottery.enums.GameStatus;
import com.effecia.lottery.enums.LotteryType;
import com.effecia.lottery.po.GameInfo;
import com.effecia.monitor.lottery.api.LotteryGameApi_ig2;
import com.effecia.monitor.lottery.pojo.LotteryGameInfo;
//@Service(timeout=5000,retries=2)
public class LotteryGameApiImp extends LotteryLogger implements LotteryGameApi_ig2{
	@Override
	public LotteryGameInfo getGameInfo(LotteryType gameType) {
//		logger.info("LotteryGameApiImp is invoked, gameType:{}",gameType);
		try {
			GameInfo game=GameBuffer.getGameInfos().get(gameType).get(GameBuffer.getSiteCodes().get(0));
			return new LotteryGameInfo(gameType, game.getGameNo(), game.getGameStatus(),game.getGameTime(),game.getCloseTime());
		}catch (NullPointerException e) {
			return new LotteryGameInfo(gameType,"0", GameStatus.UNKONW,0,0);
		}
		
	}

}
