package gbrl.ue.database.dto;

public class PessoaDTO {
    private final long numTituloEleitor;
    private int id;
    private final String nome;
    private final String nomeMae;
    private final String nomePai;
    private final String estatoCivil;
    private final String naturalidade;
    private final long numRG;
    private final long numCPF;

    public PessoaDTO (int id, String nome, String nomeMae, String nomePai, String estatoCivil, String naturalidade, long numRG, long numCPF, long numTituloEleitor) {
        this.id = id;
        this.nome = nome;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.estatoCivil = estatoCivil;
        this.naturalidade = naturalidade;
        this.numRG = numRG;
        this.numCPF = numCPF;
        this.numTituloEleitor = numTituloEleitor;
    }

    public PessoaDTO (String nome, String nomeMae, String nomePai, String estatoCivil, String naturalidade, long numRG, long numCPF, long numTituloEleitor) {
        this.nome = nome;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.estatoCivil = estatoCivil;
        this.naturalidade = naturalidade;
        this.numRG = numRG;
        this.numCPF = numCPF;
        this.numTituloEleitor = numTituloEleitor;
    }

    public int getId () {
        return id;
    }

    public String getNome () {
        return nome;
    }

    public String getNomeMae () {
        return nomeMae;
    }

    public String getNomePai () {
        return nomePai;
    }

    public String getEstatoCivil () {
        return estatoCivil;
    }

    public String getNaturalidade () {
        return naturalidade;
    }

    public long getNumRG () {
        return numRG;
    }

    public long getNumCPF () {
        return numCPF;
    }

    public long getNumTituloEleitor () {
        return numTituloEleitor;
    }

    @Override
    public String toString () {
        return id + " | " + nome + " | " + numCPF;
    }
}
