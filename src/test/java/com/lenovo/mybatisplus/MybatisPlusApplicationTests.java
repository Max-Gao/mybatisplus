package com.lenovo.mybatisplus;

import com.lenovo.mybatisplus.entity.User;
import com.lenovo.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Test
    void testSelectList(){
        List<User> users= userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    //    增加
    @Test
    void create(){
        User user = new User();
        user.setAge(10);
        user.setName("max");
        user.setEmail("4765747@qq.com");
        int result = userMapper.insert(user);
        System.out.println("影响的行数：" + result);
        System.out.println("id" + user.getId());
    }
    //查询
    @Test
    public void testSelect() {
        User user = userMapper.selectById(1);
        System.out.println(user);

        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);

        Map<String, Object> map = new HashMap<>();
        map.put("name", "Helen"); //注意此处是表中的列名，不是类中的属性名
        map.put("age", 18);
        List<User> users1 = userMapper.selectByMap(map);
        users1.forEach(System.out::println);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(5L);
        user.setAge(33);

        int result = userMapper.updateById(user);
        System.out.println("影响行数"+result);
    }

    //    删除
    @Test
    public void testDelete(){
        int result = userMapper.deleteById(3);
        System.out.println("影响行数"+result);
    }
}
