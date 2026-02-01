package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Media;
import model.Podcast;
import model.Song;
import repository.interfaces.MediaRepository;
import utils.DatabaseConnection;

public class JdbcMediaRepository implements MediaRepository {

    //  создание новой записи в таблице media
    public void create(Media media) {
        String sql = "INSERT INTO media (title, duration, type) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, media.getTitle());
            stmt.setInt(2, media.getDuration());
            stmt.setString(3, media.getType());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to create media", e);
        }
    }

    //  получение всех записей из таблицы media
    public List<Media> getAll() {
        List<Media> result = new ArrayList<>();
        String sql = "SELECT * FROM media";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int duration = rs.getInt("duration");
                String type = rs.getString("type");

                Media media;

                if ("song".equals(type)) {
                    media = new Song(id, title, duration);
                } else {
                    media = new Podcast(id, title, duration);
                }

                result.add(media);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to get media", e);
        }

        return result;
    }

    // получение одного media по id
    public Media getById(int mediaId) {
        String sql = "SELECT * FROM media WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, mediaId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String title = rs.getString("title");
                int duration = rs.getInt("duration");
                String type = rs.getString("type");

                if ("song".equals(type)) {
                    return new Song(mediaId, title, duration);
                } else {
                    return new Podcast(mediaId, title, duration);
                }
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Failed to get media by id", e);
        }
    }

    // существует ли media по id
    public boolean existsById(int mediaId) {
        String sql = "SELECT 1 FROM media WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, mediaId);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to check media existence", e);
        }

    }
    // удаление media по id
    @Override
    public void delete(int id) {
    String sql = "DELETE FROM media WHERE id = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        stmt.executeUpdate();

    } catch (SQLException e) {
        throw new RuntimeException("Failed to delete media", e);
    }
}

}
