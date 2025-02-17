package com.bzip.project.mapper;

import com.bzip.project.domain.Pay;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayMapper {
    void insertPay(Pay pay);
}
