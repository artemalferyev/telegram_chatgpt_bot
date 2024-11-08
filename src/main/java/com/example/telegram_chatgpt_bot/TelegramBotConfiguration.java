package com.example.telegram_chatgpt_bot;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class TelegramBotConfiguration {

    @SneakyThrows
    @Bean
    public TelegramBot telegramBot(
        @Value("${bot.token}") String botToken,
        TelegramBotsApi telegramBotsApi
    ) {
        var botOptions = new DefaultBotOptions();
        var bot = new TelegramBot (botOptions, botToken);
        telegramBotsApi.registerBot(bot);
        return bot;
    }

    @SneakyThrows
    @Bean
    public TelegramBotsApi telegramBotsApi () {
        return new TelegramBotsApi(DefaultBotSession.class);
    }
}
