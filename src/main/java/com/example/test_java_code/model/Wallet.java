package com.example.test_java_code.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
public class Wallet {

    @Id
    @GeneratedValue
    private UUID Id;
    @Column(name = "balance")
    private double balance;

    public Wallet() {
    }

    public Wallet(UUID id, double balance) {
        Id = id;
        this.balance = balance;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Double.compare(balance, wallet.balance) == 0 && Objects.equals(Id, wallet.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, balance);
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "Id=" + Id +
                ", balance=" + balance +
                '}';
    }
}
