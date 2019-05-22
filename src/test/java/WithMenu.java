import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.annotation.Param;
import io.qameta.htmlelements.element.HtmlElement;

public interface WithMenu extends WebPage {

  @FindBy("//div[contains(@class,'MenuItem') and . = '{{ itemName }}']")
  HtmlElement menuItem(@Param("itemName") String itemName);
}
