import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws Exception{

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            //botsApi.registerBot(new TelegramBotManager());
            //botsApi.registerBot(new InlineButtons());
            botsApi.registerBot(new PhotoBot());
            System.out.println("bot started");

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

      /*  ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new PhotoBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        System.out.println("PhotoBot successfully started!");
    }*/


    }

}