package org.example;

import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.Driver;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import com.sun.jdi.connect.spi.Connection;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArrayList<Aposta> listaApostas;

    }

    public static void iniciarApostas() {
        File arquivo = new File("apostas.csv");
        System.out.println("Uma nova rodada está prestes a começar!!");

    }

    public static ArrayList<Aposta> criarAposta() {
        Scanner in = new Scanner(System.in);
        ArrayList<Aposta> listaApostas = new ArrayList<>();
        System.out.println("Digite seu nome: ");
        String nome = in.nextLine();
        System.out.println("Digite seu CPF: ");
        String cpf = in.nextLine();
        ArrayList<Integer> vetor = new ArrayList<Integer>();
        System.out.println("Digite os 5 números da sua aposta:");
        for (int i = 0; i < 5; i++) {
            int valor = in.nextInt();
            vetor.add(valor);
        }
        Aposta aposta = new Aposta(vetor, nome, cpf);
        salvarAposta(aposta);
        return listaApostas;
    }


    public static void salvarAposta(Aposta aposta) {
        try {

            CSVWriter writerApostas = new CSVWriter(new FileWriter("apostas.csv"));
            writerApostas.writeNext(new String[]{aposta.getValores(), aposta.getNome(), aposta.getIdNome()});
            writerApostas.close();
        } catch (IOException e) {
            System.err.println("Erro ao manipular arquivo: " + e.getMessage());
        }
    }

    public static ArrayList<Aposta> carregaAposta() {
        ArrayList<Aposta> listaApostas = new ArrayList<>();
        try{

            CSVReader readerApostas = new CSVReader(new FileReader("apostas.csv"));
            String[] linha;
            while((linha = readerApostas.readNext()) != null) {
                    String[] valoresString = linha[0].substring(1, linha[0].length() - 1).split(", ");
                    ArrayList<Integer> lista = new ArrayList<>();
                    for (String valor : valoresString) {
                    lista.add(Integer.parseInt(valor));
                    }
                    String nome = linha[1];
                    String cpf = linha[2];
                    Aposta aposta = new Aposta(lista, nome, cpf);
                    listaApostas.add(aposta);

            }
        } catch (IOException e) {
            System.err.println("Erro ao manipular arquivo: " + e.getMessage());
        }
        catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return listaApostas;
    }

    public static void listarApostas(ArrayList<Aposta> lista) {
        System.out.println(lista);
    }


}



