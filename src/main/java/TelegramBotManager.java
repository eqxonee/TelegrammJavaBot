import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class TelegramBotManager extends TelegramLongPollingBot {

    GameGuessTheNumber gameGuessTheNumber = new GameGuessTheNumber();

    private DbJokes dbJokes;
    private Links links;

    public TelegramBotManager(){
        dbJokes = new DbJokes();
        links = new Links();
    }

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
        if (update.hasMessage() && update.getMessage().hasText()) {

            String chatId = update.getMessage().getChatId().toString();
            String recieveText = update.getMessage().getText();

            String responceText = "";

            if(recieveText.equals("/joke")){

                responceText = dbJokes.getRandomJoke();
            } else if (recieveText.equals("/vk")) {
                responceText = links.vk();
            }
            else if(recieveText.equals("/myMusic")) {
                responceText = links.yandexMusic();
            }
            else if(recieveText.equals("/myTwitch")) {
                responceText = links.twitch();
            }
            else if(recieveText.equals("/myYouTube")) {
                responceText = links.youtube();
            }
            else if(recieveText.equals("/ded")){
                responceText = dbJokes.Grandfather();
            }
            else if(recieveText.equals("/game")){
                int text = Integer.parseInt(recieveText);
                text = gameGuessTheNumber.setNumberOfUser();

                gameGuessTheNumber.setNumberOfComp();
                responceText = String.valueOf(gameGuessTheNumber.setNumberOfComp());


            }
            else{
                responceText = "Ошибка, команда не распознана. Введите /joke or /vk or /myMusic or /myTwitch or /myYouTube or /ded or /game";
            }

            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText(responceText);

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
