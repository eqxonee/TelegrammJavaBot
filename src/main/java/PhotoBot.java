import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Comparator;
import java.util.List;

public class PhotoBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "eqxoneebot";
    }

    @Override
    public String getBotToken() {
        return "5586400158:AAG3k-XwqgiT7CTVijFztJmzwlikczUphTE";
    }

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            SendMessage message = new SendMessage(); // Create a message object object
            message.setChatId(chat_id);
            message.setText(message_text);
            try {
                execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        else if (update.hasMessage() && update.getMessage().hasPhoto()) {
            // Message contains photo
            // Set variables
            long chat_id = update.getMessage().getChatId();

            // Array with photo objects with different sizes
            // We will get the biggest photo from that array
            List<PhotoSize> photos = update.getMessage().getPhoto();
            // Know file_id
            String f_id = photos.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getFileId();
            // Know photo width
            int f_width = photos.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getWidth();
            // Know photo height
            int f_height = photos.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getHeight();

            // Set photo caption
            String caption = "file_id: " + f_id + "\nwidth: " + Integer.toString(f_width) + "\nheight: " + Integer.toString(f_height);

            InputFile inputFile = new InputFile(f_id);

            SendPhoto msg = new SendPhoto();
                    msg.setChatId(chat_id);
                    msg.setPhoto(inputFile);
                    msg.setCaption(caption);

            try {
                execute(msg); // Call method to send the photo with caption
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            if (message_text.equals("/start")) {
                // User send /start
                SendMessage message = new SendMessage(); // Create a message object object
                        message.setChatId(chat_id);
                        message.setText(message_text);
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (message_text.equals("/sova")) {
                // User sent /pic
                SendPhoto msg = new SendPhoto();
                        msg.setChatId(chat_id);
                        msg.setPhoto(new InputFile("AgACAgIAAxkBAAODYwOAxj0-mBmV4iRaJmaK3FSYELMAAgbBMRuCxBlInJIc6A-8e7ABAAMCAAN4AAMpBA"));
                        msg.setCaption("Its me :(");
                try {
                    execute(msg); // Call method to send the photo
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (message_text.equals("/sky")) {
                // User sent /pic
                SendPhoto msg = new SendPhoto();
                msg.setChatId(chat_id);
                msg.setPhoto(new InputFile("AgACAgIAAxkBAAOOYwOSyWfxOspC2e2qUD7ODz-o0UEAAk7BMRuCxBlIuq91xqH62_0BAAMCAAN4AAMpBA"));
                msg.setCaption("SkywrathMage");
                try {
                    execute(msg); // Call method to send the photo
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {
                // Unknown command
                SendMessage message = new SendMessage(); // Create a message object object
                        message.setChatId(chat_id);
                        message.setText("Unknown command");
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }




    }
}



