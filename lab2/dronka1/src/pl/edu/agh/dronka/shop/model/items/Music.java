package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

public class Music extends Item {
    private final MusicGenre musicGenre;
    private boolean videoAttached;

    public Music(){
        super();
        musicGenre=MusicGenre.UNDEFINED;
    }

    public Music(String name, Category category, int price, int quantity, MusicGenre musicGenre, boolean videoAttached){
        super(name, category, price, quantity);
        this.musicGenre=musicGenre;
        this.videoAttached=videoAttached;
    }

    public MusicGenre getMusicGenre() {
        return musicGenre;
    }

    public boolean isVideoAttached() {
        return videoAttached;
    }

    public void setVideoAttached(boolean videoAttached) {
        this.videoAttached = videoAttached;
    }
}
