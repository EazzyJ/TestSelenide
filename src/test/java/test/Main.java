package test;

import page.LoginPage;
import page.MailPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Main {

   @BeforeEach
   public void setup() {
       Configuration.browser = "chrome";
       Configuration.startMaximized = true;
       Configuration.timeout = 6000;
       Configuration.baseUrl = "https://passport.yandex.ru/auth/add?from=mail&origin=hostroot_homer_auth_L_ru&retpath=https%3A%2F%2Fmail.yandex.ru%2F&backpath=https%3A%2F%2Fmail.yandex.ru%3Fnoretpath%3D1";
   }

    @Test
    public void loginTest(){
        LoginPage login = new LoginPage();
        login.open().Login("eazzy.test@yandex.ru", "PRTZun5SHWVDzpr");
        MailPage mail = new MailPage();
        mail.Message("eazzy.test@yandex.ru", "Test topic", "Test message");
    }
}
