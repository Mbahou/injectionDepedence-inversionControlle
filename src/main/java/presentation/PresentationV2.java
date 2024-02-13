package presentation;

import dao.IDao;
import dao.ext.DaoImplV2;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationV2 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("configuration.txt"));
            //DaoImplV2 dao=new DaoImplV2(); equivqlent a ces trois ligne apres
            String daoClassname = scanner.nextLine();
            Class cDao = Class.forName(daoClassname);
            IDao dao=(IDao) cDao.getConstructor().newInstance();
            System.out.println(dao.getData());

            //MetierImpl metier= new MetierImpl(dao);  equivqlent a ces trois ligne apres
            //=============> via le constructeur
            String metierClassName = scanner.nextLine();
            Class cmetier = Class.forName(metierClassName);
            IMetier metier=(IMetier) cmetier.getConstructor(IDao.class).newInstance(dao);
            System.out.println(metier.calcule());

            //=============> via le setter

            String metierClassNames = scanner.nextLine();
            Class cmetiers = Class.forName(metierClassNames);
            IMetier metiers=(IMetier) cmetiers.getConstructor().newInstance();
            Method setDao=cmetiers.getDeclaredMethod("setDao",IDao.class);
            setDao.invoke(metiers,dao);
            System.out.println(metiers.calcule());




        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}

