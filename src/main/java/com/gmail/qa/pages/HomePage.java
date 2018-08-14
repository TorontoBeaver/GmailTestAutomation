package com.gmail.qa.pages;

    import com.gmail.qa.base.TestBase;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;

    public class HomePage extends TestBase {

    @FindBy(xpath = "//div[@gh=\"cm\"]")
    WebElement compose;
    @FindBy(xpath = "//textarea[@name=\"to\"]")
    WebElement newMessageFieldTo;
    @FindBy(xpath = "//input[@name=\"subjectbox\"]")
    WebElement newMessageSubjectField;
    @FindBy(xpath = " //div[@aria-label=\"Message Body\"]")
    WebElement newMessageField;
    @FindBy(xpath = "//div[contains(@data-tooltip,'Send \u202A(Ctrl-Enter)\u202C')]")
    WebElement newMessageButtonSend;
    @FindBy(xpath = "span[@data-thread-id][1]")
    WebElement newEmailField;


    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    public void sentMessage(String newMessageEmail,String newMessageSubject,String newMessage) {
        compose.click();
        newMessageFieldTo.sendKeys(newMessageEmail);
        newMessageSubjectField.sendKeys(newMessageSubject);
        newMessageField.sendKeys(newMessage);
        newMessageButtonSend.click();
    }
    public String test(){

        String emailField = newEmailField.getText();

        return emailField;
    }
}
