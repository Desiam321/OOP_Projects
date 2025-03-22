package NeedForSpeed;

public abstract class Motor extends Raceable {

    protected double tank;
    protected final double mileage;
    protected final double gasPrice;

    public Motor(String name, Handicap handicap, double vavg, double vmax, double acceleration, double operatingCosts, double tank, double mileage, double gasPrice) {
        super(name, handicap, vavg, vmax, acceleration, operatingCosts);
        this.tank = tank * handicap.getTankLimitation();
        this.mileage = mileage/100000;
        this.gasPrice = gasPrice;
        this.level = tank * handicap.getTankLimitation();
    }

    public int refuelNumber (double distance) {
        return (int)(this.level / mileage)+1;
    }

    public void refuel () {
        this.level = tank;
    }

    public double range (){
        return this.level/mileage;
    }

    public double driveDistance (double distance1){
        double range = range();

        while (distance > 0){
            if (distance > range) {
                distance += range;
                time += range / this.vavg;
                distance -= range;
                refuel();
                time+= 600;
            } else {
                distance += distance1;
                time += distance1 / this.vavg;
                break;
            }
            time += accelerationTime();
            distance -= accelerationDistance();
            distance += accelerationDistance();
        }
        time -= handicap.getStartDelay();
        return time;
    }

    public double driveTime (double time1){
        double rangetime = 0;
        double range = 0;
        while (time1 != 0){
            rangetime = rangeTime(time);
            range = range();
            if (rangetime > range) {
                distance += range;
                time += range / this.vavg;
                refuel();
                time += 600;
            } else {
                time += time1;
                distance += time1 * this.vavg;
                break;
            }
            distance += accelerationDistance();
            time += accelerationTime();
            time1 -= accelerationTime();
        }
        distance += handicap.getLead();
        return distance;
    }

    public double distance (double time1){
        double rangetime = 0;
        double range = 0;
        while (time1 != 0){
            distance += accelerationDistance();
            time += accelerationTime();
            time1 -= accelerationTime();
            rangetime = rangeTime(time1);
            range = range();
            if (rangetime > range) {
                distance += range;
                time += range /this.vavg;
                refuel();
                time += 600;
            } else {
                time += time1;
                distance += time1 * this.vavg;
                break;
            }
        }
        distance += handicap.getLead();
        return distance;
    }

    public double time (double distance1){
        double range = range();
        while (distance1 > 0){
            time += accelerationTime();
            distance1 -= accelerationDistance();
            distance += accelerationDistance();
            if (distance1 > range) {
                distance += range;
                time += range / this.vavg;
                distance1 -= range;
                refuel();
                time += 600;
            } else {
                distance += distance1;
                time += distance1 / this.vavg;
                break;
            }
        }
        time -= handicap.getStartDelay();
        return time;
    }


    public double costs(double gasPrice){

        costs = distance * mileage * gasPrice + distance * this.operatingCosts;
        return costs;
    }

    public void reset (){
        this.time = 0;
        this.distance =0;
        this.costs=0;
        if (handicap.getTankLimitation() == 0){
            refuel();
        } else {
            this.level = tank * handicap.getTankLimitation();
        }
    }

    public void setHandicapFull (Handicap handicap) {
        this.handicap = handicap;
        this.vavg = this.vavg*handicap.getvLimitation();
        this.acceleration = this.acceleration*handicap.getAccelerationLimitation();
        this.tank = tank * handicap.getTankLimitation();
        this.level = tank * handicap.getTankLimitation();
    }

    public String toString() {
        return super.toString() + "Costs:" + costs(this.gasPrice) + " Euro\n\n";
    }


}
