package com.kuranado.blog.repository;

import com.kuranado.blog.domain.User;

import java.util.List;

/**
 * @Author: <a href='http://www.kuranado.com'>KURANADO</a>
 * @Date: 2018/6/30 20:26
 */
public interface UserRepository {

    /**
     * 新增或跟更新用户
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 根据 id 删除用户
     * @param id
     */
    void deleteUser(Long id);

    /**
     * 根据 id 获取用户
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 获取所有用户列表
     * @return
     */
    List<User> listUser();



}
