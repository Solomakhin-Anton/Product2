package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.*;
import ru.netology.domain.Repository;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Repository repo = new Repository();


    @Test
    void shouldRemoveByIdIfExists() {
        repo.removeById(3);
        Product[] expected = {new Book(1, "Death is a lonely business", 300, "Ray Bradbury"),
                new Book(2, "I heard you paint houses", 500, "Charles Brandt"),
                new Smartphone(4, "11 Pro", 90000, "iPhone"),
                new Smartphone(5, "Galaxy A50", 10000, "Samsung"),
                new Smartphone(6, "P20", 30000, "Huawei")};
        assertArrayEquals(expected, repo.findAll());
    }


    @Test
    void shouldRemoveByIdIfDoesNotExist() {
        assertThrows(NotFoundException.class, () -> repo.removeById(8));
    }
}