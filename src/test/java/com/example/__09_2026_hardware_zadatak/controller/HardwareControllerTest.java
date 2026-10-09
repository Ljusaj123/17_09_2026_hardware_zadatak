package com.example.__09_2026_hardware_zadatak.controller;

import com.example.__09_2026_hardware_zadatak.dto.HardwareDTO;
import com.example.__09_2026_hardware_zadatak.service.HardwareService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class HardwareControllerTest {
    @Mock
    private HardwareService hardwareService;

    @InjectMocks
    private HardwareController hardwareController;

    private MockMvc mockMvc;

    private List<HardwareDTO> hardwareList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(hardwareController).build();

        HardwareDTO hardware1 = new HardwareDTO(
                "Intel Core i7-14700K",
                "CPU001",
                new BigDecimal("399.99"),
                "CPU",
                10
        );

        HardwareDTO hardware2 = new HardwareDTO(
                "RTX 4070",
                "GPU001",
                new BigDecimal("599.99"),
                "GPU",
                5
        );

        hardwareList = Arrays.asList(hardware1, hardware2);
    }

    @Test
    void testGetAll() throws Exception {

        when(hardwareService.getAllHardware())
                .thenReturn(hardwareList);

        mockMvc.perform(get("/hardware"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));

        verify(hardwareService, times(1))
                .getAllHardware();
    }

    @Test
    void testGetByCode_Found() throws Exception {

        when(hardwareService.getHardwareByCode("CPU001"))
                .thenReturn(hardwareList.get(0));

        mockMvc.perform(get("/hardware/{hardwareCode}", "CPU001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.naziv",
                        is("Intel Core i7-14700K")))
                .andExpect(jsonPath("$.sifra",
                        is("CPU001")));

        verify(hardwareService, times(1))
                .getHardwareByCode("CPU001");
    }

    @Test
    void testGetByCode_NotFound() throws Exception {
        when(hardwareService.getHardwareByCode("NOTFOUND"))
                .thenThrow(new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Hardware ne postoji"
                ));

        mockMvc.perform(get("/hardware/{hardwareCode}", "NOTFOUND"))
                .andExpect(status().isNotFound());

        verify(hardwareService, times(1))
                .getHardwareByCode("NOTFOUND");
    }

    @Test
    void testSave_Success() throws Exception {
        String hardwareJson = """
            {
                "naziv": "Intel Core i7-14700K",
                "sifra": "CPU001",
                "cijena": 399.99,
                "tip": "CPU",
                "kolicina": 10
            }
            """;

        doNothing().when(hardwareService)
                .saveNewHardware(any(HardwareDTO.class));

        mockMvc.perform(post("/hardware")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(hardwareJson))
                .andExpect(status().isCreated())
                .andExpect(content().string("Hardware je uspjesno kreiran"));

        verify(hardwareService, times(1))
                .saveNewHardware(any(HardwareDTO.class));
    }

    @Test
    void testSave_Conflict() throws Exception {

        String hardwareJson = """
            {
                "naziv": "Intel Core i7-14700K",
                "sifra": "CPU001",
                "cijena": 399.99,
                "tip": "CPU",
                "kolicina": 10
            }
            """;

        doThrow(new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Hardware već postoji"
        )).when(hardwareService)
                .saveNewHardware(any(HardwareDTO.class));

        mockMvc.perform(post("/hardware")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(hardwareJson))
                .andExpect(status().isConflict());

        verify(hardwareService, times(1))
                .saveNewHardware(any(HardwareDTO.class));
    }

}
