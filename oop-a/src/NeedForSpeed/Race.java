package NeedForSpeed;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Race {
    private String name;
    private int racetype; // 1 = DragRace, 2 = Race with flying start, 3 = Race with normal start
    private int distance;
    private double time;
    private List<Car> cars;
    private List<Truck> trucks;
    private List<Motorcycle> motorcycles;
    private List<Cavalier> cavaliers;
    private List<Cyclist> cyclists;


    public Race (String name, int racetype, int distance){
        this.name = name;
        this.racetype = racetype;
        this.distance = distance;
        this.time = 0;
        trucks = new LinkedList<Truck>();
        motorcycles = new LinkedList<Motorcycle>();
        cavaliers = new LinkedList<Cavalier>();
        cyclists = new LinkedList<Cyclist>();
        cars = new LinkedList<Car>();
    }

    public Race (String name, int racetype, double time){
        this.name = name;
        this.racetype = racetype;
        this.distance = 0;
        this.time = time;
        trucks = new LinkedList<Truck>();
        motorcycles = new LinkedList<Motorcycle>();
        cavaliers = new LinkedList<Cavalier>();
        cyclists = new LinkedList<Cyclist>();
        cars = new LinkedList<Car>();
    }

    public String getName() {
        return name;
    }



    public void addParticipant (Object participant){
        Car c = new Car(" ",new Handicap(0,0,0,0,0,0),0,0,0,0,0,0,0);
        Truck t = new Truck(" ",new Handicap(0,0,0,0,0,0),0,0,0,0,0,0,0);
        Motorcycle m = new Motorcycle(" ",new Handicap(0,0,0,0,0,0),0,0,0,0,0,0,0);
        Cavalier ca = new Cavalier(" ",new Handicap(0,0,0,0,0,0),0,0,0,0,0,0,0);
        Cyclist cy = new Cyclist(" ",new Handicap(0,0,0,0,0,0),0,0,0,0,0,0,0);

        if (participant.getClass().isInstance(c)){
            cars.add((Car)participant);
        } else if (participant.getClass().isInstance(t)){
            trucks.add((Truck)participant);
        } else if (participant.getClass().isInstance(m)){
            motorcycles.add((Motorcycle) participant);
        } else if (participant.getClass().isInstance(ca)){
            cavaliers.add((Cavalier) participant);
        } else if (participant.getClass().isInstance(cy)){
            cyclists.add((Cyclist) participant);
        } else {

        }
    }

    public void start (){
        switch (racetype){
            case 1: // Drag Race
                if (this.distance == 0) {
                    for (Car c : cars) {
                        if (c.dragDistance(this.time) == 0){
                            System.out.println("Time to short for this car.");
                        };
                    }
                    for (Truck t : trucks) {
                        if (t.dragDistance(this.time) == 0){
                            System.out.println("Time to short for this truck.");
                        };
                    }
                    for (Motorcycle m : motorcycles) {
                        if (0 == m.dragDistance(this.time)){
                            System.out.println("Time to short for this motorcyle.");
                        };
                    }
                    for (Cavalier ca : cavaliers) {
                        if ( 0 == ca.dragDistance(this.time)) {
                            System.out.println("Time to short for this cavalier.");
                        };
                    }
                    for (Cyclist cy : cyclists) {
                        if (0 == cy.dragDistance(this.time)){
                            System.out.println("Time to short for this cyclist.");
                        };
                    }
                } else {
                    for (Car c : cars) {
                        if (c.dragTime(this.distance) == 0){
                            System.out.println("Distance to short for this car.");
                        };
                    }
                    for (Truck t : trucks) {
                        if (t.dragTime(this.distance) == 0){
                            System.out.println("Distance to short for this truck.");
                        };
                    }
                    for (Motorcycle m : motorcycles) {
                        if (0 == m.dragTime(this.distance)){
                            System.out.println("Distance to short for this motorcyle.");
                        };
                    }
                    for (Cavalier ca : cavaliers) {
                        if ( 0 == ca.dragTime(this.distance)) {
                            System.out.println("Distance to short for this cavalier.");
                        };
                    }
                    for (Cyclist cy : cyclists) {
                        if (0 == cy.dragTime(this.distance)){
                            System.out.println("Distance to short for this cyclist.");
                        };
                    }
                }
                break;
            case 2: // Race with flying start
                if (this.distance == 0) {
                    for (Car c : cars) {
                        c.driveTime(this.time);
                    }
                    for (Truck t : trucks) {
                        t.driveTime(this.time);
                    }
                    for (Motorcycle m : motorcycles) {
                        m.driveTime(this.time);
                    }
                    for (Cavalier ca : cavaliers) {
                        ca.driveTime(this.time);
                    }
                    for (Cyclist cy : cyclists) {
                        cy.driveTime(this.time);
                    }
                } else {
                    for (Car c : cars) {
                        c.driveDistance(this.distance);
                    }
                    for (Truck t : trucks) {
                        t.driveDistance(this.distance);
                    }
                    for (Motorcycle m : motorcycles) {
                        m.driveDistance(this.distance);
                    }
                    for (Cavalier ca : cavaliers) {
                        ca.driveDistance(this.distance);
                    }
                    for (Cyclist cy : cyclists) {
                        cy.driveDistance(this.distance);
                    }
                }
                break;
            case 3: // Race with normal start
                if (this.distance == 0) {
                    for (Car c : cars) {
                        c.distance(this.time);
                    }
                    for (Truck t : trucks) {
                        t.distance(this.time);
                    }
                    for (Motorcycle m : motorcycles) {
                        m.distance(this.time);
                    }
                    for (Cavalier ca : cavaliers) {
                        ca.distance(this.time);
                    }
                    for (Cyclist cy : cyclists) {
                        cy.distance(this.time);
                    }
                } else {
                    for (Car c : cars) {
                        c.time(this.distance);
                    }
                    for (Truck t : trucks) {
                        t.time(this.distance);
                    }
                    for (Motorcycle m : motorcycles) {
                        m.time(this.distance);
                    }
                    for (Cavalier ca : cavaliers) {
                        ca.time(this.distance);
                    }
                    for (Cyclist cy : cyclists) {
                        cy.time(this.distance);
                    }
                }
                break;
            default:
                System.out.println("Error, incorrect racetype");
                break;
        }
    }

    // implement the method placement
    public void placement () {
        LinkedList<Raceable> place = new LinkedList<>();

        for (Car c: cars) {
            place.add(c);
        }

        for (Truck t: trucks) {
            place.add(t);
        }

        for (Cavalier e: cavaliers) {
            place.add(e);
        }
        
        for (Motorcycle m: motorcycles) {
            place.add(m);
        }

        for (Cyclist q: cyclists) {
            place.add(q);
        }

        place.sort(((o1, o2) -> (int) ((int) o1.time-o2.time)));

        int placements = 1;
        for (int i = 0; i < place.size(); i++) {

            if (i <= 2) {
                System.out.println(place.get(i).name + " got "+ placements +". Place:"+ " \""+ place.get(i).celebration()+"\"");
                placements++;
            } else {
                System.out.println(place.get(i).name + " got "+ placements+ ". Place:"+" \""+ place.get(i).disappointment()+"\"");
                placements++;
            }
        }
        System.out.println("\n");
    }

    public String toString () {
        StringBuilder s = new StringBuilder();
        String string;
        if (this.distance == 0){
            string = " Race for the time: "+ time + " s\n";
        } else
            string = " Race of the distance: "+ distance + " m\n";

        s.append("Racename: " + name + "\t" + string);
        for (Car c : cars) {
            s.append(c.toString());
        }
        for (Truck t : trucks) {
            s.append(t.toString());
        }
        for (Motorcycle m : motorcycles) {
            s.append(m.toString());
        }
        for (Cavalier ca : cavaliers) {
            s.append(ca.toString());
        }
        for (Cyclist cy : cyclists) {
            s.append(cy.toString());
        }
        return s.toString();
    }

    public void reset (){
        for (Car c : cars) {
            c.reset();
        }
        for (Truck t : trucks) {
            t.reset();
        }
        for (Motorcycle m : motorcycles) {
            m.reset();
        }
        for (Cavalier ca : cavaliers) {
            ca.reset();
        }
        for (Cyclist cy : cyclists) {
            cy.reset();
        }
    }

    public void addParticipants(Car audi, Truck man, Motorcycle bmw, Cavalier cacer, Cyclist cyclist) {
        addParticipant(audi);
        addParticipant(man);
        addParticipant(bmw);
        addParticipant(cacer);
        addParticipant(cyclist);
    }

    public void doRace() {
        start();
        System.out.println(toString());
        placement();
        reset();
    }


}
