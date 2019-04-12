package PatronesDiseño;

import Entidades.ReservacionesSalas;
import Entidades.Sala;
import java.util.ArrayList;
import java.util.LinkedList;
import modelo.operacionesDAO.SalaDAO;

public class FacadeSala {
    public static LinkedList<Sala> retornaSalasAReservar(int tipo){
        
        LinkedList<Sala> listaSalas=new SalaDAO().cargarSalasCine("");
        
        if(listaSalas==null) return null;
        LinkedList<Sala> salasIndicadas=new LinkedList();
        for(Sala S: listaSalas)
        {
            if(S.getIdTipo()==tipo){         
                salasIndicadas.add(S);
            }
        }        
        return salasIndicadas;
    }        
}
