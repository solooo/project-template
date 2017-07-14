package net.solooo.template.service;

import net.solooo.template.entity.SysUser;
import net.solooo.template.entity.SysUserExample;
import net.solooo.template.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Author:Eric
 * Date:2017/7/13
 */
@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public SysUser findByName(String name) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andNameEqualTo(name);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
        if (sysUsers != null && sysUsers.size() == 1) {
            return sysUsers.get(0);
        }
        return null;
    }
}
