package com.demo.gmall.user.mapper;

import com.demo.gmall.user.bean.UmsMember;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<UmsMember> {

}
