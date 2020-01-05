package com.tensquare.qa.client.impl;

import com.tensquare.qa.client.BaseClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Component;

/**
 * BaseClientImpl
 *
 * @author Paulson
 * @date 2020/1/5 14:12
 */

@Component
public class BaseClientImpl implements BaseClient {

    @Override
    public Result findById(String id) {
        return new Result(false, StatusCode.ERROR, "熔断器触发");
    }
}
