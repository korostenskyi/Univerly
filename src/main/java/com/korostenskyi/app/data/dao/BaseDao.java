package com.korostenskyi.app.data.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T> {

    void save(T t);
    void update(T t);
    Optional<T> get(int id);
    List<T> getAll();
    void delete(T t);
    void deleteAll();
}
