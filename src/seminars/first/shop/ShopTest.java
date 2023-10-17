package seminars.first.shop;

import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */

    //TODO Home work 1
    public static void main(String[] args) {

        Product milk = new Product();
        milk.setCost(10);
        milk.setTitle("Milk");
        Product bread = new Product();
        bread.setCost(5);
        bread.setTitle("Bread");
        Product meal = new Product();
        meal.setCost(30);
        meal.setTitle("Meal");

        List<Product> products = Arrays.asList(milk, bread, meal);

        Shop shop = new Shop();
        shop.setProducts(products);

        testListOfProducts(shop, products);
        testMostExpensive(shop);
        testOrder(shop);
    }

    public static void testListOfProducts(Shop shop, List<Product> products) {
        List<Product> sortProductsByPrice = shop.sortProductsByPrice();
        Assertions.assertThat(sortProductsByPrice).isNotEmpty().hasSize(3).containsAll(products);
    }

    public static void testMostExpensive(Shop shop) {
        Product mostExpensiveProduct = shop.getMostExpensiveProduct();
        Assertions.assertThat(mostExpensiveProduct.getCost()).isEqualTo(30);
    }

    public static void testOrder(Shop shop) {
        List<Product> sortProductsByPrice = shop.sortProductsByPrice();
        Assertions.assertThat(shop.getProducts()).isNotEmpty().hasSize(3);
        Product first = sortProductsByPrice.get(0);
        Assertions.assertThat(first.getCost()).isEqualTo(5);
        Assertions.assertThat(first.getTitle()).isEqualTo("Bread");
        Product last = sortProductsByPrice.get(2);
        Assertions.assertThat(last.getCost()).isEqualTo(30);
        Assertions.assertThat(last.getTitle()).isEqualTo("Meal");
    }
}