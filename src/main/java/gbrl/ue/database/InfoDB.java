package gbrl.ue.database;

public interface InfoDB {

    String IP = "localhost";
    String BANCO = "urnaeletronica";

    String USER = "root";
    String SENHA = "";

    String urlBD = "jdbc:mysql://" + IP + "/" + BANCO + "?autoReconnect=true&useSSL=false&user=" + USER + "&password=" + SENHA;

    String PESSOAStb = "pessoas";
    String PARTIDOStb = "partidos";
    String CANDIDATOStb = "candidatos";

}