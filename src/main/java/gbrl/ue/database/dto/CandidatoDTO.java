package gbrl.ue.database.dto;

import gbrl.ue.database.dao.PartidoDAO;
import gbrl.ue.database.dao.PessoaDAO;

public class CandidatoDTO {
    private int id;
    private int idPessoa;
    private PessoaDTO pessoa;
    private int idPartido;
    private PartidoDTO partido;
    private String nome;
    private String cargoAtual;
    private String cargoPleito;
    private int numero;

    public CandidatoDTO(){}

    public CandidatoDTO (int id, int idPessoa, int idPartido, String nome, String cargoAtual, String cargoPleito, int numero) {
        this.id = id;
        this.idPessoa = idPessoa;
        this.pessoa = PessoaDAO.getPessoa(idPessoa);
        this.idPartido = idPartido;
        this.partido = PartidoDAO.getPartido(idPartido);
        this.nome = nome;
        this.cargoAtual = cargoAtual;
        this.cargoPleito = cargoPleito;
        this.numero = numero;
    }

    public CandidatoDTO (int idPessoa, int idPartido, String nome, String cargoAtual, String cargoPleito, int numero) {
        this.idPessoa = idPessoa;
        this.pessoa = PessoaDAO.getPessoa(idPessoa);
        this.idPartido = idPartido;
        this.partido = PartidoDAO.getPartido(idPartido);
        this.nome = nome;
        this.cargoAtual = cargoAtual;
        this.cargoPleito = cargoPleito;
        this.numero = numero;
    }

    public int getId () {
        return id;
    }

    public int getIdPessoa () {
        return idPessoa;
    }

    public PessoaDTO getPessoa () {
        return pessoa;
    }

    public int getIdPartido () {
        return idPartido;
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
