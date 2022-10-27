--- 获取key
local keyAr = KEYS[1]
local keyAt = KEYS[2]
local keyBr = KEYS[3]
local keyBt = KEYS[4]
local keyCr = KEYS[5]
local keyCt = KEYS[6]

--- 如果redis找不到这个key就去插入
if redis.call("hlen", keyAr) >0  then
    local ids=redis.call('hkeys' ,keyAr)
    for k,v in ipairs(ids) do
        redis.call('hset' ,keyAt ,v, redis.call('hget' ,keyAr,v ))
        redis.call('hset' ,keyBt ,v, redis.call('hget' ,keyBr,v ))
        redis.call('hset' ,keyCt ,v, redis.call('hget' ,keyCr,v ))
     ---redis.call('SET', string.gsub(v, 'i', 'c', 1), redis.call('GET', v))
    end

    ---redis.call('hmset' ,keyAt , redis.call('hgetall' ,keyAr ))
    ---redis.call('hmset' ,keyBt , redis.call('hgetall' , keyBr ))
    ---redis.call('hmset' ,keyCt , redis.call('hgetall' ,keyCr ))
    return true

else
   return false
end
