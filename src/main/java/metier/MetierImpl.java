package metier;

import dao.IDao;

public class MetierImpl implements IMetier{
    // couplage faible
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
