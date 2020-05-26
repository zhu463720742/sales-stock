package com.lichao.salesstock.system.service;

import com.lichao.salesstock.system.dto.LoginUser;
import com.lichao.salesstock.system.dto.Token;

public interface TokenService {

    Token saveToken(LoginUser loginUser);

    void refresh(LoginUser loginUser);

    LoginUser getLoginUser(String token);

    boolean deleteToken(String token);

}
