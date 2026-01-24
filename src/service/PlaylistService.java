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
}
