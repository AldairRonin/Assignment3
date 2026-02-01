package repository.interfaces;

import java.util.List;

public interface CrudRepository<T> {

    void create(T entity);

    T getById(int id);

    List<T> getAll();

    void delete(int id);

    default boolean isEmpty() {
        return getAll().isEmpty();
    }

    static void validateId(int id) {
    if (id <= 0) {
        throw new IllegalArgumentException("ID must be positive");
    }
    }

}
