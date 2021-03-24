package com.boot.dao;

import com.boot.model.Type;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zhengxin
 * @date 2021/3/11
 */
public interface TypeDao extends JpaRepository<Type, Integer> , JpaSpecificationExecutor<Type> {

}
