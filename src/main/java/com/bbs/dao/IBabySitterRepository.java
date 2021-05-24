package com.bbs.dao;

import org.springframework.data.repository.CrudRepository;

import com.bbs.entities.BabySitter;

public interface IBabySitterRepository extends CrudRepository<BabySitter, Long>{

}
