package com.fqh.redislua.service;

import java.util.List;

/**
 * @Description: redis布隆过滤器
 *
 * @author qinghui
 * @date 2020/8/25 下午5:27
 */
public interface RedisService {

    /**
     * 布隆过滤器 批量插入数据
     *
     * @param filterName 布隆过滤器名称
     * @param values 插入布隆过滤器的值
     */
    Object addsLuaBloomFilter(String filterName, List<String> values);

    /**
     *
     * @param filterName 布隆过滤器名称
     * @param value      查询该key是否存在
     * @return
     */
    Boolean existsLuabloomFilter(String filterName, String value);


}