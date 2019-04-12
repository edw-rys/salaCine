package PatronesDiseño;

import Entidades.Sala;
import Entidades.SalaBlackBox;
import Entidades.SalaGeneral;
import Entidades.SalaVIP;

public class MetodoFabricaSalas {
    public static Sala crearSala(int indicador){
        switch (indicador) {
            case 1:
                return new SalaGeneral();
            case 2:
                return new SalaVIP();
            case 3:
                return new SalaBlackBox();
            default:
                return null;
        }
    }
}
