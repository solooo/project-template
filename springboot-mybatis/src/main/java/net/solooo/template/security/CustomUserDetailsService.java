package net.solooo.template.security;

import net.solooo.template.base.exception.WebException;
import net.solooo.template.entity.SysUser;
import net.solooo.template.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Author:Eric
 * Date:2017/7/13
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser user = sysUserService.findByName(userName);
        if (user == null) {
            throw new WebException("用户不存在");
        }
        SecurityUser securityUser = new SecurityUser(user);
        return securityUser;
    }

}
