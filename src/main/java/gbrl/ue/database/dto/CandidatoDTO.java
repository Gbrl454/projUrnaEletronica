package gbrl.ue.database.dto;

public class CandidatoDTO {
    private int id;
    private PessoaDTO pessoa;
    private PartidoDTO partido;
    private String nome;
    private String cargoAtual;
    private String cargoPleito;
    private int numero;

    public CandidatoDTO (int id, PessoaDTO pessoa, PartidoDTO partido, String nome, String cargoAtual, String cargoPleito, int numero) {
        this.id = id;
        this.pessoa = pessoa;
        this.partido = partido;
        this.nome = nome;
        this.cargoAtual = cargoAtual;
        this.cargoPleito = cargoPleito;
        this.numero = numero;
    }

    public CandidatoDTO (PessoaDTO pessoa, PartidoDTO partido, String nome, String cargoAtual, String cargoPleito, int numero) {
        this.pessoa = pessoa;
        this.partido = partido;
        this.nome = nome;
        this.cargoAtual = cargoAtual;
        this.cargoPleito = cargoPleito;
        this.numero = numero;
    }

    public int getId () {
        return id;
    }

    public PessoaDTO getPessoa () {
        return pessoa;
    }

    public PartidoDTO getPartido () {
        return partido;
    }

    public String getNome () {
        return nome;
    }

    public String getCargoAtual () {
        return cargoAtual;
    }

    public String getCargoPleito () {
        return cargoPleito;
    }

    public int getNumero () {
        return numero;
    }

    private String getSituacaoEleitoral () {
        String sE = "Cargo Pleitiado -> " + cargoPleito;
        if (cargoAtual != null) {
            sE = "Cargo Atual -> " + cargoAtual + " | " + sE;
        }
        return sE;
    }

    @Override
    public String toString () {
        return numero + " | " + nome + " ( " + pessoa.getNome() + " )" + " | " + getSituacaoEleitoral() + " | " + partido.getNome();
    }

}
