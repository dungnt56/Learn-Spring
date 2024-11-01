package com.message.queue.service;

import com.message.queue.entity.Statistic;
import org.springframework.stereotype.Service;

@Service
public interface StatisticService {
    Statistic saveToDB(Statistic statistic);
}
