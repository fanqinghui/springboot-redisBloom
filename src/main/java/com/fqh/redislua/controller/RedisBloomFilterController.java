package com.fqh.redislua.controller;


import com.google.common.collect.Lists;
import com.fqh.redislua.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Description: redis布隆过滤器 相关接口
 * @author qinghui
 * @date 2020/8/28 下午2:47
 */
@Slf4j
@RestController
public class RedisBloomFilterController {

    @Autowired
    private RedisService redisService;

    public static final String FILTER_NAME = "isMember";

    /**
     * 保存 数据到redis布隆过滤器
     */
    @GetMapping("/save-redis-bloom")
    public Object saveReidsBloom() {
        //数据插入布隆过滤器
        List<String> exist = Lists.newArrayList("11111", "22222");
        Object object = redisService.addsLuaBloomFilter(FILTER_NAME, exist);
        log.info("保存是否成功====object:{}",object);
        return object;
    }

    /**
     * 查询 当前数据redis布隆过滤器是否存在
     */
    @GetMapping("/exists-redis-bloom")
    public void existsReidsBloom(String value) {
        //不存在输出
        if (!redisService.existsLuabloomFilter(FILTER_NAME, "00000")) {
            log.info("redis布隆过滤器不存在该数据=============数据{}",  "00000");
        }
        //存在输出
        if (redisService.existsLuabloomFilter(FILTER_NAME, "11111")) {
            log.info("redis布隆过滤器存在该数据=============数据{}", "11111");
        }
        //判断是否存在
        if (redisService.existsLuabloomFilter(FILTER_NAME, value)) {
            log.info("redis布隆过滤器存在该数据=============数据{}", value);
        }
    }
}
