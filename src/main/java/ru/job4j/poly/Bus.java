package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Максимально разрешенная скорость 90 км/ч");
    }

    @Override
    public void passengers(int quantity) {
        System.out.println(quantity);
    }

    @Override
    public double refuel(int fuel) {
        double literPrice = 52;
        return fuel * literPrice;
    }
}
