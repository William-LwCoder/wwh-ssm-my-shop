package com.wwh.my.shop.web.admin.service.test;

import com.wwh.my.shop.domain.TbUser;
import com.wwh.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * <p>Title: TbUserServiceTest</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/4/24 17:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {

    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testSelectAll() {
        List<TbUser> tbUsers = tbUserService.selectAll();

        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }

    @Test
    public void testGetById() {
        System.out.println(tbUserService.getById(39L).getUsername());
    }

    @Test
    public void testSelectByUsername() {
        List<TbUser> tbUsers = tbUserService.selectByUsername("uni");

        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }

    @Test
    public void testInsert() {
        TbUser tbUser = new TbUser();
        tbUser.setUsername("William");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        tbUser.setEmail("William@wwh.com");
        tbUser.setPhone("15888888888");
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());

        tbUserService.insert(tbUser);
    }

    @Test
    public void testDelete() {
        TbUser tbUser = new TbUser();
        tbUser.setId(38L);

        tbUserService.delete(tbUser);
    }

    @Test
    public void testUpdate() {
        TbUser tbUser = tbUserService.getById(39L);

        tbUser.setUsername("William");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        tbUser.setEmail("William@wwh.com");
        tbUser.setPhone("15888888888");
        tbUser.setUpdated(new Date());

        tbUserService.update(tbUser);
    }

    @Test
    public void testMD5() {
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
    }
}
