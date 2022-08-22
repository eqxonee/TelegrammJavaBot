import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class InlineButtons extends TelegramLongPollingBot {

    Links links = new Links();
    @Override
    public String getBotUsername() {
        return "eqxoneebot";
    }

    @Override
    public String getBotToken() {
        return "5586400158:AAG3k-XwqgiT7CTVijFztJmzwlikczUphTE";
    }

    @Override
    public void onUpdateReceived(Update update) {{

            if (update.hasMessage() && update.getMessage().hasText()) {

                String messageFromBot = update.getMessage().getText();
                long chat_id = update.getMessage().getChatId();

                if (messageFromBot.equals("/start")) {

                    InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();

                    List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

                    List<InlineKeyboardButton> row = new ArrayList<>();
                    InlineKeyboardButton button = new InlineKeyboardButton();
                    button.setText("VK");
                    button.setCallbackData("/vk");
                    row.add(button);

                    button = new InlineKeyboardButton();
                    button.setText("YouTube");
                    button.setCallbackData("/myYouTube");
                    row.add(button);

                    button = new InlineKeyboardButton();
                    button.setText("YandexMusic");
                    button.setCallbackData("/myMusic");
                    row.add(button);

                    keyboard.add(row);

                    replyKeyboardMarkup.setKeyboard(keyboard);

                    SendMessage message = new SendMessage();
                    message.setChatId(chat_id);
                    message.setText("Inline keyboard");
                    message.setReplyMarkup(replyKeyboardMarkup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            } else if (update.hasCallbackQuery()) {
                String callbackDataFromBot = update.getCallbackQuery().getData();
                int messageId = update.getCallbackQuery().getMessage().getMessageId();
                long chat_id = update.getCallbackQuery().getMessage().getChatId();

                String responseText = "";

                switch (callbackDataFromBot) {
                    case "/vk":
                        responseText = links.vk();
                        break;

                    case "/myYouTube":
                        responseText = links.youtube();
                        break;

                    case "/myMusic":
                        responseText = links.yandexMusic();
                        break;

                }

//            SendMessage message = new SendMessage();
//            message.setChatId(chat_id);
//            message.setText(responseText);

                EditMessageText message = new EditMessageText();
                message.setChatId(chat_id);
                message.setMessageId(messageId);
                message.setText(responseText);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
