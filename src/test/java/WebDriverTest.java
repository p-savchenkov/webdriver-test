import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

public class WebDriverTest {

  MainStep mainStep;

  @Rule
  public WebDriverRule driverRule = new WebDriverRule();

  @Before
  public void setUp() { mainStep = new MainStep(driverRule.driver()); }

  @Test
  public void searchCarParamsTest() {

    mainStep.open("https://auto.ru/cars/all/");

    mainStep.onSearchCarsPage().mark().click();
    mainStep.onSearchCarsPage().menuItem("Kia").click();

    mainStep.onSearchCarsPage().filterControls().expandFilter().click();

    mainStep.onSearchCarsPage().priceFrom().sendKeys("300000");
    mainStep.onSearchCarsPage().priceTo().sendKeys("500000");

    mainStep.onSearchCarsPage().oneOwner().click();

    mainStep.scrollToElemenet(mainStep.onSearchCarsPage().equipmentPtf());
    mainStep.onSearchCarsPage().equipmentPtf().click();

    mainStep.onSearchCarsPage().filterControls().showResult().click();

    mainStep.shouldSeeAllParamsInUrl(
            Arrays.asList(
                    "cars/kia",
                    "price_from=300000",
                    "price_to=500000",
                    "owners_count_group=ONE",
                    "catalog_equipment=ptf"
            )
    );

  }
}