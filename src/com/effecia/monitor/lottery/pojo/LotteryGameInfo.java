package com.effecia.monitor.lottery.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.effecia.lottery.enums.GameStatus;
import com.effecia.lottery.enums.LotteryType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LotteryGameInfo implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LotteryType gameType;
	private String gameNo;
	private GameStatus gameStatus;
	private int gameTime;
	private int closeTime;
}
