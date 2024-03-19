package org.example;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Aposta {
    private static final int idContador = 1000;
    private final int idAposta;
    private ArrayList<Integer> vetor = new ArrayList<Integer>(5);
    private String nome;
    private String idNome;

    public  Aposta(ArrayList<Integer> vetor, String nome, String idNome) {
        this.nome = nome;
        this.idNome = idNome;
        this.idAposta =+ idContador;
        this.vetor = vetor;

    }
    public  Aposta(String nome, String idNome) {
        this.nome = nome;
        this.idNome = idNome;
        this.idAposta = idContador;
        Random random = new Random();
        for(int j = 0; j < 5; j++) {
            vetor.add(random.nextInt(50) + 1);
        }
    }
    public int getIdAposta() {
        return idAposta;
    }
    private ArrayList<Integer> getValor() {
        return vetor;
    }
    public static void imprimirAposta(Aposta aposta) {
        ArrayList<Integer> valores = aposta.getValor();
        for (int valor : valores) {
            System.out.print(valor + " ");
        }
        System.out.println("");
    }

    public String getValores() { return vetor.toString();}

    public String getIdNome() {
        return idNome;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return "Nome: " + nome + ", CPF: " + idNome + ", Aposta: " + vetor.toString();
    }




}

