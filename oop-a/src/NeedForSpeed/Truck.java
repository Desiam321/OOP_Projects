package NeedForSpeed;

public class Truck extends Motor {

    public Truck(String name, Handicap handicap, double vavg, double vmax, double acceleration, double operatingCosts,double tank, double mileage, double gasPrice) {
        super(name, handicap, vavg, vmax, acceleration, operatingCosts,tank, mileage, gasPrice);

    }
    public double getTime (){
        return time - handicap.getStartDelay();
    }

    public double getDistance () {return distance;}

    public String getName() {
        return name;
    }

    public String celebration (){return "Trucks are the best vehicles!!!";}

    public String disappointment () {return "Trucks will do way better next time!!!";}

    public String toString (){
        return super.toString();
    }
}



