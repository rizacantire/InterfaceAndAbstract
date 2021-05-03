package concretes;
import abstracts.BaseCustomerManager;
import abstracts.CustomerCheckService;
import entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

import java.rmi.RemoteException;

public class StarbucksCustomerManager extends BaseCustomerManager {
    CustomerCheckService customerCheckService;

    public StarbucksCustomerManager(CustomerCheckService customerCheckService) {
        this.customerCheckService = customerCheckService;
    }
    @Override
    public void save(Customer customer) {

        if(customerCheckService.CheckIfRealPerson(customer)){
            super.save(customer);
            System.out.println("Tc Kimlik Doğrulaması yapıldı");
        }
        else {
            System.out.println("Başarısız Tc Doğrulama");
        }



    /* KPSPublicSoapProxy kpsPublic = new KPSPublicSoapProxy();
        boolean result = kpsPublic.TCKimlikNoDogrula(Long.parseLong(customer.getNationalityId()), customer.getFirstName(), customer.getLastName(),
                customer.getDateOfBirth().getYear());
        System.out.println("TC Kimlik Doğrulama : " + (result ? "Başarılı" : "Başarısız")); */




    }
}
