import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DbJokes {

    private Random random;
    private ArrayList<String> jokes;

    public DbJokes(){
        random = new Random();
        jokes = new ArrayList<>();

        Collections.addAll(jokes,
                "Из обсуждения телефонных мошенников.\n" +
                        "\n" +
                        "Наталья: Недавно звонил товарищ следователь. По поводу мошеннический действий с моим счетом. Знаете, как я обрадовалась? 20 минут рассказывала, как мой сосед машины меняет раз в 6 месяцев. Наверное, подпольный банкир. А дама из дома напротив водит мужчин. Она точно проститутка и налогов не платит. Товарищ следователь заикался. Пытался вставить слово. Потом сам бросил трубку.",

        "xxx: интересно, сколько интересно щас емкость всего инета?\n" +
                "xxx: нашел: Объем общемировых данных вырастет с 33 зеттабайт в 2018 году до 175 в 2025.\n" +
                "xxx: я таких приставок даже не знаю\n" +
                "yyy: да бля\n" +
                "yyy: 99 процентов это порно\n" +
                "yyy: остальные 99 процентов это видео с котиками\n" +
                "yyy: еще 99 процентов это порно с котиками.\n" +
                "yyy: и того 297 процентов говна",

        "Покупка гантелей по объявлениям - это сказка.\n" +
                "\"Гантели 20 кг, цена 6 т.р.\"\n" +
                "Прикидывваю - 40 кг за 6 000 р, это 150 рублей за кило. Выгодная цена за приличные гантели. Приезжаю, вижу гантели как на фото, даю 6 т.р., прошу помочь дотащить до такси. \"Нет вы не поняли - 6 т.р. за каждую!\". Ну блин, ну ок, раз взял такси и приехал, даю ещё 6 т.р. За хорошие гантели 20 кг не особо жалко. А стоп - что-то они больно лёгкие для 20 кг! \"Нет, вы не поняли - 20 кг весят ДВЕ гантели!\".",

        "xxx: Представляю себе время, когда миллениалы постареют, и поколение их внуков будет смотреть на все эти шкафы из Икеи, наполненные фигурками Человека Паука и коллекционными изданиями Гарри Поттера, и недоумевать, как мы сейчас недоумеваем из-за сервантов с хрусталём.\n" +
                "yyy: – Дед ну зачем тебе столько пластиковых фигурок из аниме?\n" +
                "– Вот помру тогда и выкините!\n" +
                "zzz: Учитывая, сколько некоторые уже сейчас стоят, к тому времени, скорее, деда выкинут, а половина родственников переубивают друг друга из за фигурок.",
                "Деда ебали 300 собак");
    }

    public String getRandomJoke(){
        int selectIndex = random.nextInt(jokes.size());
        return jokes.get(selectIndex);
    }

    public String Grandfather(){
        return jokes.get(4);
    }
}
