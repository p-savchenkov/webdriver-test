import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.annotation.Param;
import io.qameta.htmlelements.element.HtmlElement;

public interface SearchCarsPage extends WebPage{

  @FindBy("//div[contains(@class,'ListingCarsFilters-module__action')]")
  FilterControlsBar filterControls();

  @FindBy("//input[@name='price_from']")
  HtmlElement priceFrom();

  @FindBy("//input[@name='price_to']")
  HtmlElement priceTo();

  @FindBy("//input[@value='ptf']")
  HtmlElement equipmentPtf();

  @FindBy("//div[contains(@class,'MenuItem') and . = '{{ itemName }}']")
  HtmlElement menuItem(@Param("itemName") String itemName);

  @FindBy("//button[.//span[.='Марка']]")
  HtmlElement mark();

  @FindBy("//button[.//span[.='1 владелец']]")
  HtmlElement oneOwner();

}