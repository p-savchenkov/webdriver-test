import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;

public interface SearchCarsPage extends WebPage, WithButton, WithMenu, WithCheckbox {

  @FindBy("//div[contains(@class,'ListingCarsFilters-module__action')]")
  FilterControlsBar filterControls();

  @FindBy("//input[@name='price_from']")
  HtmlElement priceFrom();

  @FindBy("//input[@name='price_to']")
  HtmlElement priceTo();

}