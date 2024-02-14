package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier{
    // couplage faible
    @Autowired  //injecte moi dans la variable dao   un Objet de Type IDao
    /*
    * si le package contient deux implementation d'une interface il faut le preciser le nom  du
    * class de l'implementation a initialiser 
     */
    @Qualifier(value = "vc")
    private IDao dao;


    public MetierImpl() {
    }

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcule() {
        double t = dao.getData();
        double res = t*23;
        return res;
    }

    // pour injecter dans la variable dao un objet d'une class qui implemente l'interface IDao
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
