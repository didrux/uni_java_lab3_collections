package lab1;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(builder = Producer.ProducerBuilder.class)
public class Producer {

    private String name;
    private String address;
    private final List<Product> products = new ArrayList<>();

    public Producer(ProducerBuilder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.products.addAll(builder.products);
    }

    /**
     * Set producer address
     *
     * @param address producer address
     */
    public void setAddress(String address) {
        this.address = address;
    }


    /**
     * Set producer name
     *
     * @param name producer name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return producer address
     */
    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    /**
     * Get all products from producer's product list
     *
     * @return list of products
     */
    public List<Product> getProducts() {
        return products;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "set")
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
