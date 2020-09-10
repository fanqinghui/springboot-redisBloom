-- lua 判断 name 与value 是否存在，返回ture
local bloomName = KEYS[1]
local value = KEYS[2]
-- bloomFilter
local result_1 = redis.call('BF.EXISTS', bloomName, value)
return result_1