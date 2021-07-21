package com.web.service.impl;

import com.web.entity.Route;
import com.web.mapper.RouteMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RouteServiceImplTest {
    @Resource
    private RouteMapper routeMapper;

    @Test
    public void test(){
        Route route = new Route();
        route.setPrice(999.0);
        route.setRouteIntroduce("jakshfjh");
        route.setRname("asf");
//        route.setRouteIntroduce("JEHAEFJKH");
        int insert = routeMapper.updateById(route);
        System.out.println(insert);
    }
}