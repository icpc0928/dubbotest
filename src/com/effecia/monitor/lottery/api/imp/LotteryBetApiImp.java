package com.effecia.monitor.lottery.api.imp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.effecia.lottery.GameBuffer;
import com.effecia.lottery.LotteryLogger;
import com.effecia.lottery.entity.BetOrder;
import com.effecia.lottery.entity.BetRecord;
import com.effecia.lottery.enums.LotteryType;
import com.effecia.monitor.lottery.api.LotteryBetApi_ig2;
import com.effecia.monitor.lottery.pojo.LotteryBetRecord;

//@Service(timeout=5000,retries=2)
public class LotteryBetApiImp extends LotteryLogger implements LotteryBetApi_ig2 {

	@Override
	public List<LotteryBetRecord> getLotteryBetRecord(LotteryType gameType, String gameNo) {
		logger.info("LotteryBetApiImp is invoked, gameType:{} gameNo:{}",gameType,gameNo);
		List<LotteryBetRecord> betRecordLists=new ArrayList<>();
		if(GameBuffer.getGameBets().containsKey(gameType)&&GameBuffer.getGameBets().get(gameType).containsKey(gameNo)) {
			for (Map.Entry<Integer, Map<String, BetOrder>> playerIdEntry : GameBuffer.getGameBets().get(gameType).get(gameNo).get(GameBuffer.getSiteCodes().get(0)).entrySet()) {
//				BigDecimal companyShare = GameBuffer.getPlayerIdMap().get(playerIdEntry.getKey()).getCompanyShare();
				BigDecimal companyShare = GameBuffer.getPlayerAndCompanySharing().get(playerIdEntry.getKey());
				if(companyShare==null) {
					companyShare=BigDecimal.ZERO;
					logger.info("companyShare is null {} ",playerIdEntry.getKey());
				}
				for(Map.Entry<String, BetOrder> betEntry : playerIdEntry.getValue().entrySet()) {
					BetOrder betOrder=betEntry.getValue();
					for(BetRecord betRecord:betOrder.getBetRecords()) {
						betRecordLists.add(new LotteryBetRecord(betOrder.getBetTime(), betRecord.getBetRecordId(), betOrder.getOrderId(), 
								betRecord.getBetOn(), betRecord.getBetType(), betRecord.getAmount().multiply(companyShare), betRecord.getOdd(), gameType.toString(), gameNo, betRecord.getWinloss(), 
								betRecord.getCommision(), betOrder.getStatus(), betRecord.getBetDetails()));	
					}
				}
			}
		}
		return betRecordLists;
	}

}
