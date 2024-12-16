package com.example.test_java_code.controller;

import com.example.test_java_code.dto.WalletDto;
import com.example.test_java_code.service.WalletService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(WalletController.class)
public class WalletControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WalletService walletService;

    @Test
    public void testChangeBalance() throws Exception {
        WalletDto walletDto = new WalletDto();
        walletDto.setId(UUID.randomUUID());
        walletDto.setOperationType("DEPOSIT");
        walletDto.setAmount(1000);

        mockMvc.perform(post("/api/v1/wallet")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(walletDto)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetBalance() throws Exception {
        UUID walletId = UUID.randomUUID();
        when(walletService.getBalance(walletId)).thenReturn(1000.0);

        mockMvc.perform(get("/api/v1/wallets/" + walletId))
                .andExpect(status().isOk());
    }
}
