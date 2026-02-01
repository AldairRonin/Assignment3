package service;

import java.util.List;
import model.Media;
import repository.PlaylistRepository;

public class PlaylistService {

    private final PlaylistRepository playlistRepository = new PlaylistRepository();

    // добавление media
    public void addMedia(int playlistId, int mediaId) {
        playlistRepository.addMediaToPlaylist(playlistId, mediaId);
    }

    // удаление media
    public void removeMedia(int playlistId, int mediaId) {
        playlistRepository.removeMediaFromPlaylist(playlistId, mediaId);
    }

    //  проверка, находится ли media в плейлисте
    public boolean isMediaInPlaylist(int playlistId, int mediaId) {
        return playlistRepository.isMediaInPlaylist(playlistId, mediaId);
    }

    //  получение media плейлиста
    public List<Media> getPlaylistMedia(int playlistId) {
        return playlistRepository.getMediaByPlaylistId(playlistId);
    }

    // получение названия плейлиста
    public String getPlaylistNameById(int playlistId) {
        return playlistRepository.getPlaylistNameById(playlistId);
    }
    //создание нового плейлиста
    public void addPlaylist(String name) {
        playlistRepository.createPlaylist(name);
    }

    // получение общей длительности плейлиста
    public int getTotalDuration(int playlistId) {
    return getPlaylistMedia(playlistId).stream()
            .mapToInt(Media::getDuration)
            .sum();
    }

    // получение самого длинного media в плейлисте
    public Media getLongestMedia(int playlistId) {
        return getPlaylistMedia(playlistId).stream()
                .max((m1, m2) -> Integer.compare(m1.getDuration(), m2.getDuration()))
                .orElse(null);
    }


}
