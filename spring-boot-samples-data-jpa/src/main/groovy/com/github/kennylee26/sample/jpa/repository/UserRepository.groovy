package com.github.kennylee26.sample.jpa.repository

import com.github.kennylee26.sample.jpa.entity.User
import org.springframework.data.repository.CrudRepository

/**
 * <p>Created on 13/1/15.</p>
 * @author kennylee
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
