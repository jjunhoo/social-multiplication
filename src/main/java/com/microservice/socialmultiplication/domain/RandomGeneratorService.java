package com.microservice.socialmultiplication.domain;

public interface RandomGeneratorService {
    /**
     * @return 무작위로 만든 11 이상 99 이하의 인수
     */
    int generateRandomFactor();
}
