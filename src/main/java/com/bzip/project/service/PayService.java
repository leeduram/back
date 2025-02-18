package com.bzip.project.service;

import com.bzip.project.domain.Pay;
import com.bzip.project.domain.User;
import com.bzip.project.dto.PayDTO;
import com.bzip.project.mapper.PayMapper;
import com.bzip.project.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayService {
    private PayMapper payMapper;
    private UserMapper userMapper;

    @Autowired
    public PayService(PayMapper payMapper, UserMapper userMapper) {
        this.payMapper = payMapper;
        this.userMapper = userMapper;
    }

    public boolean processPay(PayDTO payDTO) {

        // 결제 내역 생성
        Pay pay = new Pay();
        pay.setUserUid(payDTO.getUserUid());
        pay.setAmount(payDTO.getAmount());
        pay.setMethod(payDTO.getMethod());
        pay.setPayDate(new java.sql.Timestamp(System.currentTimeMillis()));

        // 결제 내역 삽입
        payMapper.insertPay(pay);

        // 다운로드 권한 부여
        User user = userMapper.selectUserByUid(payDTO.getUserUid());
        user.setDownloadPermission(true);
        userMapper.updateUser(user);

        return true;
    }
}
