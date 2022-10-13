package gbrl.ue.database.dto;

public class PessoaDTO {
    private int id;
    private String nome;
    private String nomeMae;
    private String nomePai;
    private String estatoCivil;
    private String naturalidade;
    private long numRG;
    private long numCPF;
    private long numTituloEleitor;

    public PessoaDTO (String nome, String nomeMae, String nomePai, String estatoCivil, String naturalidade, long numRG, long numCPF, long numTituloEleitor) {
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

    public String getNomeMae () {
        return nomeMae;
    }

    public void setNomeMae (String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai () {
        return nomePai;
    }

    public void setNomePai (String nomePai) {
        this.nomePai = nomePai;
    }

    public String getEstatoCivil () {
        return estatoCivil;
    }

    public void setEstatoCivil (String estatoCivil) {
        this.estatoCivil = estatoCivil;
    }

    public String getNaturalidade () {
        return naturalidade;
    }

    public void setNaturalidade (String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public long getNumRG () {
        return numRG;
    }

    public void setNumRG (long numRG) {
        this.numRG = numRG;
    }

    public long getNumCPF () {
        return numCPF;
    }

    public void setNumCPF (long numCPF) {
        this.numCPF = numCPF;
    }

    public long getNumTituloEleitor () {
        return numTituloEleitor;
    }

    public void setNumTituloEleitor (long numTituloEleitor) {
        this.numTituloEleitor = numTituloEleitor;
    }
}
