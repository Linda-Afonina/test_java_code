package com.example.test_java_code.service;

import com.example.test_java_code.model.Wallet;
import com.example.test_java_code.repository.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Transactional
    public void changeBalance(UUID walletId, String operationType, double amount) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));

        if (operationType.equals("DEPOSIT")) {
            wallet.setBalance(wallet.getBalance() + amount);
        } else if (operationType.equals("WITHDRAW")) {
            if (wallet.getBalance() < amount) {
                throw new RuntimeException("Not enough cash");
            }
            wallet.setBalance(wallet.getBalance() - amount);
        }

        walletRepository.save(wallet);
    }

    public double getBalance(UUID walletId) {
        return walletRepository.findById(walletId)
                .map(Wallet::getBalance)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
    }
}
