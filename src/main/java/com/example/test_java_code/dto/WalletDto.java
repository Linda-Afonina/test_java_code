package com.example.test_java_code.dto;

import java.util.Objects;
import java.util.UUID;

public class WalletDto {

    private UUID Id;
    private String operationType;
    private double amount;

    public WalletDto() {
    }

    public WalletDto(UUID id, String operationType, double amount) {
        Id = id;
        this.operationType = operationType;
        this.amount = amount;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletDto walletDto = (WalletDto) o;
        return Double.compare(amount, walletDto.amount) == 0 && Objects.equals(Id, walletDto.Id) && Objects.equals(operationType, walletDto.operationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, operationType, amount);
    }

    @Override
    public String toString() {
        return "WalletDto{" +
                "Id=" + Id +
                ", operationType='" + operationType + '\'' +
                ", amount=" + amount +
                '}';
    }
}