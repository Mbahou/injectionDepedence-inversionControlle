package presentation;

import dao.DaoImpl;
import dao.ext.DaoImplV2;
import metier.MetierImpl;

public class PresentationV1 {
    public static void main(String[] args) {
        /*
        * L'injection des dependances par instanciation statique => new
        */

        DaoImplV2 dao=new DaoImplV2();
        MetierImpl metier= new MetierImpl(dao);   //L'injection des dependances via le constructeur
        //metier.setDao(dao); // injection via setter
        System.out.println(metier.calcule());

    }
}
