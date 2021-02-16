package ru.job4j.pojo;

/**
 * Класс магазин.
 *
 * @author Sergey Morozov(moroz.future@gmail.com)
 * @version 1.0
 */
public class Shop {
    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println();
        Shop shop = new Shop();
        products = shop.delete(products, 1);

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }

    /**
     * Метод удаления из массива продукта, и дефрагментация массива.
     * @param products - массив продуктов.
     * @param index - индекс удаляемого продукта.
     * @return - обработанный масиив.
     */
    public Product[] delete(Product[] products, int index) {
        for ( ; index < products.length - 1; index++) {
            products[index] = products[index + 1];
        }
        products[index] = null;
        return products;
    }
}