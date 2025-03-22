package NeedForSpeed;

public class Motorcycle extends Motor {

    public Motorcycle (String name, Handicap handicap, double vavg, double vmax, double acceleration, double operatingCosts,double tank, double mileage, double gasPrice){
    	super(name, handicap, vavg, vmax, acceleration, operatingCosts,tank, mileage, gasPrice);
    }

    public double getTime (){
        return time - handicap.getStartDelay();
    }

    public double getDistance () {return distance;}

    public String getName() {
        return name;
    }

    public String celebration (){return "VROOM VROOM! My Motorcycles gets all the girls UwU~";}

    public String disappointment () {return "ÙwÚ senpai will be so disappointed... I'm so sowwy lord cawwio 34 OwO~";}

    public String toString (){
        return super.toString();
    }
}
