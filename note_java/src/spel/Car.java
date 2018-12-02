package spel;

public class Car {
    private String brand;
    private double price;
    private double tirePerimeter;

    public Car() {
        System.out.println("car's constructor...........");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTirePerimeter() {
        return tirePerimeter;
    }

    public void setTirePerimeter(double tirePerimeter) {
        this.tirePerimeter = tirePerimeter;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", tirePerimeter=" + tirePerimeter +
                '}';
    }
}
