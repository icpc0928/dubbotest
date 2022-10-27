package com.effecia.monitor.lottery.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LotteryBetRecord implements Serializable{
	private static final long serialVersionUID = 1L;
	private Date betTime;
	private String betId;
	private String orderId;
	private String betOn;
	private String betType;
	private BigDecimal betAmount;
	private BigDecimal odd;
	private String lotteryType;
	private String gameNo;
	private BigDecimal winloss;
	private BigDecimal commision;
	private String status;//注单状态
	private String betDetails;
}
