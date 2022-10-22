package gbrl.ue.database;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public interface InfoDB {
    PullDB p = new PullDB();

    String IP = p.getIP();
    String BANCO = p.getBANCO();

    String USER = p.getUSER();
    String SENHA = p.getSENHA();

    String urlBD = "jdbc:mysql://" + IP + "/" + BANCO + "?autoReconnect=true&useSSL=false&user=" + USER + "&password=" + SENHA;

    String PESSOAStb = "pessoas";
    String PARTIDOStb = "partidos";
    String CANDIDATOStb = "candidatos";

}

class PullDB {
    private String IP, BANCO, USER, SENHA;

    public PullDB () {
        JSONObject jsonObject;
        JSONParser jsonParser = new JSONParser();

        try {
            jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/main/java/gbrl/ue/database/.dadosDB.json"));
            IP = (String) jsonObject.get("ip");
            BANCO = (String) jsonObject.get("banco");
            USER = (String) jsonObject.get("usuario");
            SENHA = (String) jsonObject.get("senha");
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getIP () {
        return IP;
    }

    public String getBANCO () {
        return BANCO;
    }

    public String getUSER () {
        return USER;
    }

    public String getSENHA () {
        return SENHA;
    }
}