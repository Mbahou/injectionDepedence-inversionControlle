package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component("vc")
public class DaoImplVCapteur implements IDao {
    @Override
    public double getData() {
        System.out.println("Version Capteur");
        double data =77;
        return data;
    }
}
