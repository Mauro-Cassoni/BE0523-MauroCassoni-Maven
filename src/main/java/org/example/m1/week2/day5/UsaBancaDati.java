package org.example.m1.week2.day5;

public class UsaBancaDati extends BancaDati{

    public static void main(String[] args) {

        BancaDati bancaDati = new BancaDati();


        Libri libro1 = bancaDati.creaLibro( "LOTR La Compagnia dell'Anello",1955,500,"J. R. R. Tolkien",Genere.ROMANZO,Genere.FANTASY);
        Libri libro2 = bancaDati.creaLibro( "LOTR La Compagnia del cappero",1965,500,"J. R. R. Tolkien",Genere.HORROR,Genere.FANTASY);
        Libri libro3 = bancaDati.creaLibro( "LR pizza",2020,500,"Cracco",Genere.HORROR,Genere.FANTASY);
        Libri libro4 = bancaDati.creaLibro( "LR pizza romana",2023,500,"Cracco",Genere.HORROR,Genere.FANTASCIENZA);

        Riviste rivista1 = bancaDati.creaRivista("Rivista interessante",2023,57,Periodicita.MENSILE);
        Riviste rivista2 = bancaDati.creaRivista("Rivista poco interessante",2021,72,Periodicita.SETTIMANALE);
        Riviste rivista3 = bancaDati.creaRivista("Rivista abbastanza interessante",2020,29,Periodicita.SEMESTRALE);
        Riviste rivista4 = bancaDati.creaRivista("Rivista non interessante",2024,10,Periodicita.SETTIMANALE);


        System.out.println(rivista1.toString());

        System.out.println(bancaDati);

        System.out.println( bancaDati.ricercaTramiteAnno(1965));

        System.out.println(bancaDati.ricercaTramiteAutore("Cracco"));

    }

}
