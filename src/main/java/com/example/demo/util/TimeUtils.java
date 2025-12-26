package com.example.demo.util;

import java.time.LocalTime;
import java.time.Duration;

public class TimeUtils {
    
    public static long minutesBetween(LocalTime startTime, LocalTime endTime) {
        return Duration.between(startTime, endTime).toMinutes();
    }
}