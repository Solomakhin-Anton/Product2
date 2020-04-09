package ru.netology.repository;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;

public class Repository {
    Product[] repo = {new Book(1, "Death is a lonely business", 300, "Ray Bradbury"),
            new Book(2, "I heard you paint houses", 500, "Charles Brandt"),
            new Book(3, "Autobiography", 400, "Helmut Newton"),
            new Smartphone(4, "11 Pro", 90000, "iPhone"),
            new Smartphone(5, "Galaxy A50", 10000, "Samsung"),
            new Smartphone(6, "P20", 30000, "Huawei")};

    public void saveProduct(Product item) {
        Product[] newRepo = new Product[repo.length + 1];
        System.arraycopy(repo, 0, newRepo, 0, repo.length);
        int lastIndex = newRepo.length - 1;
        newRepo[lastIndex] = item;
        repo = newRepo;
    }

    public Product[] findAll() {
        for (int i = 0; i < repo.length; i++) {
        }
        return repo;
    }

    public Product findById(int id) {
        for (Product item : repo) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) throws NotFoundException {
        if (findById(id) == null) {
            throw new NotFoundException(" Element with id: " + id + " not found");
        }
        int length = repo.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : repo) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        repo = tmp;
    }

}
