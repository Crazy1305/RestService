package restservice.services;

import restservice.entities.UserAccount;
import restservice.exceptions.AccountAlreadyExistsException;
import restservice.exceptions.AccountNotExistsException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserAccountServiceImpl implements UserAccountService {

    private Map<String, UserAccount> accounts;

    public UserAccountServiceImpl() {
        accounts = new HashMap<>();
    }

    @Override
    public UserAccount getAccountByLogin(String login) throws AccountNotExistsException {
        if (!accounts.containsKey(login)) {
            throw new AccountNotExistsException();
        }
        return accounts.get(login);
    }

    @Override
    public Collection<UserAccount> getAccounts() {
        return accounts.values();
    }

    @Override
    public UserAccount updateAccount(UserAccount updated) throws AccountNotExistsException {
        String login = updated.getLogin();
        if (!accounts.containsKey(login)) {
            throw new AccountNotExistsException();
        }
        return accounts.put(login, updated);
    }

    @Override
    public boolean deleteAccount(String login) {
        if (!accounts.containsKey(login)) {
            return false;
        }
        return true;
    }

    @Override
    public UserAccount addAccount(UserAccount created) throws AccountAlreadyExistsException {
        String login = created.getLogin();
        if (accounts.containsKey(login)) {
            throw new AccountAlreadyExistsException();
        }
        return accounts.put(login, created);
    }
}
