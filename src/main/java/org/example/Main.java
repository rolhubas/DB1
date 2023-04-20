package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

       // Airport oro1 = new Airport("Vilniaus2","šalia ikea", "Vilnius");
        // update reikalingas ID
        Airport oro1 = new Airport(2,"Vilniaus55","šalia ikea 56", "Vil");

      //  AirportDAO.create(oro1);
        ArrayList<Airport> airports = AirportDAO.searchByAirportName("Kauno");
        if(airports.isEmpty()){
            System.out.println("Nieko nerasta");
        }else {
            System.out.println(airports.get(0));
        }

       // AirportDAO.update(oro1);
      //  AirportDAO.delete(2);

    }
}
//TODO 1.1. Pasinaudoti jau sukurta lentele 'sb_airports'.
// 1.2. Sukurti klase Airport.
// 1.3. Main klasėje sukurti naują Airport objektą.
// 1.4. Išsaugoti įrašą db.
// 1.5. Atlikti paiešką pagal oro uosto pavadinimą.
// 1.6. Paredaguoti esamą įrašą.
// 1.7. Ištrinti esamą įrašą pagal įrašo id.
// 1.8. Parašyti JUnit CRUD testus DAO klasei.
