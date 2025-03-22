package Titanic;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TitanicAnalysenTest {
    @Test
    void sortByAgeAndAlphabet() throws IOException {
        List<Ticket> tickets = TitanicStatistics.loadData();
        Ticket[] ticketArray = TitanicAnalyse.sortByAgeAndAlphabet(tickets);

        // ASSERTION TESTS

        assertEquals("Andrew  Mr Frank 2nd -1 male 0", ticketArray[0].toString(), "Verify if element at index 0 is same as expected.");
        assertEquals("Hagland  Mr Ingvald Olsen 3rd -1 male 0", ticketArray[100].toString(), "Verify if element at index 100 is same as expected.");
        assertEquals("Makinen  Mr Kalle Edvard 3rd -1 male 0", ticketArray[200].toString(), "Verify if element at index 200 is same as expected.");
        assertEquals("Odahl  Mr Nils Martin 3rd -1 male 1", ticketArray[300].toString(), "Verify if element at index 300 is same as expected.");
        assertEquals("Ryan  Mr Patrick 3rd -1 male 0", ticketArray[400].toString(), "Verify if element at index 400 is same as expected.");
        assertEquals("Todoroff  Mr Lalio 3rd -1 male 0", ticketArray[500].toString(), "Verify if element at index 500 is same as expected.");
    }

    @Test
    void sortMenByAge() throws IOException {
        List<Ticket> tickets = TitanicStatistics.loadData();
        Ticket[] ticketArray = TitanicAnalyse.sortMenByAge(tickets);

        // ASSERTIONS

        assertEquals(851, ticketArray.length, "Verify if the array of ticktes have length as expected.");
        assertEquals("Andrew  Mr Frank 2nd -1 male 0", ticketArray[0].toString(), "Verify if element at index 0 is same as expected.");
        assertEquals("Khalil  Mr Saad 3rd -1 male 0", ticketArray[100].toString(), "Verify if element at index 100 is same as expected.");
        assertEquals("Olsson  Mr Nils Johan 3rd -1 male 0", ticketArray[200].toString(), "Verify if element at index 200 is same as expected.");
        assertEquals("Sholt  Mr Peter Andreas Lauritz Andersen 3rd -1 male 0", ticketArray[300].toString(), "Verify if element at index 300 is same as expected.");
        assertEquals("Johnson  Master Harold Theodor 3rd 4 male 1", ticketArray[400].toString(), "Verify if element at index 400 is same as expected.");
        assertEquals("Johansson  Mr Erik 3rd 22 male 0", ticketArray[500].toString(), "Verify if element at index 500 is same as expected.");
    }

    @Test
    void sortChildrenByAgeAndAlphabet() throws IOException {
        List<Ticket> tickets = TitanicStatistics.loadData();
        Ticket[] ticketArray = TitanicAnalyse.sortChildrenByAgeAndAlphabet(tickets);

        // ASSERTIONS

        assertEquals(96, ticketArray.length, "Verify if length of ticket array has expected length.");
        assertEquals("Aks  Master Philip 3rd 0 male 1", ticketArray[0].toString(), "Verify if element at index 0 is same as expected.");
        assertEquals("Klasen  Miss Gertrud Emilia 3rd 1 female 0", ticketArray[10].toString(), "Verify if element at index 10 is same as expected.");
        assertEquals("Aspland  Master Edvin Rojj Felix 3rd 3 male 1", ticketArray[20].toString(), "Verify if element at index 20 is same as expected.");
        assertEquals("Carr  Miss Helen 3rd 16 female 1", ticketArray[75].toString(), "Verify if element at index 75 is same as expected.");

    }

    @Test
    void averageAgePassengers() throws IOException {
        TitanicAnalyse ta = new TitanicAnalyse();
        try {
            assertEquals(30.3915, ta.averageAgePassengers(), 0.001);
        } catch (Exception e) {
            System.out.println("Only the average age of the passengers");

        }
    }

    @Test
    void averageAgeDeceased() throws IOException {
        TitanicAnalyse ta = new TitanicAnalyse();

        assertEquals(29.348, ta.averageAgeDeceased(), 0.001);
    }

    @Test
    void numberOfPassengers() throws IOException {

        TitanicAnalyse ta = new TitanicAnalyse();

       
        assertEquals(1313, ta.numberOfPassengers());
    }




    @Test
    void percentageDeceasedPeopleInTwenties() throws IOException {
        TitanicAnalyse ta = new TitanicAnalyse();
        try{
            assertEquals(0.666, ta.percentageDeceasedPeopleInTwenties(),0.001 );
        }catch (Exception e){
            System.out.println("Only deceased people in the twenties ");
            fail();

        }
    }

    @Test
    void averageAgeMen() throws IOException {
        TitanicAnalyse ta = new TitanicAnalyse();

        assertEquals(31.00, ta.averageAgeMen(), 0.01);
    }

    @Test
    void averageAgeWomen() throws IOException {
       TitanicAnalyse ta = new TitanicAnalyse();

        assertEquals(29.39, ta.averageAgeWomen(), 0.01);
    }

    @Test
    void mostFrequentSurname() throws IOException {

        TitanicAnalyse ta = new TitanicAnalyse();


            assertEquals("Sage", ta.mostFrequentSurname(1));
            assertEquals("Andersson", ta.mostFrequentSurname(2));
            assertEquals("Goodwin", ta.mostFrequentSurname(3));
            assertEquals("Asplund", ta.mostFrequentSurname(4));


    }




    @Test
    void mostFrequentAge() throws IOException {

        TitanicAnalyse ta = new TitanicAnalyse();

        assertEquals(22, ta.mostFrequentAge(1));
        assertEquals(21, ta.mostFrequentAge(2));
        assertEquals(30, ta.mostFrequentAge(3));
        assertEquals(18, ta.mostFrequentAge(4));


    }

    @Test
    void percentageDeceasedPclass() throws IOException {

        TitanicAnalyse ta = new TitanicAnalyse();

            assertEquals(0.4006, ta.percentageDeceasedPClass("1st"), 0.01);
            assertEquals(0.575, ta.percentageDeceasedPClass("2nd"), 0.01);
            assertEquals(0.806, ta.percentageDeceasedPClass("3rd"), 0.01);

    }
}

