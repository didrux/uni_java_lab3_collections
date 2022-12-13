package lab1;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.*;

public class Producer implements Comparable<Producer> {

    private String name;
    private String address;
    private final List<Product> products = new ArrayList<>();

    public Producer(ProducerBuilder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.products.addAll(builder.products);
    }

    /**
     * Set producer name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set producer address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Add producer product
     * @param product
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Add producer products
     * @param products
     */
    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    /**
     * Get producer name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Get producer address
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get all products from producer's product list
     * @return list of products
     */
    public List<Product> getProducts() {
        return products;
    }


    /**
     * Return producer's product with specified name
     *
     * @param name products name
     * @return list of producer's products with specified name
     */
    public List<Product> getProductsByNameStream(String name) {
        return products.stream().filter(product -> Objects.equals(product.getName(), name)).toList();
    }

    public List<Product> getProductsByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equals(name)) {
                result.add(product);
            }
        }
        return result;
    }

    /**
     * Return producer's product with specified category
     *
     * @param category products category
     * @return list of producer's product with specified category
     */
    public List<Product> getProductsByCategoryStream(String category) {
        return products.stream().filter(product -> Objects.equals(product.getCategory(), category)).toList();
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                result.add(product);
            }
        }
        return result;
    }

    /**
     * Return producer's product with specified id by STREAM API
     *
     * @param id product id
     * @return product with specified id
     */
    public Product getProductsByIdStream(int id) {
        return products.stream().filter(product -> Objects.equals(product.getId(), id)).findFirst().get();
    }

    public Product getProductsById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


    /**
     * Use comparator to sort Products by id
     */
    public void sortProductsById() {
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getId() < o2.getId())
                    return -1;
                else if (o1.getId() == o2.getId())
                    return 0;
                return 1;
            }
        });
    }

    public void sortProductsByPrice() {
        products.sort(Comparator.comparing(Product::getPrice));
    }

    @Override
    public int compareTo(Producer o) {
        return (this.name + this.address).compareTo(o.name + o.address);
    }


    /**
     * Use comparator to sort Products by Name
     */
    public void sortProductsByName() {
        products.sort(Comparator.comparing(Product::getName));
    }

    public static class ProducerBuilder {
        private String name;
        private String address;
        private final List<Product> products = new ArrayList<>();

        /**
         * Set name of producer
         *
         * @param name producer name
         * @return ProducerBuilder instance
         */
        public ProducerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * Set address of producer
         *
         * @param address producer address
         * @return ProducerBuilder instance
         */
        public ProducerBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        /**
         * Set list of producer products
         *
         * @param products list of products
         * @return ProducerBuilder instance
         */
        public ProducerBuilder setProducts(List<Product> products) {
            this.products.addAll(products);
            return this;
        }

        /**
         * Create new Producer object
         *
         * @return Producer instance
         */
        public Producer build() {
            return new Producer(this);
        }
    }

    /**
     * Generate hash code for Producer
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(address + super.hashCode());
    }

    /**
     * Generate string from Producer object
     *
     * @return string representation of Producer
     */
    @Override
    public String toString() {
        return "{\"name\":\"" + name + "\",\"address\":\"" + address + "\",\"products\":" + products + "}";
    }

    /**
     * Compare producers objects
     *
     * @param obj object to compare
     * @return are two objects equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        if (this == obj)
            return true;
        return Objects.equals(name, ((Producer) obj).name)
                && Objects.equals(address, ((Producer) obj).address)
                && Objects.equals(products, ((Producer) obj).products);
    }
}
