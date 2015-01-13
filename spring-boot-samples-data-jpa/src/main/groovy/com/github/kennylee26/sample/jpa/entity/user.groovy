package com.github.kennylee26.sample.jpa.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * <p>Created on 13/1/15.</p>
 * @author kennylee
 */
@Entity
class User {
    @Id
    @GeneratedValue
    Long id
    String name
    String mail
    String mobile
    Date createDate
}
