package com.message.queue.listener;

import com.message.queue.config.MessageConfig;
import com.message.queue.entity.Statistic;
import com.message.queue.service.StatisticService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class StatisticListener {
    private final StatisticService statisticService;

    public StatisticListener(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @RabbitListener(queues = MessageConfig.QUEUE)
    public void consumeMessageFromQueue(Statistic statistic) {
        try {
            System.out.println(statisticService.saveToDB(statistic));
            System.out.println("Save to db success");
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
