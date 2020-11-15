package org.paysdk.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BotApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(BotApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {

        TelegramBot bot = new TelegramBot("1417055143:AAEH2kYow1YW_VSble3_xFqJVQivjrOqk_w");

        bot.setUpdatesListener(updates -> {
            updates.forEach(System.out::println);

            updates.forEach(update -> {
                if (update.message().text().equals("/start")) {
                    bot.execute(new SendMessage(update.message().chat().id(),
                            "Добро пожаловать, " + update.message().from().firstName() + "!"));
                } else {
                    processAddCommand(bot, update);
                    processHistoryCommand(bot, update);
                }
            });

            // TODO: implement it

            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });

    }

    private void processAddCommand(TelegramBot bot, com.pengrad.telegrambot.model.Update update) {
        if (update.message().text().equals("/add")) {
            bot.execute(new SendMessage(update.message().chat().id(),
                    "Для того, чтобы зарегистрировать нового разработчика, отправьте " +
                            "следующее сообщение с тремя элементами, " +
                            "1.Команда new, 2.MerchantId и 3.SecretKey.\n" +
                            "Обратите внимание, каждый элемент должен начинаться " +
                            "с новой строки. Пример:\n\n" +
                            "new\n384823903\n49308232"));
        }
    }

    private void processHistoryCommand(TelegramBot bot, Update update) {
        if (update.message().text().equals("/history")) {
            bot.execute(new SendMessage(update.message().chat().id(),
                    "Платежи за последний месяц:\n" +
                            "...\n" +
                            "..."));
        }
    }
}
