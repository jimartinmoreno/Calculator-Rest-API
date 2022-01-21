package com.sanitas.calculator.controller;

import com.sanitas.calculator.domain.Request;
import com.sanitas.calculator.domain.Response;
import com.sanitas.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculatorControllerMockTest {

    @InjectMocks
    CalculatorController calculatorController;

    @Mock
    CalculatorService calculatorService;

    @Captor
    private ArgumentCaptor<Request> requestArgumentCaptor;


    @Test
    void testSum() {
        when(calculatorService.sum(any(Request.class))).thenReturn(2);
        //given(calculatorService.sum(any(Request.class))).willReturn(2);

        ResponseEntity<Response> result = calculatorController.sum(new Request(1, 1));

        verify(calculatorService, times(1)).sum(requestArgumentCaptor.capture());
        //then(calculatorService).should(times(1)).sum(requestArgumentCaptor.capture());

        assertThat(requestArgumentCaptor.getValue().getValue1()).isEqualTo(1);
        assertThat(requestArgumentCaptor.getValue().getValue2()).isEqualTo(1);
        assertThat(Objects.requireNonNull(result.getBody()).getSolution()).isEqualTo(2);
    }

    @Test
    void testSubtraction() {
        when(calculatorService.subtraction(any(Request.class))).thenReturn(0);
        //given(calculatorService.subtraction(any(Request.class))).willReturn(0);

        ResponseEntity<Response> result = calculatorController.subtraction(new Request(1, 1));

        verify(calculatorService, times(1)).subtraction(requestArgumentCaptor.capture());
        //then(calculatorService).should(times(1)).subtraction(requestArgumentCaptor.capture());

        assertThat(requestArgumentCaptor.getValue().getValue1()).isEqualTo(1);
        assertThat(requestArgumentCaptor.getValue().getValue2()).isEqualTo(1);
        assertThat(Objects.requireNonNull(result.getBody()).getSolution()).isZero();
    }

}
