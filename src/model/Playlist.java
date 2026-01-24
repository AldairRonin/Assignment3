package model;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements Validatable {

    private int id;
    private String name;
    private List<Media> mediaList;

    public Playlist(int id, String name) {
        this.id = id;
        this.name = name;
        this.mediaList = new ArrayList<>();
    }

    @Override
    public void validate() {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Playlist name cannot be empty");
        }
    }

    public void addMedia(Media media) {
        mediaList.add(media);
    }

    public void removeMedia(Media media) {
        mediaList.remove(media);
    }

    public List<Media> getMediaList() {
        return mediaList;
    }
}
