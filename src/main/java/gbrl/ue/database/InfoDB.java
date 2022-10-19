package gbrl.ue.database;

public interface InfoDB {

    String IP = "projetournaeletronicapoo.c96lvttyochh.sa-east-1.rds.amazonaws.com";
    String BANCO = "urnaeletronica";

    String USER = "purnaeletronicap";
    String SENHA = "ue55747322poo";

    String urlBD = "jdbc:mysql://" + IP + "/" + BANCO + "?autoReconnect=true&useSSL=false&user=" + USER + "&password=" + SENHA;

    String PESSOAStb = "pessoas";
    String PARTIDOStb = "partidos";
    String CANDIDATOStb = "";



}