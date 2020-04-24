package com.wwh.my.shop.web.ui.api;

import com.wwh.my.shop.commons.utils.HttpClientUtils;
import com.wwh.my.shop.commons.utils.MapperUtils;
import com.wwh.my.shop.web.ui.dto.TbUser;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * 会员管理接口
 *
 * <p>Title: UsersApi</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2020/4/5 14:16
 */
public class UsersApi {

    /**
     * 登录
     *
     * @param tbUser
     * @return
     */
    public static TbUser login(TbUser tbUser) throws Exception {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", tbUser.getUsername()));
        params.add(new BasicNameValuePair("password", tbUser.getPassword()));

        String json = HttpClientUtils.doPost(API.API_USERS_LOGIN, params.toArray(new BasicNameValuePair[params.size()]));
        TbUser user = MapperUtils.json2pojoByTree(json, "data", TbUser.class);
        return user;
    }
}
