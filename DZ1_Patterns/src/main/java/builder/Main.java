package builder;

public class Main {

    public static void main(String[] args) {
          Car MyCar = Car.getBuilder().buildCarModel("Ford").buildWeight(100).build();
          System.out.println(MyCar);
    }

}
