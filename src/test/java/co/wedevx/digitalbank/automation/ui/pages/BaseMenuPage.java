package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseMenuPage extends BasePage {

    public BaseMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="checking-menu")
    protected WebElement checkingMenu;

    @FindBy(id="new-checking-menu-item")
    protected WebElement newCheckingButton;

    @FindBy(id="view-checking-menu-item")
    protected WebElement viewCheckingButton;

    @FindBy(id="home-menu-item")
    protected WebElement homeButton;


    @FindBy(id="savings-menu")
    protected WebElement savingsMenu;

    @FindBy(id="view-savings-menu-item")
    protected WebElement viewSavingsButton;

    @FindBy(id="new-savings-menu-item")
    protected WebElement newSavingsButton;

    @FindBy(id="external-accounts-menu")
    protected WebElement externalMenu;

    @FindBy(id="link-external-menu-item")
    protected WebElement linkExternalAccountLink;

    @FindBy(id="view-external-menu-item")
    protected WebElement viewExternalAccountLink;

    @FindBy(id="deposit-menu-item")
    protected WebElement depositLink;

    @FindBy(id="withdraw-menu-item")
    protected WebElement withdrawLink;

    @FindBy(id="transfer-menu-item")
    protected WebElement transferBetweenAccountsLink;

    @FindBy(id="visa-transfer-menu-item")
    protected WebElement visaDirectTransferLink;

    @FindBy(xpath="//a[@class='navbar-brand']")
    protected WebElement digitalBankHomeLink;

    @FindBy(id="menuToggle")
    protected WebElement menuToggle;

    @FindBy(id="searchLocations")
    protected WebElement magnifyingGlassButton;

    @FindBy(id="notification")
    protected WebElement notificationButton;

    @FindBy(id="message")
    protected WebElement messageButton;

    @FindBy(id="aboutLink")
    protected WebElement aboutLink;

    @FindBy(id="language")
    protected WebElement languageLink;

    @FindBy(xpath="//a/img[@class='user-avatar rounded-circle']")
    protected WebElement userAvatarRoundedCircleDropDown;

    public void goToHomePage() {
        homeButton.click();
    }


}
