package com.tensquare_friend.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * UserClient
 *
 * @author Paulson
 * @date 2020/1/4 22:11
 */

@FeignClient("tensquare-user")
public interface UserClient {

    @PutMapping("/user/{userid}/{friendid}/{x}")
    public void updateFanscountAndFollowcount(@PathVariable("userid") String userid, @PathVariable("friendid") String friendid, @PathVariable("x") int x);
}
