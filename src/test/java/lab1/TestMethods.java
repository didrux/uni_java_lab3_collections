package lab1;


import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class TestMethods {

    Employee employeeFirst = new Employee.EmployeeBuilder().setName("Misha").setPosition("Receiver").setSalary(20000).setPhoneNumber("0504340601").setMedicalExamination(true).setAddress("Holovna, 1")
            .build();

    Product productFirst = new Product.ProductBuilder().setId(901).setName("Table").setPrice(5000).setCategory("Kitchen")
            .build();

    Product productSecond = new Product.ProductBuilder().setId(901).setName("Table").setPrice(1500).setCategory("Kitchen")
            .build();

    Product productThird = new Product.ProductBuilder().setId(903).setName("Sofa").setPrice(2000).setCategory("Rest")
            .build();

    Producer producerFirst = new Producer.ProducerBuilder().setName("Andrew").setProducts(Arrays.asList(productFirst, productSecond)).setAddress("Ukraine, Chernivtsi, Soborna 2")
            .build();


    @Test
    public void testSortProductsById() {
        Producer producerFirst = new Producer.ProducerBuilder().setName("Andrew").setProducts(Arrays.asList(productFirst, productSecond, productThird)).setAddress("Ukraine, Chernivtsi, Soborna 2")
                .build();

        producerFirst.sortProductsById();

        assertEquals(productFirst, producerFirst.getProducts().get(0));
        assertEquals(productSecond, producerFirst.getProducts().get(1));
        assertEquals(productThird, producerFirst.getProducts().get(2));
    }


    @Test
    public void testSortProductsByPrice() {
        Producer producerFirst = new Producer.ProducerBuilder().setName("Andrew").setProducts(Arrays.asList(productFirst, productSecond, productThird)).setAddress("Ukraine, Chernivtsi, Soborna 2")
                .build();

        producerFirst.sortProductsByPrice();

        assertEquals(productFirst, producerFirst.getProducts().get(0));
        assertEquals(productSecond, producerFirst.getProducts().get(2));
        assertEquals(productThird, producerFirst.getProducts().get(1));
    }

    @Test
    public void testSortProductsByName() {
        Producer producerFirst = new Producer.ProducerBuilder().setName("Andrew").setProducts(Arrays.asList(productFirst, productSecond, productThird)).setAddress("Ukraine, Chernivtsi, Soborna 2")
                .build();

        producerFirst.sortProductsByName();

        assertEquals(productFirst, producerFirst.getProducts().get(2));
        assertEquals(productSecond, producerFirst.getProducts().get(1));
        assertEquals(productThird, producerFirst.getProducts().get(0));
    }

}
