package com.serdarkuzucu.mdcdemo.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Generates a random UUID without hyphens
 *
 * @author Serdar Kuzucu
 */
@Component
public class UUIDLogTrackIdGenerator implements LogTrackIdGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
