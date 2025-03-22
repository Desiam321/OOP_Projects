package NeedForSpeed;

public class Cavalier extends NoMotor{

    public Cavalier (String name, Handicap handicap, double vmax, double vavg, double acceleration, double operatingCosts, double endurance, double level, double effort){
        super(name, handicap, vavg, vmax, acceleration, operatingCosts, endurance, level, effort);

    }

    public double getTime (){
        return time - handicap.getStartDelay();
    }

    public double getDistance () {return distance;}

    public String getName () { return  name;}

    public String celebration (){return "My horse is the best one in the world!!!";}

    public String disappointment () {return "We had no chance.";}

    public String toString (){
        return super.toString();
    }
}
