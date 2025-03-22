package NeedForSpeed;

public abstract class Raceable {

    protected final String name;
    protected Handicap handicap;
    protected double vavg;
    protected final double vmax;
    protected double acceleration;
    protected final double operatingCosts;
    protected double time;
    protected double distance;
    protected double costs;
    protected double level;


    public Raceable(String name, Handicap handicap, double vavg, double vmax, double acceleration, double operatingCosts) {
        this.name = name;
        this.handicap = handicap;
        if (vavg > 200){
            this.vavg = 200;
        } else {
            this.vavg = vavg * handicap.getvLimitation();
        }
        this.vmax = vmax;
        if (acceleration > 28){
            this.acceleration = 28;
        } else {
            this.acceleration = acceleration * handicap.getAccelerationLimitation();
        }
        this.operatingCosts = operatingCosts/1000;
        this.time = 0;
        this.distance = handicap.getLead();
    }


    public double accelerationDistance (){
        double time = vavg/acceleration;
        return time * time * 0.5 * acceleration;
    }

    public double accelerationTime (){
        return vavg/acceleration;
    }

    public double accelerationVmaxDistance (){
        double time = vmax/acceleration;
        return time * time * 0.5 * acceleration;
    }

    public double accelerationVmaxTime (){
        return vmax/acceleration;
    }

    public double rangeTime (double time){ // Weg der bei voller Fahrt auf die restliche Strecke zustande kommt
        return vavg * time;
    }

    public abstract double range ();

    public abstract double driveDistance (double distance);

    public abstract double driveTime (double time);

    public abstract double distance (double time);

    public abstract  double time (double distance);

    public abstract String celebration ();
    public abstract String disappointment ();

    public double dragDistance (double time) { // DragRace time if realisic else 0
        if (accelerationVmaxTime()<time){
            return 0;
        } else {
            this.time = time;
            double distance = 0.5 * acceleration * time * time;
            this.distance += distance;
            return distance;
        }
    }

    public double dragTime (double distance) { // DragRace distance if realisic else 0
        if (accelerationVmaxDistance()<distance){
            return 0;
        } else {
            this.distance = distance;
            this.time = Math.sqrt((2 * distance) / acceleration) - handicap.getStartDelay();
            return time;
        }
    }

    public abstract  void reset ();

    public abstract void setHandicapFull (Handicap handicap);

    public String toString(){
        int hours = 0;
        int minutes = 0;
        double sec = 0;
        String time;
        if (this.time > 3600){
            sec = this.time % 3600;
            hours = (int)(this.time / 3600);
            minutes = (int)(sec / 60);
            sec = sec % 60;
            time = hours + " h " + minutes + " min " + sec + " s ";
        } else {
            minutes = (int)(this.time / 60);
            sec = this.time % 60;
            time = minutes + " min " + sec + " s ";
        }
        String distance;
        if (this.distance > 1000){
            distance = this.distance/1000 + " km ";
        } else {
            distance = this.distance + " m ";
        }

        return  name + "\nTime: "+ time +"\tDistance: "+ distance;

    }

}


