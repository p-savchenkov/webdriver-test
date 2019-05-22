import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;

public interface FilterControlsBar extends HtmlElement {

  @FindBy(".//span[contains(@class,'ListingCarsFilters-module__actionCollapse')]")
  HtmlElement expandFilter();

  @FindBy(".//button")
  HtmlElement showResult();
}
