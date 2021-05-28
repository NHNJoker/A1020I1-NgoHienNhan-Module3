package model.service;

import model.bean.Account;

public interface LoginService {
    Account login(String userName, String pass);
}
