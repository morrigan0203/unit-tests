package seminars.first.Shop;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        //TODO Home work 1
        if (this.products == null) {
            throw new IllegalStateException("List of product should not be null");
        }
        this.products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.compare(o1.getCost(), o2.getCost());
            }
        });
        return this.products;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        // Допишите реализацию метода самостоятельно

        //TODO Home work 1
        List<Product> list = sortProductsByPrice();
        if (list.isEmpty()) {
            throw new IllegalStateException("List of product should not be empty");
        }
        return list.get(list.size() - 1);
    }

}