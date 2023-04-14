package com.example.data.controller;

import com.example.data.entity.User;
import com.example.data.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


/**
 * (User)控制层
 *
 * @author makejava
 * @since 2023-04-14 13:43:37
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;

    
    /**
     * 新增或者修改数据
     *
     * @param user 实体类
     * @return 
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public boolean saveData(@RequestBody User user){
        boolean result= userService.saveOrUpdate(user);
        return result;
    }


    /**
     * 删除一条数据
     *
     * @param id 参数对象
     * @return 布尔值
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public boolean deleteById(int id) {
        boolean result = userService.removeById(id);
        return result;
    }

    /**
     * 查询全部
     *
     * @return Response对象
     */
    @RequestMapping(value = "selectAll", method = RequestMethod.GET)
    public List<User> selectAll() {
        List<User> user = userService.list();
        if (user != null) {
            return user;
        }else{
            return user;
        }
    }

    /**
     * 分页查询
     * @param pageNum 起始页码
     * @param pageSize 每页的条数
     * @return
     */
    @RequestMapping(value = "selectPage", method = RequestMethod.GET)
    public IPage<User> selectPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize
                                       ){
        IPage<User> page=new Page<>(pageNum,pageSize);
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        IPage<User> userPage = userService.page(page, queryWrapper);
        return userPage;
    }
    
    /**
     * 批量删除
     * @param ids 要删除数据的集合
     * @return
     */
    @RequestMapping(value = "del/batch", method = RequestMethod.DELETE)
    public boolean deleteBatch(@RequestBody List<Integer> ids){
        return userService.removeByIds(ids);
    }
}

