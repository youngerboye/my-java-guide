package com.young.demoshardingjdbc.config;

import cn.hutool.core.lang.Snowflake;
import io.shardingsphere.core.keygen.KeyGenerator;

/**
 * 自定义雪花算法
 */
public class CustomSnowConfig implements KeyGenerator {
    private Snowflake snowflake;

    public CustomSnowConfig(Snowflake snowflake) {
        this.snowflake = snowflake;
    }

    @Override
    public Number generateKey() {
        return snowflake.nextId();
    }
}
