package NeedForSpeed;

public class NeedForSpeed {
    public static void main (String[] args){

        Handicap c = new Handicap(1,1,1,1,0,0);
        Car audi = new Car ("Audi", c, 48,24, 5, 0.2, 100,  50, 2.01);

        Handicap t = new Handicap(1,1,1,10,0,0);
        Truck man = new Truck ("MAN", t, 34,19, 3, 0.4, 150, 26,1.90);

        Handicap m = new Handicap(1,1,1,10,0,0);
        Motorcycle bmw = new Motorcycle ("BMW", m, 50,26, 6, 0.1, 50,  7, 2.30);

        Handicap ca = new Handicap(1,1,1,1,0,0);
        Cavalier werth = new Cavalier ("Isabell Werth", ca, 20,8, 7, 0.008, 100, 100, 25);

        Handicap cy = new Handicap(1,1,1,1,0,0);
        Cyclist lance = new Cyclist ("Lance Armstrong", cy , 17,11, 5, 0.01, 100, 100, 15);

        Race r = new Race ("DragRace on distance", 1, 20);
        r.addParticipants(audi, man, bmw, werth, lance);

        r.doRace();

        Race r1 = new Race ("DragRace on time", 1, 2.5);
        r1.addParticipants(audi, man, bmw, werth, lance);

        r1.doRace();

        Race r2 = new Race ("Race with flying start on distance", 2, 8000);
        r2.addParticipants(audi, man, bmw, werth, lance);

        r2.doRace();

        Race r3 = new Race ("Race with flying start on time", 2, 3600.0);
        r3.addParticipants(audi, man, bmw, werth, lance);

       r3.doRace();

        Race r4 = new Race ("Normal Race on distance", 3, 8000);
        r4.addParticipants(audi, man, bmw, werth, lance);

        r4.doRace();

        Race r5 = new Race ("Normal Race on Time", 3, 3600.0);
        r5.addParticipants(audi, man, bmw, werth, lance);

        r5.doRace();

        Handicap carAndTruck = new Handicap(0.5,1,0.7,1,0,0);
        Handicap cyclistAndCavalier = new Handicap(1,1,1,0.8,36000,0);

        lance.setHandicapFull(cyclistAndCavalier);
        werth.setHandicapFull(cyclistAndCavalier);
        audi.setHandicapFull(carAndTruck);
        man.setHandicapFull(carAndTruck);

        r4.doRace();
    }

}
