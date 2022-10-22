package gbrl.ue.database.dto;

import java.util.ArrayList;

public class PartidoDTO {
    private int id;
    private String nome;
    private int numero;
    private String sigla;
    private ArrayList<CandidatoDTO> candidatos;

    public PartidoDTO (int id, String nome, int numero, String sigla) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.sigla = sigla;
        setCandidatos();
    }

    public PartidoDTO (String nome, int numero, String sigla) {
        this.nome = nome;
        this.numero = numero;
        this.sigla = sigla;
        setCandidatos();
    }

    public int getId () {
        return id;
    }

    public String getNome () {
        return nome;
    }

    public int getNumero () {
        return numero;
    }

    public String getSigla () {
        return sigla;
    }

    public ArrayList<CandidatoDTO> getCandidatos () {
        return candidatos;
    }

    private void setCandidatos () {
        //TODO setar candidatos do partido
    }

    @Override
    public String toString () {
        return numero + " | " + sigla + " | " + nome;
    }
}
