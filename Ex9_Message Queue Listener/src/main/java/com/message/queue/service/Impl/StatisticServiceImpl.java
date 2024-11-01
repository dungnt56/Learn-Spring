package com.message.queue.service.Impl;

import com.message.queue.entity.Statistic;
import com.message.queue.repository.StatisticRepository;
import com.message.queue.service.StatisticService;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl implements StatisticService {
    private final StatisticRepository statisticRepository;
    public StatisticServiceImpl(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @Override
    public Statistic saveToDB(Statistic statistic) {
        return statisticRepository.save(statistic);
    }
}
