package builder;

public class Car {

    private String carType;
    private String carModel;
    private int weight;

    private Car(String carType, String carModel, int weight) {
        this.carType = carType;
        this.carModel = carModel;
        this.weight = weight;
    }

    private Car() {
        this.carType = "carType";
        this.carModel = "carModel";
        this.weight = 1000;
    }

    public static Builder getBuilder (){
        return new Builder();
    }

    @Override
    public String toString() {
        return "{" +
                "carModel=" + carModel + "; " +
                "carType=" + carType  + "; " +
                "carWeight=" + weight  + "; " +
                '}';
    }

    public static class Builder {

        private Car newCar;

        public Builder(String carType, String carModel, int weight) {
            this.newCar = new Car (carType, carModel, weight);
        }

        public Builder() {
            this.newCar = new Car ();
        }

        public Builder(Car newCar) {
            this.newCar = newCar;
        }

        public Builder buildCarType (String carType){
            newCar.carType = carType;
            return this;
        }

        public Builder buildCarModel (String carModel){
            newCar.carModel = carModel;
            return this;
        }

        public Builder buildWeight (int weight){
            newCar.weight = weight;
            return this;
        }

        Car build () {
            return newCar;
        }

    }
}
