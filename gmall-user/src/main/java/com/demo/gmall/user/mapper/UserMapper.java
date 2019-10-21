package com.demo.gmall.user.mapper;

import com.demo.gmall.user.bean.UmsMember;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<UmsMember> selectAll();
}
