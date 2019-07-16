package com.xz.demo.config.general;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SequenceId {
    private Snowflake snowflake;
    /**
     *
     * 注：workerId必须在使用到的项目里配置，并且不能和其他项目一样，datacenterId同一个数据中心用一个就好
     */
    public SequenceId(@Value("${snowflake.workerId:0}")long workerId, @Value("${snowflake.datacenterId:0}")long datacenterId) {
        snowflake = IdUtil.createSnowflake(workerId, datacenterId);
    }

    public String nextId(){
        return String.valueOf(snowflake.nextId());
    }
}
