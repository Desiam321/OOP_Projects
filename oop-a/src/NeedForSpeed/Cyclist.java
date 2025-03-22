package NeedForSpeed;

public class Cyclist extends NoMotor {

    public Cyclist (String name, Handicap handicap, double vmax, double vavg, double acceleration, double operatingCosts, double endurance, double level, double effort){
        super(name, handicap, vavg, vmax, acceleration, operatingCosts, endurance, level, effort);

    }

    public double getTime (){
        return time - handicap.getStartDelay();
    }

    public double getDistance () {return distance;}

    public String getName () { return  name;}

    public String celebration (){return "Yeah I be beat the machines!!!";}

    public String disappointment () {return "It is impossible to compete with machines.";}

    public String toString (){
        return super.toString();
    }
}
