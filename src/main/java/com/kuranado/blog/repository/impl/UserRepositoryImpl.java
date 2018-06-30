package com.kuranado.blog.repository.impl;

import com.kuranado.blog.domain.User;
import com.kuranado.blog.repository.UserRepository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: <a href='http://www.kuranado.com'>KURANADO</a>
 * @Date: 2018/6/30 20:34
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    private AtomicLong atomicLong = new AtomicLong();

    private Map<Long, User> userMap = new HashMap<>();

    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        // 如果是新增用户
        if (id == null) {
            id = atomicLong.getAndIncrement();
            user.setId(id);
        }
        userMap.put(id, user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        return userMap.get(id);
    }

    @Override
    public List<User> listUser() {
        return new ArrayList<>(userMap.values());
    }
}
