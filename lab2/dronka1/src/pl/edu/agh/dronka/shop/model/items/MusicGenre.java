package pl.edu.agh.dronka.shop.model.items;

public enum MusicGenre {
    POP("Pop"), ROCK("Rock"), JAZZ("Jazz"), COUNTRY("Country"), UNDEFINED("Undefined");

    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    private MusicGenre(String displayName) {
        this.displayName = displayName;
    }
}
