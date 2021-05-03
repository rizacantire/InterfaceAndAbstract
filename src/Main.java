import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Date;

import abstracts.BaseCustomerManager;
import concretes.CustomerCheckManager;
import concretes.NeroCustomerManager;
import concretes.StarbucksCustomerManager;
import entities.Customer;
import javafx.util.converter.LocalDateStringConverter;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class Main {

	public static void main(String[] args)
	{
		Customer customer1 = new Customer(1,"Test","Soyad",LocalDate.parse("1988-01-11"),"25487456214");

		BaseCustomerManager customerManager = new StarbucksCustomerManager(new CustomerCheckManager());
		customerManager.save(customer1);



	}

}
