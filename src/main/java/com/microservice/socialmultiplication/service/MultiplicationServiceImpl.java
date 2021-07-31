package com.microservice.socialmultiplication.service;

import com.microservice.socialmultiplication.domain.MultiplcationService;
import com.microservice.socialmultiplication.domain.Multiplication;
import com.microservice.socialmultiplication.domain.RandomGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiplicationServiceImpl implements MultiplcationService {

    private RandomGeneratorService randomGeneratorService;

    @Autowired
    public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService) {
        this.randomGeneratorService = randomGeneratorService;
    }

    /**
     * 2개의 값을 랜덤하게 생성하고 곱한 결과를 Multiplication 클래스로 리턴
     * @return {@link Multiplication}
     */
    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }
}
