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
    public void shouldThrowAnException() {
        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }

}