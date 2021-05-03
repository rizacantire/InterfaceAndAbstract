package abstracts;

import entities.Customer;

import java.rmi.RemoteException;

public interface CustomerCheckService {
    boolean CheckIfRealPerson(Customer customer);
}
