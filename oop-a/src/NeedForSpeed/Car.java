package NeedForSpeed;

public class Car extends Motor {

    public Car(String name, Handicap handicap, double vavg, double vmax, double acceleration, double operatingCosts,double tank, double mileage, double gasPrice) {
        super(name, handicap, vavg, vmax, acceleration, operatingCosts,tank, mileage, gasPrice);

    }

    public double getTime (){
        return time - handicap.getStartDelay();
    }

    public double getDistance () {return distance;}

    public String getName() {
        return name;
    }

    public String celebration (){return "Cars are the best vehicles!!!";}

    public String disappointment () {return "Cars will do way better next time!!!";}

    public String toString (){
        return super.toString();
    }
}
