package page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class MailPage {

    public void clickType(){
        $(".mail-ComposeButton").click();
    }

    public void clickSend(){
        $(byXpath("/html/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/button")).click();
        $(byXpath("/html/body/div[13]/div/div[1]/div[2]/a")).click();
        refresh();
    }

    public void openMessage(){
        $(".mail-MessageSnippet-Item_sender").click();
        $(byXpath("//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[3]/div[3]/div/div[5]/div[1]/div/div/div[2]/div/div[1]/div/div[2]/div[1]/div[1]/div/div/div/a/div/span[2]")).click();
    }

    public void deleteMessage(){
        $(byXpath("//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[3]/div[3]/div/div[5]/div[1]/div/div/div[2]/div/div[1]/div/div/div/a/div/span[1]/div/div/div[2]/label/span[1]")).click();
        $(byXpath("//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[3]/div[3]/div/div[2]/div[2]/div/div[2]/div/div/div[5]")).click();
    }

    public void isMessageCorrect(){
        $(byXpath("//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[3]/div[3]/div/div[5]/div[1]/div/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div")).shouldHave(text("eazzy.test@yandex.ru"));
        $(byXpath("//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[3]/div[3]/div/div[5]/div[1]/div/div[2]/div[1]/div[1]/div/div/span/div")).shouldHave(text("Test topic"));
        $(byXpath("//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[3]/div[3]/div/div[5]/div[1]/div/div[3]/div/div")).shouldHave(text("Test message"));
        back();
    }

    public MailPage Message(String name, String topic, String text){
        this.clickType();
        $(byXpath("/html/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div/div/div/div/div")).setValue(name);
        $(byXpath("/html/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[3]/div/div/input")).setValue(topic);
        $(byXpath("/html/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[3]/div[2]/div[2]/div[1]/div/div/div")).setValue(text);
        this.clickSend();
        this.openMessage();
        this.isMessageCorrect();
        this.deleteMessage();
        return this;
    }

}
