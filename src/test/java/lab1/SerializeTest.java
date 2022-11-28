package lab1;

import Serialize.JsonSerializer;
import Serialize.TxtSerializer;
import Serialize.XmlSerializer;
import org.testng.annotations.Test;

import java.util.Arrays;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class SerializeTest {

    Employee employeeFirst = new Employee.EmployeeBuilder().setName("Misha").setPosition("Receiver").setSalary(20000).setPhoneNumber("0504340601").setMedicalExamination(true).setAddress("Holovna, 1")
            .build();

    Product productFirst = new Product.ProductBuilder().setId(901).setName("Table").setPrice(1500).setCategory("Kitchen")
            .build();

    Product productSecond = new Product.ProductBuilder().setId(901).setName("Table").setPrice(1500).setCategory("Kitchen")
            .build();

    List<Product> kitchenProducts = Arrays.asList(productFirst, productSecond);

    Producer producerFirst = new Producer.ProducerBuilder().setName("Andrew").setProducts(kitchenProducts).setAddress("Ukraine, Chernivtsi, Soborna 2")
            .build();

    @Test
    public void testJsonSerialization() {
        JsonSerializer json = new JsonSerializer();

        json.serialize(employeeFirst, "Employee.json");
        Employee deserializedEmployee = json.deserialize(Employee.class, "Employee.json");
        assertEquals(employeeFirst, deserializedEmployee);

        json.serialize(producerFirst, "Producer.json");
        Producer deserializedProducer = json.deserialize(Producer.class, "Producer.json");
        assertEquals(producerFirst, deserializedProducer);

        json.serialize(productFirst, "Product.json");
        Product deserializedProduct = json.deserialize(Product.class, "Product.json");
        assertEquals(productFirst, deserializedProduct);

    }

    @Test
    public void testXmlSerialization() {
        XmlSerializer xml = new XmlSerializer();

        xml.serialize(employeeFirst, "Employee.xml");
        Employee deserializedEmployee = xml.deserialize(Employee.class, "Employee.xml");
        assertEquals(employeeFirst, deserializedEmployee);

        xml.serialize(producerFirst, "Producer.xml");
        Producer deserializedProducer = xml.deserialize(Producer.class, "Producer.xml");
        assertEquals(producerFirst, deserializedProducer);

        xml.serialize(productFirst, "Product.xml");
        Product deserializedProduct = xml.deserialize(Product.class, "Product.xml");
        assertEquals(productFirst, deserializedProduct);
    }

    @Test
    public void testTxtSerialization() {
        TxtSerializer txt = new TxtSerializer();

        txt.serialize(employeeFirst, "Employee.txt");
        Employee deserializedEmployee = txt.deserialize(Employee.class, "Employee.txt");
        assertEquals(employeeFirst, deserializedEmployee);

        txt.serialize(producerFirst, "Producer.txt");
        Producer deserializedProducer = txt.deserialize(Producer.class, "Producer.txt");
        assertEquals(producerFirst, deserializedProducer);

        txt.serialize(productFirst, "Product.txt");
        Product deserializedProduct = txt.deserialize(Product.class, "Product.txt");
        assertEquals(productFirst, deserializedProduct);
    }
}
