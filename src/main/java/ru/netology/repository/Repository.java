package ru.netology.domain;

public class Repository {
    Product[] repo = {new Book(1, "Death is a lonely business", 300, "Ray Bradbury"),
            new Book(2, "I heard you paint houses", 500, "Charles Brandt"),
            new Book(3, "Autobiography", 400, "Helmut Newton"),
            new Smartphone(4, "11 Pro", 90000, "iPhone"),
            new Smartphone(5, "Galaxy A50", 10000, "Samsung"),
            new Smartphone(6, "P20", 30000, "Huawei")};

    public void saveProduct(Product item) {
        Product[] newRepo = new Product[repo.length + 1];
        for (int i = 0; i < repo.length; i++) {
            newRepo[i] = repo[i];
        }
        int lastIndex = newRepo.length - 1;
        newRepo[lastIndex] = item;
        repo = newRepo;
    }

    public Product[] findAll() {
        for (int i = 0; i < repo.length; i++) {
        }
        return repo;
    }

    public void removeById(int id) throws NotFoundException {
        boolean b = false;
        for (Product item : repo) {
            if (item.getId() == id) {
                b = true;
                break;
            }

        }

        if (b) {
            Product[] newRepo = new Product[repo.length - 1];
            int index = 0;
            for (Product item : repo) {
                if (item.getId() != id) {
                    newRepo[index] = item;
                    index++;
                }

            }

            repo = newRepo;
        } else {
            throw new NotFoundException(" Element with id: " + id + " not found");
        }

    }

}
