package Titanic;

import java.io.IOException;
import java.util.*;

public class TitanicAnalyse {

    private List<Ticket> tickets = new LinkedList<>();

    public TitanicAnalyse() throws IOException {
        this.tickets = TitanicStatistics.loadData();
    }


    //sorts the most frequent Surnames and returns the position you want

    public String mostFrequentSurname(int rank) {
        HashMap<String, Integer> MapOfSurnames = new HashMap<>();

        if (rank == 0) {
            throw new NoSuchElementException("1 is the highest rank");
        }

        for (Ticket t : tickets) {
            if (!MapOfSurnames.containsKey(t.getSurname())) {
                MapOfSurnames.put(t.getSurname(), 1);
            } else {
                int i = MapOfSurnames.get(t.getSurname());
                MapOfSurnames.replace(t.getSurname(), ++i);
            }
        }

        LinkedList<String> surnamesList = new LinkedList<>(MapOfSurnames.keySet());
        surnamesList.sort((o1, o2) -> MapOfSurnames.get(o2) - MapOfSurnames.get(o1));

        return surnamesList.get(rank - 1);
    }

    //sorts the most frequent Ages and returns the position you want

    public int mostFrequentAge(int rank) {
        HashMap<Integer, Integer> MapOfAges = new HashMap<>();


        for (Ticket t : tickets) {
            if (!MapOfAges.containsKey(t.getAge()) && t.getAge() != -1) {
                MapOfAges.put(t.getAge(), 1);
            } else if (!(t.getAge() == -1)) {
                int i = MapOfAges.get(t.getAge());
                MapOfAges.replace(t.getAge(), ++i);
            }
        }

        LinkedList<Integer> ageList = new LinkedList<>(MapOfAges.keySet());
        ageList.sort((o1, o2) -> (MapOfAges.get(o2) - MapOfAges.get(o1)));


        return ageList.get(rank - 1);
    }


    //calculates the percentage of deceased of each PClass

    public double percentageDeceasedPClass(String pClass) {
        LinkedList<Ticket> deceased = new LinkedList<>();
        LinkedList<Ticket> alive = new LinkedList<>();

            for (Ticket t : tickets) {
                if (t.getPclass().compareTo(pClass) == 0) {
                    if (t.getSurvived() == 1) {
                        alive.add(t);
                    } else {
                        deceased.add(t);
                    }
                }
            }

            double deacesedSize = deceased.size();
            double aliveSize = alive.size();

            return deacesedSize / (aliveSize + deacesedSize);
    }

     public double averageAgePassengers() {
        int passengers = 0;
         int totalAge = 0;
         for (Ticket t : tickets) {
             if (t.getAge() != -1) {
                 passengers++;
                 totalAge += t.getAge();
             }

         }
         double averageAge = (double) totalAge / (double) passengers;

         return averageAge;

     }


    public double percentageDeceasedPeopleInTwenties() {
        LinkedList<Ticket> deceased = new LinkedList<>();
        LinkedList<Ticket> alive = new LinkedList<>();

        for (Ticket t : tickets) {
            if (t.getAge() != -1 && t.getAge() > 19 && t.getAge() < 30) {
                if (t.getSurvived() == 0) {
                    deceased.add(t);
                } else
                    alive.add(t);
            }

        }
        double deceasedSize = deceased.size();
        double aliveSize = alive.size();

        return deceasedSize / (aliveSize + deceasedSize);

    }
    public int numberOfPassengers(){
        return tickets.size();
    }

    public static Ticket[] sortByAgeAndAlphabet(List<Ticket> tickets) {
        Ticket[] ticketArray = new Ticket[tickets.size()];
        tickets.toArray(ticketArray);
        int n = ticketArray.length;
        Ticket temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(ticketArray[j-1].compareTo(ticketArray[j]) < 0){
                    temp = ticketArray[j-1];
                    ticketArray[j-1] = ticketArray[j];
                    ticketArray[j] = temp;
                }
            }
        }
        return ticketArray;
    }

    public static Ticket[] sortMenByAge(List<Ticket> tickets) {
        List<Ticket> allMen = new LinkedList<>();
        for (Ticket t: tickets){
            if (t.getSex().compareTo("male") == 0){
                allMen.add(t);
            }
        }

        Ticket[] ticketArray = new Ticket[allMen.size()];
        allMen.toArray(ticketArray);
        int n = ticketArray.length;
        Ticket temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(ticketArray[j-1].compareTo(ticketArray[j]) < 0){
                    temp = ticketArray[j-1];
                    ticketArray[j-1] = ticketArray[j];
                    ticketArray[j] = temp;
                }
            }
        }
        return ticketArray;
    }

    public static Ticket[] sortChildrenByAgeAndAlphabet(List<Ticket> tickets) {
        List<Ticket> children = new LinkedList<>();
        for (Ticket t: tickets){
            if (t.getAge()>-1 && t.getAge()<18 ){
                children.add(t);
            }
        }

        Ticket[] ticketArray = new Ticket[children.size()];
        children.toArray(ticketArray);
        int n = ticketArray.length;
        Ticket temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(ticketArray[j-1].compareTo(ticketArray[j]) < 0){
                    temp = ticketArray[j-1];
                    ticketArray[j-1] = ticketArray[j];
                    ticketArray[j] = temp;
                }
            }
        }
        return ticketArray;

        public double averageAgeMen() throws IOException {
        List<Ticket> tickets = TitanicStatistics.loadData();
        int men = 0;
        int totalAge = 0;
        for (Ticket t : tickets) {
            if (t.getAge() != -1 && Objects.equals(t.getSex(), "male")) {
                men++;
                totalAge += t.getAge();
            }
        }
        double averageAgeMen = (double) totalAge / (double) men;

        return averageAgeMen;
    }
        public double averageAgeWomen() throws IOException {
            List<Ticket> tickets = TitanicStatistics.loadData();
            int women = 0;
            int totalAgewomen = 0;
            for (Ticket t : tickets) {
                if (t.getAge() != -1 && Objects.equals(t.getSex(), "female")) {
                    women++;
                    totalAgewomen += t.getAge();
                }
            }
            double averageAgewomen = (double) totalAgewomen / (double) women;


            return averageAgewomen;
        }
    double averageAgeDeceased() throws IOException {
    List<Ticket> tickets = TitanicStatistics.loadData();
    int passengers = 0;
    int totalAgedec = 0;
        for (Ticket t: tickets){
        if (t.getAge()!=-1 && t.getSurvived()==1){
            passengers++;
            totalAgedec += t.getAge();
        }
    }
    double averageAgedec = (double)totalAgedec / (double)passengers;
return averageAgedec;
}
   }
}
