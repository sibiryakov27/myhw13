package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    private ShopRepository repository = new ShopRepository();
    Product product1 = new Product(1, "Шоколад", 100);
    Product product2 = new Product(2, "Молоко", 60);
    Product product3 = new Product(3, "Яйца", 70);
    Product product4 = new Product(4, "Хлеб", 30);

    @BeforeEach
    public void setUp() {
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
    }

    @Test
    public void shouldRemoveProductById() {
        Product[] expected = { product1, product3, product4 };
        assertDoesNotThrow(() -> repository.removeById(2));
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotFoundException() {
        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }

    @Test
    public void shouldAddNewProduct() {
        Product product5 = new Product(5, "Творог", 90);
        Product[] expected = { product1, product2, product3, product4, product5 };
        assertDoesNotThrow(() -> repository.add(product5));
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowAlreadyExistsException() {
        assertThrows(AlreadyExistsException.class, () -> repository.add(new Product(2, "Творог", 90)));
    }

}