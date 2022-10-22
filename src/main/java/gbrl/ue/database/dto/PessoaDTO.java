package gbrl.ue.database.dto;

public class PessoaDTO {
    private int id;
    private String nome;
    private String nomeMae;
    private String nomePai;
    private String estatoCivil;
    private String naturalidade;
    private String numTituloEleitor;
    private String numRG;
    private String numCPF;
    private String senha;

    public PessoaDTO (){}
    public PessoaDTO (int id, String nome, String nomeMae, String nomePai, String estatoCivil, String naturalidade, String numTituloEleitor, String numRG, String numCPF, String senha) {
        this.id = id;
        this.nome = nome;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.estatoCivil = estatoCivil;
        this.naturalidade = naturalidade;
        this.numTituloEleitor = numTituloEleitor;
        this.numRG = numRG;
        this.numCPF = numCPF;
        this.senha = senha;
    }

    public PessoaDTO (String nome, String nomeMae, String nomePai, String estatoCivil, String naturalidade, String numTituloEleitor, String numRG, String numCPF, String senha) {
        this.nome = nome;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.estatoCivil = estatoCivil;
        this.naturalidade = naturalidade;
        this.numTituloEleitor = numTituloEleitor;
        this.numRG = numRG;
        this.numCPF = numCPF;
        this.senha = senha;
    }

    public String getSenha () {
        return senha;
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

    public String getNumCPF () {
        return numCPF;
    }

    public String getNumTituloEleitor () {
        return numTituloEleitor;
    }

    public String getNumRG () {
        return numRG;
    }

    private StringBuilder getCPF () {
        String[] maskCPFi = getNumCPF().split("");
        StringBuilder maskCPF = new StringBuilder("***.");
        for (int i = 3; i < maskCPFi.length - 2; i++) {
            maskCPF.append(maskCPFi[i]);
            if (i == 5) {
                maskCPF.append(".");
            }
        }
        maskCPF.append("-**");
        return maskCPF;
    }

    @Override
    public String toString () {
        return nome + " | " + getCPF();
    }
}
