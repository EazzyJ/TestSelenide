package page;


import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class LoginPage {

    public LoginPage open() {
        Selenide.open("/");
        return this;
    }

    public LoginPage Login(String login, String passwd) {
        $(byId("passp-field-login")).setValue(login);
        $(byId("passp:sign-in")).click();
        $(byId("passp-field-passwd")).setValue(passwd);
        $(byId("passp:sign-in")).click();
        return this;
    }
}

