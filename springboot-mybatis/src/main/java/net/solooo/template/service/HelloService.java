package net.solooo.template.service;

import com.github.pagehelper.PageHelper;
import net.solooo.template.base.page.PageResult;
import net.solooo.template.entity.Hello;
import net.solooo.template.entity.HelloExample;
import net.solooo.template.mapper.HelloMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Author:Eric
 * Date:17/3/31-031
 */
@Service
public class HelloService {

    @Autowired
    private HelloMapper helloMapper;


    /**
     * 查询所有
     * @param name 名称
     * @return List
     */
    public List<Hello> findAll(String name) {
        HelloExample example = new HelloExample();
        if (StringUtils.isNotBlank(name)) {
            example.createCriteria().andNameLike("%" + name + "%");
        }
        return helloMapper.selectByExample(example);
    }

    /**
     * 分页
     * @param name 名称
     * @param pageNum 页码
     * @param PageSize 记录数
     * @return PageInfo
     */
    public PageResult<Hello> findPage(String name, Integer pageNum, Integer PageSize) {
        HelloExample example = new HelloExample();
        if (StringUtils.isNotBlank(name)) {
            example.createCriteria().andNameLike("%" + name + "%");
        }
        PageHelper.startPage(pageNum, PageSize);
        List<Hello> hellos = helloMapper.selectByExample(example);
        return new PageResult<>(hellos);
    }

    /**
     * 保存
     * @param hello Hello
     * @return Hello
     */
    public Hello save(Hello hello) {
        helloMapper.insert(hello);
        return hello;
    }

    /**
     * 修改
     * @param hello Hello
     */
    public void update(Hello hello) {
        helloMapper.updateByPrimaryKeySelective(hello);
    }

    /**
     * 删除
     * @param id ID
     */
    public void delete(Integer id) {
        helloMapper.deleteByPrimaryKey(id);
    }
}
