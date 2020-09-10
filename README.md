## <font color=#FFD700>SpringBoot整合Redis布隆过滤器</font>

#### 前提：redis使用布隆过滤器moudle
使用docker直接运行：
```shell scripth
docker run -p 6379:6379 --name redis-redisbloom redislabs/rebloom:latest
```


#### 一）对以下方法进行性能测试比较

​     1. List的 contains 方法

​     2. Map的 containsKey 方法

​     3. Google布隆过滤器 mightContain 方法

#### 过lua脚本实现布隆客户端布隆过滤

   - 实现通过Lua脚本批量插入数据到redis布隆过滤器 

   - 并判断当前key值在redis布隆过滤器中是否存在。