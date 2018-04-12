package com.xuchen.service;

import com.xuchen.BootManage;
import com.xuchen.core.redis.RedisStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootManage.class)
public class RedisTest {


    @Test
    public void test() {
        Object value = RedisStore.getValue("hello");
        System.out.println(value);
//        RedisStore.setValue("manage","manage");
    }

}
