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
    public void testSave() {
        // 插入
        TbUser tbUser = new TbUser();
        tbUser.setUsername("William");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        tbUser.setEmail("William@wwh.com");
        tbUser.setPhone("15888888888");
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());

        tbUserService.save(tbUser);

        // 更新
        TbUser tbUser1 = tbUserService.getById(39L);

        tbUser1.setUsername("William");
        tbUser1.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        tbUser1.setEmail("William@wwh.com");
        tbUser1.setPhone("15888888888");
        tbUser1.setUpdated(new Date());

        tbUserService.save(tbUser1);
    }

    @Test
    public void testDelete() {
        tbUserService.delete(38L);
    }

    @Test
    public void testMD5() {
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
    }
}
