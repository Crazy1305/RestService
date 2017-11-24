package restservice.services;

import restservice.entities.UserAccount;
import restservice.exceptions.AccountAlreadyExistsException;
import restservice.exceptions.AccountNotExistsException;

import java.util.Collection;

public interface UserAccountService {

    UserAccount getAccountByLogin(String login) throws AccountNotExistsException;
    Collection<UserAccount> getAccounts();
    UserAccount updateAccount(UserAccount updated) throws AccountNotExistsException;
    boolean deleteAccount(String login);
    UserAccount addAccount(UserAccount created) throws AccountAlreadyExistsException;
}
