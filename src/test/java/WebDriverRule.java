import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverRule extends ExternalResource {

  WebDriver webDriver;

  @Override
  protected void before() {
    webDriver = new ChromeDriver();
  }

  @Override
  protected void after() { webDriver.quit(); }

  public WebDriver driver() {
    return this.webDriver;
  }

}