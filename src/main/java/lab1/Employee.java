package lab1;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Employee.EmployeeBuilder.class)
public class Employee {
    private String name;
    private String position;
    private double salary;
    private String address;
    private String phoneNumber;
    private boolean medicalExamination;

    /**
     * Employee constructor
     *
     * @param builder
     */
    private Employee(EmployeeBuilder builder) {
        this.name = builder.name;
        this.position = builder.position;
        this.salary = builder.salary;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.medicalExamination = builder.medicalExamination;
    }

    /**
     * toString
     *
     * @return class description in string format
     */
    @Override
    public String toString() {
        return "{\"name\":\"" + name + "\",\"position\":\"" + position + "\",\"salary\":\"" + salary + "\",\"address\":\"" + address + "\",\"phoneNumber\":\"" + phoneNumber + "\",\"medicalExamination\":\"" + medicalExamination + "\"}";
    }

    /**
     * hashCode
     *
     * @return hash
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Employee employee = (Employee) obj;
        return (employee.name.equals(this.name) &&
                employee.address.equals(this.address) &&
                employee.phoneNumber.equals(this.phoneNumber)
        );
    }

    /**
     * Overrided hashCode method
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 31;
        hash = 9 * hash + Objects.hashCode(this.name);
        hash = 9 * hash + Objects.hashCode(this.address);
        hash = 9 * hash + Objects.hashCode(this.phoneNumber);
        return hash;
    }

    /**
     * Implement classes via builder
     */
    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "set")
    public static class EmployeeBuilder {
        private String name;

        private String position;

        private double salary;
        private String address = " ";
        private String phoneNumber = " ";
        private boolean medicalExamination;

        /**
         * @param name
         */
        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * @param position
         * @return
         */
        public EmployeeBuilder setPosition(String position) {
            this.position = position;
            return this;
        }

        /**
         * @param salary
         * @return
         */
        public EmployeeBuilder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        /**
         * @param address
         * @return
         */
        public EmployeeBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        /**
         * @param phoneNumber
         * @return
         */
        public EmployeeBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * @param medicalExamination
         * @return
         */
        public EmployeeBuilder setMedicalExamination(boolean medicalExamination) {
            this.medicalExamination = medicalExamination;
            return this;
        }

        /**
         * @return
         */
        public Employee build() {
            return new Employee(this);
        }

    }

    /**
     * name getter
     */
    public String getName() {
        return name;
    }


    /**
     * position getter;
     */
    public String getPosition() {
        return position;
    }

    /**
     * salary getter
     */
    public double getSalary() {
        return salary;
    }

    /**
     * address getter
     */
    public String getAddress() {
        return address;
    }

    /**
     * phoneNumber getter
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * medicalExamination getter
     */
    public boolean getMedicalExamination() {
        return medicalExamination;
    }

    /**
     * name setter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * salary setter
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * phoneNumber setter
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * address setter
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * medicalExamination setter
     */
    public void setMedicalExamination(boolean medicalExamination) {
        this.medicalExamination = medicalExamination;
    }
}
