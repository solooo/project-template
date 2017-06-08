package net.solooo.template.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.solooo.template.base.exception.WebException;
import net.solooo.template.base.page.PageResult;
import net.solooo.template.entity.Hello;
import net.solooo.template.service.HelloService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 * Author:Eric
 * Date:17/3/31-031
 */
@RestController
@RequestMapping(value = "/hello", produces = {"application/json;charset=utf-8"})
public class HelloController {

    @Autowired
    private HelloService helloService;

    /**
     * 列表
     * @param name 名称
     * @return List
     */
    @ApiOperation(value = "获取列表", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Hello> hello(String name) {
        return helloService.findAll(name);
    }

    /**
     * 分页
     * @param name 名称
     * @param pageNum 页码
     * @param pageSize 数量
     * @return 分页
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResult<Hello> findPage(String name,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {

        return helloService.findPage(name, pageNum, pageSize);
    }

    /**
     * 新增
     * @param hello hello
     * @return Hello
     */
    @ApiOperation(value="新增", notes="新增数据")
    @ApiImplicitParam(name = "hello", value = "数据对象", required = true, dataType = "Hello")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Hello save(Hello hello) {
        if (StringUtils.isBlank(hello.getName())) {
            throw new WebException("name 不可为空");
        }
        return helloService.save(hello);
    }

    /**
     * 修改
     * @param hello Hello
     * @return boolean
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public boolean update(Hello hello) {
        helloService.update(hello);
        return true;
    }

    /**
     * 删除
     * @param id id
     * @return boolean
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable Integer id) {
        if (id == null) {
            throw new WebException("ID 不可为空");
        }
        helloService.delete(id);
        return true;
    }
}
