package com.lxyker.mp001;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxyker.mp001.entity.User;
import com.lxyker.mp001.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@SpringBootTest
class Mp001ApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setAge(222);
        user.setName("段誉");
        user.setEmail("duanyu@163.cn");
        int insert = userMapper.insert(user);
        System.out.println("变动行数：" + insert);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(2L);
        user.setAge(123);
        int row = userMapper.updateById(user);
        System.out.println(row);
    }

    @Test
    public void testOptimisticLocker() {
//        乐观锁的测试需要先查询再修改
        User user = userMapper.selectById(1394925886553235458L);
        user.setAge(18);
        userMapper.updateById(user);
    }

    //    根据多个id，批量查询
    @Test
    public void testSelectByIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(users);
    }

    @Test
    public void testPage() {
//        1、创建page对象
        Page<User> page = new Page<>(1, 3);

//        2、调用分页查询方法
//        调用此方法后，会将分页的所有数据封装到 page 对象中
        userMapper.selectPage(page, null);

        System.out.println("当前页码为：" + page.getCurrent());
        System.out.println("每页数据list集合：" + page.getRecords());
        System.out.println("每页多少条数据？：" + page.getSize());
        System.out.println("一共多少条记录？：" + page.getTotal());
        System.out.println("一共分成了多少页？：" + page.getPages());

        System.out.println("是否有下一页？：" + page.hasNext());
        System.out.println("是否有前一页？：" + page.hasPrevious());
    }

    @Test
    public void testLogicDel() {
        int row = userMapper.deleteById(1);
        System.out.println("已删除，影响行数：" + row);
    }

    /**
     * mp实现复杂的查询操作
     * ge、gt、le、lt      >=、>、<=、<
     * eq、ne    =、!=
     * between、like
     */
    @Test
    public void testQueryWrapper() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();

//        查询 年纪>=20
        wrapper.ge("age", 20);
//        name = 小明
        wrapper.eq("name", "小明");
//        age 在 2~20
        wrapper.between("age", 2, 20);
//        name 包含 “小”
        wrapper.like("name", "小");

//        拼接一个sql语句
        wrapper.last("limit 1");

//        只查询 id 和 age 列
        wrapper.select("id", "age");

        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
