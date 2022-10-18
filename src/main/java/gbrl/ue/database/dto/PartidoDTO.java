package gbrl.ue.database.dto;

public class PartidoDTO {
    private int id;
    private String nome;
    private int numero;
    private String sigla;


    public PartidoDTO (int id, String nome, int numero, String sigla) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.sigla = sigla;
    }

    public PartidoDTO (String nome, int numero, String sigla) {
        this.nome = nome;
        this.numero = numero;
        this.sigla = sigla;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public int getNumero () {
        return numero;
    }

    public void setNumero (int numero) {
        this.numero = numero;
    }

    public String getSigla () {
        return sigla;
    }

    public void setSigla (String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString () {
        return numero + " | " + sigla;
    }
}
