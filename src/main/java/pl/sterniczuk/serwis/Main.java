package pl.sterniczuk.serwis;

public class Main {
    public static void main(String[] args) {
        CarService car = new CarService();
        System.out.println(car.analyzeCarByParams(5,5,5));
    }
}
