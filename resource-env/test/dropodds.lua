--- 获取key
local keya = "c-A-" .. KEYS[1]
local keyb = "c-B-" .. KEYS[1]
local keyc = "c-C-" .. KEYS[1]
local keydrop = "drop-" .. KEYS[1]
local id = KEYS[2]
local gtype = KEYS[1]
id=string.gsub(id,gtype,"",1);
local valuesdr=redis.call('hget' ,keydrop ,id)
local dropoddsmap = cjson.decode(valuesdr)

local valuesa=redis.call('hget' ,keya ,id)
local valuesb=redis.call('hget' ,keyb ,id)
local valuesc=redis.call('hget' ,keyc ,id)

local ctablea=cjson.decode(valuesa)
local ctableb=cjson.decode(valuesb)
local ctablec=cjson.decode(valuesc)
--- 分别降陪
for k,v in pairs(dropoddsmap) do
    for ka,v2 in pairs(v) do
    	ctablea[k][ka] = ctablea[k][ka]-v2
    	if (ctablea[k][ka] < 1) then
    		ctablea[k][ka]=1
    	end
    	ctableb[k][ka] = ctableb[k][ka]-v2
        if (ctableb[k][ka] < 1) then
            ctableb[k][ka]=1
        end
        ctablec[k][ka] = ctablec[k][ka]-v2
        if (ctablec[k][ka] < 1) then
            ctablec[k][ka]=1
        end
    end
end
redis.call('hset' ,keya ,id,cjson.encode(ctablea))
redis.call('hset' ,keyb ,id,cjson.encode(ctableb))
redis.call('hset' ,keyc ,id,cjson.encode(ctablec))
redis.call('hdel',keydrop,id)

return true