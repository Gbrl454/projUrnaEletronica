package gbrl.ue;

import java.util.ArrayList;

public interface DadosVariaveis {

    String USER_ADMIN = "AdminJus";
    String SENHA_ADMIN = "159357";

    default ArrayList<String> getListEstatoCivil () {
        ArrayList<String> list = new ArrayList<>();
        list.add("Solteiro (a)");
        list.add("Casado (a)");
        list.add("Divorciado (a)");
        list.add("Viúvo (a)");
        return list;
    }

    default ArrayList<String> getListNaturalidade () {
        ArrayList<String> list = new ArrayList<>();
        list.add("Acre (AC)");
        list.add("Alagoas (AL)");
        list.add("Amapá (AP)");
        list.add("Amazonas (AM)");
        list.add("Bahia (BA)");
        list.add("Ceará (CE)");
        list.add("Espírito Santo (ES)");
        list.add("Goiás (GO)");
        list.add("Maranhão (MA)");
        list.add("Mato Grosso (MT)");
        list.add("Mato Grosso do Sul (MS)");
        list.add("Minas Gerais (MG)");
        list.add("Pará (PA)");
        list.add("Paraíba (PB)");
        list.add("Paraná (PR)");
        list.add("Pernambuco (PE)");
        list.add("Piauí (PI)");
        list.add("Rio de Janeiro (RJ)");
        list.add("Rio Grande do Norte (RN)");
        list.add("Rio Grande do Sul (RS)");
        list.add("Rondônia (RO)");
        list.add("Roraima (RR)");
        list.add("Santa Catarina (SC)");
        list.add("São Paulo (SP)");
        list.add("Sergipe (SE)");
        list.add("Tocantins (TO)");
        list.add("Distrito Federal (DF)");
        return list;
    }
}
