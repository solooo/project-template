package net.solooo.template.security;

import net.solooo.template.entity.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 * Author:Eric
 * Date:2017/7/13
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
        SysUser sysUser = (SysUser) authentication.getPrincipal();
        System.out.println(sysUser.getName() + " 登录");

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
