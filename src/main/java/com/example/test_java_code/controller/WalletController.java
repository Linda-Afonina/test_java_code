package com.example.test_java_code.controller;

import com.example.test_java_code.dto.WalletDto;
import com.example.test_java_code.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("wallet")
    public ResponseEntity<String> updateBalance(@RequestBody WalletDto walletDto) {
        try {
            walletService.changeBalance(walletDto.getId(), walletDto.getOperationType(), walletDto.getAmount());
            return ResponseEntity.ok("Balance has been changed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("wallets/{walletId}")
    public ResponseEntity<Double> getBalance(@PathVariable UUID walletId) {
        try {
            return ResponseEntity.ok(walletService.getBalance(walletId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
