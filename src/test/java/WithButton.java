import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.annotation.Param;
import io.qameta.htmlelements.element.HtmlElement;

public interface WithButton extends WebPage {

  @FindBy("//button[.//span[.='{{ buttonName }}']]")
  HtmlElement button(@Param("buttonName") String buttonName);

}
