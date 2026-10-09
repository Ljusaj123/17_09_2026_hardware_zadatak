package com.example.__09_2026_hardware_zadatak.controller;

import com.example.__09_2026_hardware_zadatak.dto.AuthRequestDTO;
import com.example.__09_2026_hardware_zadatak.dto.JwtResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class HardwareControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthController authController;

    private String accessToken;

    @BeforeEach
    void setUp() {
        AuthRequestDTO authRequest = new AuthRequestDTO();
        authRequest.setUsername("admin");
        authRequest.setPassword("admin");

        if (Optional.ofNullable(accessToken).isEmpty()) {
            JwtResponseDTO jwtResponse = authController.authenticateAndGetToken(authRequest);
            accessToken = jwtResponse.getAccessToken();
        }
    }

    @Test
    void testGetAll() throws Exception {
        mockMvc.perform(get("/hardware")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].naziv", is("Intel Core i7-14700K")))
                .andExpect(jsonPath("$[1].naziv", is("NVIDIA GeForce RTX 4070")))
                .andExpect(jsonPath("$[2].naziv", is("ASUS ROG STRIX B650")))
                .andExpect(jsonPath("$[3].naziv", is("Corsair Vengeance 32GB")));
    }

    @Test
    void testGetByCode() throws Exception {
        mockMvc.perform(get("/hardware/{hardwareCode}", "CPU-001")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.naziv").value("Intel Core i7-14700K"))
                .andExpect(jsonPath("$.sifra").value("CPU-001"))
                .andExpect(jsonPath("$.tip").value("CPU"));
    }

    @Test
    void testSaveHardware() throws Exception {

        String hardwareJson = """
                {
                    "naziv": "Intel i8",
                    "sifra": "CPU002",
                    "cijena": 399.99,
                    "tip": "CPU",
                    "kolicina": 30
                }
                """;

        mockMvc.perform(post("/hardware")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(hardwareJson))
                .andExpect(status().isCreated())
                .andExpect(content().string("Hardware je uspješno kreiran"));
    }

    @Test
    void testUpdateHardware() throws Exception {
        String hardwareJson = """
                {
                    "naziv": "Intel i7 Updated",
                    "sifra": "CPU001",
                    "cijena": 449.99,
                    "tip": "CPU",
                    "kolicina": 15
                }
                """;
        mockMvc.perform(put("/hardware/{hardwareId}", 2)
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(hardwareJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Hardware je uspješno ažuriran"));
    }

    @Test
    void testDeleteHardware() throws Exception {
        mockMvc.perform(delete("/hardware/{hardwareId}", 2)
                        .header("Authorization", "Bearer " + accessToken))
                .andExpect(status().isOk())
                .andExpect(content().string("Hardware je uspješno obrisan"));
    }

}
