package com.kuranado.blog.repository;

import com.kuranado.blog.domain.User;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Author: <a href='http://www.kuranado.com'>KURANADO</a>
 * @Date: 2018/6/30 20:26
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
