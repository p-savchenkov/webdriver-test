import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.WebPageFactory;
import io.qameta.htmlelements.element.HtmlElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class MainStep {

  WebDriver webDriver;
  JavascriptExecutor jse;

  MainStep(WebDriver webDriver) {
    this.webDriver = webDriver;
    this.jse = (JavascriptExecutor) webDriver;
  }

  public void open(String url) {
    webDriver.get(url);
  }

  public void scrollPage(int scrollX, int scrollY) {
    this.jse.executeScript(String.format("scroll(%d, %d)", scrollX, scrollY));
  }

  // Скролим страницу, что-бы элемент был примерно по центру
  public void scrollToElemenet(HtmlElement element) {
    int halfWindowSizeY = this.webDriver.manage().window().getSize().getHeight() / 2;
    int halfWindowSizeX = this.webDriver.manage().window().getSize().getWidth() / 2;
    this.scrollPage(
            element.getCoordinates().onPage().getX() - halfWindowSizeX,
            element.getCoordinates().onPage().getY() - halfWindowSizeY
    );
  }

  public void shouldSeeAllParamsInUrl(List<String> params) {
    params.forEach(item -> assertThat(webDriver.getCurrentUrl(), containsString(item)));
  }

  public SearchCarsPage onSearchCarsPage() {
    return on(SearchCarsPage.class);
  }

  protected <T extends WebPage> T on(Class<T> pageClass) {
    WebPageFactory factory = new WebPageFactory();
    return factory.get(webDriver, pageClass);
  }
}