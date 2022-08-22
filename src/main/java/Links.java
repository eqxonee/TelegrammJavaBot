import java.util.ArrayList;
import java.util.Collections;

public class Links {

    private ArrayList<String> links;

    public Links() {
        links = new ArrayList<>();

        Collections.addAll(links,"https://vk.com/ezio_a",
                "https://music.yandex.ru/users/lich1997a/playlists",
                "https://www.twitch.tv",
                "https://www.youtube.com");
    }

    public String vk(){
        return links.get(0);
    }

    public String yandexMusic(){
        return links.get(1);
    }

    public String twitch(){
        return links.get(2);
    }

    public String youtube(){
        return links.get(3);
    }

}
