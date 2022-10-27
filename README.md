# 測試站: 时时彩GameServer
 * IGYFTest-SSCGS

# 注意
## com.effecia.lottery.quartzjob.GameCountdownJob#124
* not ready!

## 系統設置
* dealSystemConfig 
## com.effecia.lottery.InitService


## 重要TAG
```
[GAME_RESULT_COMING] 
[REDIS_PUBLISH]
[REDIS_PUBLISH_LOG]
[TO_WEB:{}]
[GAME_INFO:{}]
[COUNTDOWN_COMING:{}]
[START_GAME:{}]
WIN_LOSS_THREAD_START:{}
CALCULATE_WIN_LOSS:{}
[GAME_COUNT_DOWN_JOB:{}]
START_GAME:{}
```

# odd 2 web, 調查odds有沒有送給lottery web
```shell
grep send_ODDS_2_Web lotteryserver.log 
```
# 更新部分分公司赔率和游戏状态
## LOTTERY_PARTNER_ALL_CONFIG

# 注單處理
* WebRequestServer 內的BET事件