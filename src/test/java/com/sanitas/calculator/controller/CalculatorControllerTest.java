package com.sanitas.calculator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanitas.calculator.domain.Request;
import com.sanitas.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CalculatorService calculatorService;

    @Autowired
    ObjectMapper objectMapper;

    @Captor
    private ArgumentCaptor<Request> requestArgumentCaptor;


    @Test
    void testSum() throws Exception {
        String requestJson = objectMapper.writeValueAsString(new Request(1, 1));
        when(calculatorService.sum(any(Request.class))).thenReturn(2);
        given(calculatorService.sum(any(Request.class))).willReturn(2);

        MvcResult result = mockMvc.perform(post("/api/v1/calc/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andReturn();

        String responseString = result.getResponse().getContentAsString();
        System.out.println("result.getResponse().getContentAsString() = " + responseString);
        System.out.println("result.getResponse().getContentType() = " + result.getResponse().getContentType());
        System.out.println("result.getResponse().getStatus() = " + result.getResponse().getStatus());

        verify(calculatorService, times(1)).sum(requestArgumentCaptor.capture());
        then(calculatorService).should(times(1)).sum(requestArgumentCaptor.capture());

        assertThat(requestArgumentCaptor.getValue().getValue1()).isEqualTo(1);
        assertThat(requestArgumentCaptor.getValue().getValue2()).isEqualTo(1);
    }

    @Test
    void testSubtraction() throws Exception {
        String requestJson = objectMapper.writeValueAsString(new Request(1, 1));
        when(calculatorService.subtraction(any(Request.class))).thenReturn(0);
        given(calculatorService.subtraction(any(Request.class))).willReturn(0);

        MvcResult result = mockMvc.perform(post("/api/v1/calc/subtraction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andReturn();

        String responseString = result.getResponse().getContentAsString();
        System.out.println("result.getResponse().getContentAsString() = " + responseString);
        System.out.println("result.getResponse().getContentType() = " + result.getResponse().getContentType());
        System.out.println("result.getResponse().getStatus() = " + result.getResponse().getStatus());

        verify(calculatorService, times(1)).subtraction(requestArgumentCaptor.capture());
        then(calculatorService).should(times(1)).subtraction(requestArgumentCaptor.capture());

        assertThat(requestArgumentCaptor.getValue().getValue1()).isEqualTo(1);
        assertThat(requestArgumentCaptor.getValue().getValue2()).isEqualTo(1);
    }

}
