package repository.interfaces;

import model.Media;

public interface MediaRepository extends CrudRepository<Media> {

    boolean existsById(int id);
}
