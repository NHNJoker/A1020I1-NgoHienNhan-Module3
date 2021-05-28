package model.repository;

import model.bean.Account;

public interface LoginRepository {
    Account login(String userName, String pass);
}
