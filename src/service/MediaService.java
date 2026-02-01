package service;

import java.util.List;
import model.Media;
import repository.interfaces.MediaRepository;

public class MediaService {

    private final MediaRepository mediaRepository;

    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public void addMedia(Media media) {
        mediaRepository.create(media);
    }

    public List<Media> getAllMedia() {
        return mediaRepository.getAll();
    }

    public boolean mediaExists(int id) {
        return mediaRepository.existsById(id);
    }
}
