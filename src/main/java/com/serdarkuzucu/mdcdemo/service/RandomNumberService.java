package com.serdarkuzucu.mdcdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author Serdar Kuzucu
 */
@Service
public class RandomNumberService {
    private static final Logger LOG = LoggerFactory.getLogger(RandomNumberService.class);

    public Number generateRandomNumber() {
        final int randomNumber = new Random().nextInt();
        LOG.info("generated random number is {}", randomNumber);
        return randomNumber;
    }
}
