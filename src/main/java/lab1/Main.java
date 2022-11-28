package lab1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee employeeFirst = new Employee.EmployeeBuilder().setName("Misha").setPosition("Receiver").setSalary(20000).setPhoneNumber("0504340601").setMedicalExamination(true).setAddress("Holovna, 1")
                .build();

        Product productFirst = new Product.ProductBuilder().setId(901).setName("Table").setPrice(1500).setCategory("Kitchen")
                .build();

        Product productSecond = new Product.ProductBuilder().setId(901).setName("Table").setPrice(1500).setCategory("Kitchen")
                .build();

        List<Product> kitchenProducts = Arrays.asList(productFirst, productSecond);

        Producer producerFirst = new Producer.ProducerBuilder().setName("Andrew").setProducts(kitchenProducts).setAddress("Ukraine, Chernivtsi, Soborna 2")
                .build();

        System.out.println("Employee: ");
        System.out.println(employeeFirst);

        System.out.println("Product first: ");
        System.out.println(productFirst);

        System.out.println("Product second: ");
        System.out.println(productSecond);

        System.out.println("Producer: ");
        System.out.println(producerFirst);

    }
}
