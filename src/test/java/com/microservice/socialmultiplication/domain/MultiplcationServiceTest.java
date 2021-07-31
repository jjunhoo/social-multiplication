package com.microservice.socialmultiplication.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given; // given template

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MultiplcationServiceTest {

    // Mock 객체는 실제 모듈과 비슷하게 동작하도록 정의한 가짜 객체
    // 진짜 객체가 아직 구현되기 전이나 진짜 객체로 테스트하기 어려운 경우, Mock 객체로 테스트를 작성할 수 있음
    @MockBean
    private RandomGeneratorService randomGeneratorService; // 해당 클래스를 완성하지 않고, Application 을 실행하면, Bean 을 찾을 수 없다는 console 확인 가능

    @Autowired
    private MultiplcationService multiplcationService;

    @Test
    public void createRandomMultiplicationTest() {
        // given (randomGeneratorService 가 처음에 50, 나중에 30 을 반환하도록 셋팅)
        // randomGeneratorService 클래스가 완성되지 않은 상태에서 @MockBean 을 사용하면,
        given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30); // BDD - Behavior-Driven-Development (행위 주도 개발)

        // when
        Multiplication multiplication = multiplcationService.createRandomMultiplication();

        // then (assert)
        assertThat(multiplication.getFactorA()).isEqualTo(50);
        assertThat(multiplication.getFactorB()).isEqualTo(30);
        assertThat(multiplication.getResult()).isEqualTo(1500);
    }
}