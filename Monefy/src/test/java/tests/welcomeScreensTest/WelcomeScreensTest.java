package tests.welcomeScreensTest;

import Pages.WelcomePage.PermissionPopupPage;
import Pages.WelcomePage.WelcomeScreensPage;
import Base.BaseTest;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.testng.AllureTestNg;
import listeners.AllureListener;
import models.welcome.Slide;
import models.welcome.SlidesDataWrapper;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.JsonDataReader;
//import utils.SlideDataReader;

import java.util.List;

@Epic("Welcome Screens")
@Feature("Onboarding Flow")
@Listeners({AllureListener.class, AllureTestNg.class})
public class WelcomeScreensTest extends BaseTest {

    WelcomeScreensPage welcomeScreensPage;
    PermissionPopupPage permissionPopupPage;
    List<Slide> slides;
    SoftAssert softAssert= new SoftAssert();

    @Test
    @Description("Verify all welcome screen, permission popup, and purchase screen")
    public void testWelcomeScreenElementsAndSlides() throws InterruptedException {

        welcomeScreensPage = new WelcomeScreensPage(driver);
        permissionPopupPage = new PermissionPopupPage(driver);
        String path = "src/test/java/resources/data/welcomeSlidesData.json";
        SlidesDataWrapper slidesData = JsonDataReader.readJson(path, SlidesDataWrapper.class);
        slides = slidesData.getSlides();

        int slideIndex = 0;

        while (!welcomeScreensPage.isPurchaseButtonVisible()) {

            Slide expectedSlide = slides.get(slideIndex);
            // Verify image displayed
            if (expectedSlide.isImageDisplayed()) {
                softAssert.assertTrue(welcomeScreensPage.isHeroImageDisplayed(), "Icon not displayed on slide " + (slideIndex + 1));
            }

            String actualHeader = welcomeScreensPage.getHeaderText().trim();
            softAssert.assertEquals(actualHeader, expectedSlide.getHeaderText(), "Header text mismatch on slide " + (slideIndex + 1));

            // Verify detail text contains expected substring
            String actualDetail = welcomeScreensPage.getDetailText().trim();
            softAssert.assertTrue(actualDetail.contains(expectedSlide.getDetailTextContains()), "Detail text does not contain expected on slide " + (slideIndex + 1));

            // Verify page indicator
            if (expectedSlide.isPageIndicatorDisplayed()) {
                softAssert.assertTrue(welcomeScreensPage.isPageViewIndicatorDisplayed(), "Page indicator not displayed on slide " + (slideIndex + 1));
            }

            // Verify continue button and its text
            if (welcomeScreensPage.isContinueButtonVisible()){
                Assert.assertTrue(welcomeScreensPage.isContinueButtonVisible());
                Assert.assertTrue(welcomeScreensPage.isContinueButtonEnabled(), "Continue button is not clickable on slide " + (slideIndex + 1));
                String actualContinueButtonText = welcomeScreensPage.getContinueButtonText();
                softAssert.assertEquals(actualContinueButtonText, expectedSlide.getContinueButtonText(), "Continue button text mismatch on slide " + (slideIndex + 1));
            }

            // Click continue
            welcomeScreensPage.clickContinue();

            // Handle permission popup if displayed
            if (permissionPopupPage.isPopupDisplayed()) {
                softAssert.assertTrue(permissionPopupPage.verifyPopupContent(), "Permission popup content verification failed on slide " + (slideIndex + 1));
                System.out.println("Permission popup displayed with message: " + permissionPopupPage.getMessageText());
                // Choose Allow or Deny based on your test strategy
                permissionPopupPage.respondToPopup(expectedSlide.getPopupAction());
            }
            slideIndex++;
        }

        Slide expectedSlide = slides.getLast();

        if (expectedSlide.isImageDisplayed()) {
            softAssert.assertTrue(welcomeScreensPage.isHeroImageDisplayed(), "Icon not displayed on slide ");
        }
        // Verify title text
        String actualTitle = welcomeScreensPage.getTitleText().trim();
        softAssert.assertEquals(actualTitle, expectedSlide.getTitleText(), "Title text mismatch on slide ");


        if (expectedSlide.getFeatures() != null && !expectedSlide.getFeatures().isEmpty()) {
            int featuresCount = expectedSlide.getFeatures().size();

            for (int i = 0; i < featuresCount; i++) {
                int xpathIndex = i + 1; // XPath indexing starts at 1

                // Verify feature icon is displayed
                softAssert.assertTrue(welcomeScreensPage.getFeatureIcon(xpathIndex).isDisplayed(),
                        "Feature icon #" + xpathIndex + " is not displayed");

                // Verify feature text matches JSON
                String actualFeatureText = welcomeScreensPage.getFeatureText(xpathIndex).getText().trim();
                String expectedFeatureText = expectedSlide.getFeatures().get(i).trim();

                softAssert.assertEquals(actualFeatureText, expectedFeatureText, "Feature text mismatch at index " + xpathIndex);
            }
        }
        // Verify Only Right Now text
        String onlyRightNow = welcomeScreensPage.getOnlyRightNowText().trim();
        softAssert.assertEquals(onlyRightNow, expectedSlide.getOnlyRightNowText(), "Only Right Now text mismatch on slide ");

        // Verify Price detail text
        String priceTextView = welcomeScreensPage.getViewPriceText().trim();
        softAssert.assertEquals(priceTextView, expectedSlide.getTryFreeTextContains(), "Price Details text mismatch on slide ");

        // Verify Rating Star text
        String ratingStarText = welcomeScreensPage.getRatingStarsText().trim();
        softAssert.assertEquals(ratingStarText, expectedSlide.getRatingValue(), "Rating value mismatch on slide ");

        // Verify Reviews text
        String reviewsText = welcomeScreensPage.getReviewsText().trim();
        softAssert.assertEquals(reviewsText, expectedSlide.getReviewCountText(), "Rating value mismatch on slide ");

        // Verify Trial End Info text
        String trialEndText = welcomeScreensPage.getTrialInfoText().trim();
        softAssert.assertEquals(trialEndText, expectedSlide.getTrialConversionText(), "Trial ending info Text mismatch on slide ");


        if (expectedSlide.isRestoreButtonDisplayed()) {
            // Verify purchase button text
            String restoreBtnText = welcomeScreensPage.getRestoreButtonText();
            softAssert.assertEquals(restoreBtnText, expectedSlide.getRestoreButtonText(), "Purchase Button Text mismatch on slide ");
            welcomeScreensPage.clickRestoreBtn();

            String restoreActionText = welcomeScreensPage.getNoRestoreText();
            softAssert.assertEquals(restoreActionText, expectedSlide.getNoRestoreText(), "Restore Btn Action Text mismatch on slide ");
        }

        if (expectedSlide.isPolicyTextDisplayed()) {
            // Verify policy text
            String policyText = welcomeScreensPage.getPolicyText().trim();
            softAssert.assertEquals(policyText, expectedSlide.getPolicyText(), "Policy Text mismatch on slide ");
            welcomeScreensPage.clickPolicy();

            softAssert.assertEquals(welcomeScreensPage.getPurchaseScreenHeadingText(), expectedSlide.getPurchaseScreenHeading(), "Purchase screen heading Text mismatch on slide ");
            welcomeScreensPage.clickPurchaseScreenCloseIcon();
        }

        if (expectedSlide.isPurchaseButton()) {
            // Verify policy text
            // Verify purchase button text
            String purchaseBtnText = welcomeScreensPage.getPurchaseButtonText().trim();
            softAssert.assertEquals(purchaseBtnText, expectedSlide.getPurchaseButtonText(), "Purchase Button Text mismatch on slide ");
            welcomeScreensPage.clickPurchase();

            softAssert.assertEquals(welcomeScreensPage.getPurchaseScreenHeadingText(), expectedSlide.getPurchaseScreenHeading(), "Purchase screen heading Text mismatch on slide ");
            welcomeScreensPage.clickPurchaseScreenCloseIcon();
        }

        if (expectedSlide.isCrossIconDisplayed()){
            Assert.assertTrue(welcomeScreensPage.isCrossIconVisible(), "Cross icon(X) is not visible on slide");
            Assert.assertTrue(welcomeScreensPage.isCrossIconEnabled(), "Cross icon(X) is not Clickable on slide");
            welcomeScreensPage.clickCrossIcon();
        }

        softAssert.assertAll();
    }
}