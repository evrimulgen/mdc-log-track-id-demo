package com.serdarkuzucu.mdcdemo.controller;

import com.serdarkuzucu.mdcdemo.service.RandomNumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Serdar Kuzucu
 */
@RestController
public class RandomNumberController {
    private static final Logger LOG = LoggerFactory.getLogger(RandomNumberController.class);

    private final RandomNumberService randomNumberService;

    @Autowired
    public RandomNumberController(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    @GetMapping("random-number")
    public Map<String, Number> getRandomNumber() {
        LOG.info("RandomNumberController.getRandomNumber invoked");

        final Number randomNumber = randomNumberService.generateRandomNumber();
        LOG.info("randomNumber={}", randomNumber);

        final Map<String, Number> responseBody = new HashMap<>();
        responseBody.put("value", randomNumber);

        LOG.info("RandomNumberController.getRandomNumber result={}", responseBody);
        return responseBody;
    }
}
