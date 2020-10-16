package com.mango.dao;

import com.mango.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SysUserMapperTest {

    @Autowired
    SysUserMapper sysUserMapper;

    @Test
    public void findPage() {
       List<SysUser> list = sysUserMapper.findPage();
       System.out.println(list.toString());
    }
}