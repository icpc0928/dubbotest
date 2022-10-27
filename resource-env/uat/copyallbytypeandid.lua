--- 获取key
local keyAr = KEYS[1]
local keyAt = KEYS[2]
local keyBr = KEYS[3]
local keyBt = KEYS[4]
local keyCr = KEYS[5]
local keyCt = KEYS[6]
local id = ARGV[1]
--- 如果redis找不到这个key就去插入
if redis.call("HEXISTS", keyAr,id) >0  then
    
    redis.call('hset' ,keyAt ,id, redis.call('hget' ,keyAr,id ))
    redis.call('hset' ,keyBt ,id, redis.call('hget' ,keyBr,id ))
    redis.call('hset' ,keyCt ,id, redis.call('hget' ,keyCr,id ))
 
    return true

else
   return false
end
