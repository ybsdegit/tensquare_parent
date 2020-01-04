package com.tensquare.qa.client;

import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * BaseClient
 *
 * @author Paulson
 * @date 2020/1/4 18:30
 */

@FeignClient("tensquare‐base ")
public interface BaseClient {

    @GetMapping("/label/{labelId}")
    public Result findById(@PathVariable("labelId") String id);

}
