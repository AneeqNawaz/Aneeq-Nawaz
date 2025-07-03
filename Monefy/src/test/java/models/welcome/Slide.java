package models.welcome;

import java.util.List;

public class Slide {
    private boolean imageDisplayed;
    private String headerText;
    private String detailTextContains;
    private boolean pageIndicatorDisplayed;
    private String continueButtonText;
    private boolean permissionPopupExpected;
    private String popupAction;



    // Fields for final slide promo content
    private String titleText;
    private List<String> features;
    private String onlyRightNowText;
    private String tryFreeTextContains;
    private String ratingValue;
    private String reviewCountText;
    private String trialConversionText;


    private boolean policyTextDisplayed;
    private String policyText;
    private boolean purchaseButton;
    private boolean crossIconDisplayed;
    private boolean restoreButtonDisplayed;
    private String restoreButtonText;

    private String noRestoreText;
    private String purchaseButtonText;

    private String purchaseScreenHeading;

    // Getters and setters
    public boolean isImageDisplayed() {
        return imageDisplayed;
    }
    public void setImageDisplayed(boolean imageDisplayed) {
        this.imageDisplayed = imageDisplayed;
    }
    public String getHeaderText() {
        return headerText;
    }
    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }
    public String getDetailTextContains() {
        return detailTextContains;
    }
    public void setDetailTextContains(String detailTextContains) {
        this.detailTextContains = detailTextContains;
    }
    public boolean isPageIndicatorDisplayed() {
        return pageIndicatorDisplayed;
    }
    public void setPageIndicatorDisplayed(boolean pageIndicatorDisplayed) {
        this.pageIndicatorDisplayed = pageIndicatorDisplayed;
    }
    public String getContinueButtonText() {
        return continueButtonText;
    }
    public void setContinueButtonText(String continueButtonText) {
        this.continueButtonText = continueButtonText;
    }
    public boolean isPermissionPopupExpected() {
        return permissionPopupExpected;
    }
    public void setPermissionPopupExpected(boolean permissionPopupExpected) {
        this.permissionPopupExpected = permissionPopupExpected;
    }
    public String getPopupAction() {
        return popupAction;
    }
    public void setPopupAction(String popupAction) {
        this.popupAction = popupAction;
    }

    // Purchase Slide getter / setter
    public String getTitleText() {return titleText;}
    public void setTitleText(String titleText) {this.titleText = titleText;}

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public String getOnlyRightNowText() {
        return onlyRightNowText;
    }

    public void setOnlyRightNowText(String onlyRightNowText) {
        this.onlyRightNowText = onlyRightNowText;
    }

    public String getTryFreeTextContains() {
        return tryFreeTextContains;
    }

    public void setTryFreeTextContains(String tryFreeTextContains) {
        this.tryFreeTextContains = tryFreeTextContains;
    }

    public String getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(String ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String getReviewCountText() {
        return reviewCountText;
    }

    public void setReviewCountText(String reviewCountText) {
        this.reviewCountText = reviewCountText;
    }

    public String getTrialConversionText() {
        return trialConversionText;
    }

    public void setTrialConversionText(String trialConversionText) {
        this.trialConversionText = trialConversionText;
    }
    public boolean isPolicyTextDisplayed() {
        return policyTextDisplayed;
    }

    public void setPolicyTextDisplayed(boolean policyTextDisplayed) {
        this.policyTextDisplayed = policyTextDisplayed;
    }
    public String getPolicyText() {
        return policyText;
    }
    public void setPolicyText(String policyText) {
        this.policyText = policyText;
    }
    public boolean isRestoreButtonDisplayed() {
        return restoreButtonDisplayed;
    }

    public void setRestoreButtonDisplayed(boolean restoreButton) {
        this.restoreButtonDisplayed = restoreButton;
    }
    public String getRestoreButtonText() {
        return restoreButtonText;
    }

    public void setRestoreButtonText(String restoreButtonText) {
        this.restoreButtonText = restoreButtonText;
    }

    public String getNoRestoreText() {
        return noRestoreText;
    }

    public void setNoRestoreText(String noRestoreText) {
        this.noRestoreText = noRestoreText;
    }

    public String getPurchaseButtonText() {
        return purchaseButtonText;
    }

    public void setPurchaseButtonText(String purchaseButtonText) {
        this.purchaseButtonText = purchaseButtonText;
    }

    public boolean isPurchaseButton() {
        return purchaseButton;
    }

    public String getPurchaseScreenHeading() {
        return purchaseScreenHeading;
    }

    public void setPurchaseScreenHeading(String purchaseScreenHeading) {
        this.purchaseScreenHeading = purchaseScreenHeading;
    }

    public void setPurchaseButton(boolean purchaseButton) {
        this.purchaseButton = purchaseButton;
    }

    public boolean isCrossIconDisplayed() {
        return crossIconDisplayed;
    }

    public void setCrossIconDisplayed(boolean crossIconDisplayed) {
        this.crossIconDisplayed = crossIconDisplayed;
    }

}
