package ru.shirkov.repositore;

public interface Repo<T> {
T getById(Long id);
}
