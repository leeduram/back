package com.bzip.project.controller;

import com.bzip.project.dto.PayDTO;
import com.bzip.project.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {
    private PayService payService;

    @Autowired
    public PayController(PayService payService) {
        this.payService = payService;
    }

    @PostMapping("/api/payment")
    public String processPayment(@RequestBody PayDTO payDTO) {
        boolean success = payService.processPay(payDTO);
        if (success) {
            return "결제가 완료되었습니다.";
        } else {
            return "결제 실패";
        }
    }
}
