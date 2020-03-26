package com.es;

import org.springframework.data.repository.CrudRepository;

/**
 * @description:
 * @author: fandp
 * @create: 2020-03-24 14:16
 **/
public interface UserReposiory  extends CrudRepository<UserEntity, String> {
}
