import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.annotation.Param;
import io.qameta.htmlelements.element.HtmlElement;

public interface WithCheckbox extends WebPage {

  @FindBy("//input[@value='{{ valueName }}']")
  HtmlElement checkBox(@Param("valueName") String valueName);

}
