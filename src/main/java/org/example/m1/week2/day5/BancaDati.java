package org.example.m1.week2.day5;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class BancaDati {

    private List<BaseLibreria> bancaDati;

    public BancaDati() {
        this.bancaDati = new ArrayList<>();
    }

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

        bancaDati.cancellaTramiteISBN(1L);

        System.out.println(bancaDati);

        System.out.println(bancaDati);

        System.out.println(bancaDati.ricercaTramiteISBN(4));

        System.out.println( bancaDati.ricercaTramiteAnno(1965));

        System.out.println(bancaDati.ricercaTramiteAutore("Cracco"));

    }

    public void cancellaTramiteISBN(long ISBN){
        bancaDati.removeIf(b -> b.getCodISBN() == ISBN);
        System.out.println("Elemento eliminato correttamente");
    }

    public BaseLibreria ricercaTramiteISBN(long ISBN){
        Optional<BaseLibreria> s = bancaDati.stream().filter(b -> b.getCodISBN() == ISBN).findFirst();
        return s.orElse(null);
    }

    public List<BaseLibreria> ricercaTramiteAnno(int anno){
        return bancaDati.stream().filter(a -> a.getAnnoPublicazione() == anno).collect(Collectors.toList());
    }

    public List<Libri> ricercaTramiteAutore(String autore){
        return bancaDati.stream().filter(l -> l instanceof Libri).map(Libri.class::cast).filter(a -> ((Libri) a).getAutore() == autore).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "{" +
                "bancaDati=" + bancaDati +
                '}';
    }

    private boolean codISBNPresente(long codISBN) {
        return bancaDati.stream().anyMatch(b -> b.getCodISBN() == codISBN);
    }

    private long generaNuovoCodISBN() {
        Random random = new Random();
        long nuovoCodISBN;
        do {
            nuovoCodISBN = random.nextLong();
        } while (codISBNPresente(nuovoCodISBN));
        return nuovoCodISBN;
    }


    public Libri creaLibro(String titolo, int annoPublicazione, int numPagine, String autore, Genere ...genere){
        long codISBN = generaNuovoCodISBN();

        Libri nuovoLibro = new Libri(codISBN,titolo,annoPublicazione,numPagine,autore,genere);

        System.out.println("Libro creato correttamente.");

        bancaDati.add(nuovoLibro);

        return nuovoLibro;

    }

    public Riviste creaRivista(String titolo, int annoPublicazione, int numPagine, Periodicita periodicita){
        long codISBN = generaNuovoCodISBN();

        Riviste nuovaRivista = new Riviste(codISBN,titolo,annoPublicazione,numPagine,periodicita);

        System.out.println("Rivista creata correttamente.");

        bancaDati.add(nuovaRivista);

        return nuovaRivista;

    }

    public static void salvaSuDisco(List<BaseLibreria> prodotti) throws IOException {
        File out = new File("output/lista.txt");

        String stringaCatalogo = prodotti.stream()
                .map(p -> {
                    if (p instanceof Libri) {
                        Libri libro = (Libri) p;
                        return libro.getTitolo() +
                                "@" + libro.getCodISBN() +
                                "@" + libro.getAnnoPublicazione() +
                                "@" + libro.getNumPagine() +
                                "@" + libro.getAutore() +
                                "@" + libro.getGenere().stream().map(Enum::name).collect(Collectors.joining(","));
                    } else {
                        return p.getTitolo() +
                                "@" + p.getCodISBN() +
                                "@" + p.getAnnoPublicazione() +
                                "@" + p.getNumPagine();
                    }
                })
                .collect(Collectors.joining("#"));

        FileUtils.writeStringToFile(out, stringaCatalogo, Charset.defaultCharset());
    }



}
