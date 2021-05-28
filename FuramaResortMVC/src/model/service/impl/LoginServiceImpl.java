package model.service.impl;

import model.bean.Account;
import model.repository.LoginRepository;
import model.repository.impl.LoginRepositoryImpl;
import model.service.LoginService;

public class LoginServiceImpl implements LoginService {
    LoginRepository loginRepository = new LoginRepositoryImpl();

    @Override
    public Account login(String userName, String pass) {
        return this.loginRepository.login(userName, pass);
    }
}
