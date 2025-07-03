package Pages.WelcomePage;

import Base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WelcomeScreensPage extends BaseTest {

    public WelcomeScreensPage(AppiumDriver driver) {
        this.driver = driver;
    }

    //Initial 4 Slides Locators
    private final String imageHeroId = "com.monefy.app.lite:id/imageViewHero";
    private final String headerTextId = "com.monefy.app.lite:id/textViewHeader";
    private final String detailTextId = "com.monefy.app.lite:id/textViewDetails";
    private final String pageIndicatorId = "com.monefy.app.lite:id/imageViewPageIndicator";
    private final String continueBtnId = "com.monefy.app.lite:id/buttonContinue";



    // Purchase Slide  locators

    private final String crossIconId = "com.monefy.app.lite:id/buttonClose";
    private final String titleTextId = "com.monefy.app.lite:id/textViewTitle"; //
    private final String featureIconXPathPattern = "//android.widget.LinearLayout[@resource-id='com.monefy.app.lite:id/linearLayoutFeatures']/android.widget.LinearLayout[%d]/android.widget.ImageView";
    private final String featureTextXPathPattern = "//android.widget.LinearLayout[@resource-id='com.monefy.app.lite:id/linearLayoutFeatures']/android.widget.LinearLayout[%d]/android.widget.TextView";
    private final String onlyRightNowTextXpath = "//android.widget.TextView[@resource-id=\"com.monefy.app.lite:id/textViewLayover\"]";
    private final String tryFreeTextViewId = "com.monefy.app.lite:id/textViewPrice";
    private final String ratingStarXpath= "//android.widget.RatingBar[@text=\"5.0\"]";
    private final String reviewsXpath= "//android.widget.TextView[@text=\"127k+ reviews\"]";
    private final String trialConvertionId = "com.monefy.app.lite:id/textViewTrialInfo";
    private final String policyTextID = "com.monefy.app.lite:id/textViewPolicies";
    private final String purchaseBtnId = "com.monefy.app.lite:id/buttonPurchase";
    private final String restoreBtnId = "com.monefy.app.lite:id/buttonRestore";
    private final String noRestorText = "//android.widget.Toast[@text=\"No purchases found\"]";


    private final String purchaseScreenHeading = "//android.widget.TextView[@resource-id=\"com.android.vending:id/0_resource_name_obfuscated\" and @text=\"Monefy Premium - Yearly\"]";
    private final String purchaseScreenCloseIcon = "//android.widget.ImageView[@content-desc=\"Close\"]";



    // Actions / Getters
    public boolean isHeroImageDisplayed() {
        return driver.findElement(AppiumBy.id(imageHeroId)).isDisplayed();
    }

    public String getHeaderText() {
        return driver.findElement(AppiumBy.id(headerTextId)).getText();
    }

    public String getDetailText() {
        return driver.findElement(AppiumBy.id(detailTextId)).getText();
    }
    public boolean isPageViewIndicatorDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
            WebElement pageIndicatorElement = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id(pageIndicatorId)));
            return pageIndicatorElement.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isContinueButtonVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
            WebElement continueBtnElement = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id(continueBtnId)));
            return continueBtnElement.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean isContinueButtonEnabled() {
        return driver.findElement(AppiumBy.id(continueBtnId)).isEnabled();
    }
    public String getContinueButtonText() {
        return driver.findElement(AppiumBy.id(continueBtnId)).getText();
    }
    public void clickContinue() {
        driver.findElement(AppiumBy.id(continueBtnId)).click();
    }


    // Purcahse screen relevant getters / actions
    public boolean isCrossIconVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
            WebElement crossIconElement = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id(crossIconId)));
            return crossIconElement.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean isCrossIconEnabled() {
        return driver.findElement(AppiumBy.id(crossIconId)).isEnabled();
    }
    public void clickCrossIcon() { driver.findElement(AppiumBy.id(crossIconId)).click();}

    public String getTitleText() { return driver.findElement(AppiumBy.id(titleTextId)).getText();}
    public String getOnlyRightNowText() { return driver.findElement(AppiumBy.xpath(onlyRightNowTextXpath)).getText(); }
    // Methods to get feature icon/text by index (1-based index)
    public WebElement getFeatureIcon(int featureIndex) {
        return driver.findElement(AppiumBy.xpath(String.format(featureIconXPathPattern, featureIndex)));
    }

    public WebElement getFeatureText(int featureIndex) {
        return driver.findElement(AppiumBy.xpath(String.format(featureTextXPathPattern, featureIndex)));
    }

    public String getViewPriceText() { return driver.findElement(AppiumBy.id(tryFreeTextViewId)).getText(); }
    public String getRatingStarsText() { return driver.findElement(AppiumBy.xpath(ratingStarXpath)).getText(); }
    public String getReviewsText() { return driver.findElement(AppiumBy.xpath(reviewsXpath)).getText(); }
    public String getTrialInfoText() { return driver.findElement(AppiumBy.id(trialConvertionId)).getText(); }
    public String getPolicyText() { return driver.findElement(AppiumBy.id(policyTextID)).getText(); }

    public boolean isPolicyLinkEnabled() {
        return driver.findElement(AppiumBy.id(policyTextID)).isEnabled();
    }
    public void clickPolicy() {
        driver.findElement(AppiumBy.id(policyTextID)).click();
    }

    public boolean isPurchaseButtonVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
            WebElement purcahseBtnElement = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id(purchaseBtnId)));
            return purcahseBtnElement.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean isPurchaseButtonEnabled() {
        return driver.findElement(AppiumBy.id(purchaseBtnId)).isEnabled();
    }
    public String getPurchaseButtonText() {
        return driver.findElement(AppiumBy.id(purchaseBtnId)).getText();
    }
    public void clickPurchase() {
        driver.findElement(AppiumBy.id(purchaseBtnId)).click();
    }

    public boolean isRestoreButtonVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
            WebElement restoreBtnElement = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id(restoreBtnId)));
            return restoreBtnElement.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean isRestoreButtonEnabled() {
        return driver.findElement(AppiumBy.id(restoreBtnId)).isEnabled();
    }
    public String getRestoreButtonText() {
        return driver.findElement(AppiumBy.id(restoreBtnId)).getText();
    }
    public String getNoRestoreText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement noRestoreTextElement = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(noRestorText)));
        return noRestoreTextElement.getText();
    }
    public void clickRestoreBtn() {
        driver.findElement(AppiumBy.id(restoreBtnId)).click();
    }

    public String getPurchaseScreenHeadingText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement purchaseHeadingElement = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(purchaseScreenHeading)));
        return purchaseHeadingElement.getText();
    }
    public void clickPurchaseScreenCloseIcon() {
        driver.findElement(AppiumBy.xpath(purchaseScreenCloseIcon)).click();
    }
}
