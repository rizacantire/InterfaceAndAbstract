package concretes;

import abstracts.CustomerCheckService;
import entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
import java.rmi.RemoteException;

public class CustomerCheckManager implements CustomerCheckService {
    @Override
    public boolean CheckIfRealPerson(Customer customer) {
        KPSPublicSoapProxy kpsPublic = new KPSPublicSoapProxy();
        boolean result = false;
        try {
            result = kpsPublic.TCKimlikNoDogrula(Long.parseLong(customer.getNationalityId()), customer.getFirstName(),
                    customer.getLastName(),customer.getDateOfBirth().getYear());

        } catch (RemoteException | NumberFormatException e) {
            e.printStackTrace();

        }
        return  result;
    }
}
