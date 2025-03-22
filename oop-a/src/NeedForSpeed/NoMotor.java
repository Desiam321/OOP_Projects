package NeedForSpeed;

public abstract class NoMotor extends Raceable {

    protected double endurance;
    protected double effort;



    public NoMotor(String name, Handicap handicap, double vavg, double vmax, double acceleration, double operatingCosts, double endurance, double level, double effort) {
        super(name, handicap, vavg, vmax, acceleration, operatingCosts);
        this.endurance = endurance * handicap.getEndurance();
        this.level = level;
        this.effort = effort/100000;


    }

    public int refuelNumber (double distance) {
        return (int)(level / effort)+1;
    }

    public void rest() {
        this.level = endurance;
    }

    public double range (){
        return level/effort;
    }

    public double driveDistance (double distance){
        double range = range();
        while (distance > 0){
            if (distance > range) {
                this.distance += range;
                this.time += range / vavg;
                distance -= range;
                rest();
                this.time += 3600;
            } else {
                this.distance += distance;
                this.time += distance / vavg;
                break;
            }
            time += accelerationTime();
            distance -= accelerationDistance();
            this.distance += accelerationDistance();
        }
        this.time -= handicap.getStartDelay();
        return time;
    }

    public double driveTime (double time){
        double rangetime = 0;
        double range = 0;
        while (time != 0){
            rangetime = rangeTime(time);
            range = range();
            if (rangetime > range) {
                this.distance += range;
                this.time += range / vavg;
                rest();
                this.time += 3600;
            } else {
                this.time += time;
                this.distance += time * vavg;
                break;
            }
            this.distance += accelerationDistance();
            this.time += accelerationTime();
            time -= accelerationTime();
        }
        this.distance += handicap.getLead();
        return distance;
    }

    public double distance (double time){
        double rangetime = 0;
        double range = 0;
        while (time != 0){
            this.distance += accelerationDistance();
            this.time += accelerationTime();
            time -= accelerationTime();
            rangetime = rangeTime(time);
            range = range();
            if (rangetime > range) {
                this.distance += range;
                this.time += range / vavg;
                rest();
                this.time += 3600;
            } else {
                this.time += time;
                this.distance += time * vavg;
                break;
            }
        }
        this.distance += handicap.getLead();
        return distance;
    }

    public double time (double distance){
        double range = range();
        while (distance > 0){
            time += accelerationTime();
            distance -= accelerationDistance();
            this.distance += accelerationDistance();
            if (distance > range) {
                this.distance += range;
                this.time += range / vavg;
                distance -= range;
                rest();
                this.time += 3600;
            } else {
                this.distance += distance;
                this.time += distance / vavg;
                break;
            }
        }
        this.time -= handicap.getStartDelay();
        return this.time;
    }


    public double costs (){
        this.costs = distance * operatingCosts;
        return costs;
    }

    public void reset (){
        this.time = 0;
        this.distance = 0;
        this.costs = 0;
        if (handicap.getEndurance() == 0){
            rest();
        } else {
            this.level = endurance * handicap.getEndurance();
        }
    }

    public void setHandicapFull (Handicap handicap) {
        this.handicap = handicap;
        this.vavg = vavg * handicap.getvLimitation();
        this.acceleration = acceleration * handicap.getAccelerationLimitation();
        this.endurance = endurance * handicap.getEndurance();
        this.level = endurance * handicap.getEndurance();
    }


    public String toString() {
        return super.toString() + "Costs:" + costs() + " Euro\n\n";
    }
}
