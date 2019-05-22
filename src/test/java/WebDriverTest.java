import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class WebDriverTest {

  MainStep mainStep;

  @Rule
  public WebDriverRule driverRule = new WebDriverRule();

  @Before
  public void setUp() {
    mainStep = new MainStep(driverRule.driver());
  }

  @DataProvider
  public static Object[][] validPrices() {
    return new Object[][]{
            {"1"},
            {"300000"},
            {"999999999"}
    };
  }

  @Test
  @UseDataProvider("validPrices")
  public void shouldSeePriceFromInUrlWhenFilterByPriceFrom(String priceValue) {

    mainStep.openSearchCarsPage();
    mainStep.onSearchCarsPage().priceFrom().sendKeys(priceValue);
    mainStep.onSearchCarsPage().filterControls().showResult().click();
    mainStep.shouldSeeParamInUrl("price_from=" + priceValue);

  }

  @Test
  @UseDataProvider("validPrices")
  public void shouldSeePriceToInUrlWhenFilterByPriceTo(String priceValue) {

    mainStep.openSearchCarsPage();
    mainStep.onSearchCarsPage().priceTo().sendKeys(priceValue);
    mainStep.onSearchCarsPage().filterControls().showResult().click();
    mainStep.shouldSeeParamInUrl("price_to=" + priceValue);

  }

  @DataProvider
  public static Object[][] ownersCount() {
    return new Object[][]{
            {"1 владелец", "ONE"},
            {"Не более 2", "LESS_THAN_TWO"}
    };
  }

  @Test
  @UseDataProvider("ownersCount")
  public void shouldSeeOwnerCountsInUrlWenFilterByOwners(String buttonName, String urlParam) {

    mainStep.openSearchCarsPage();
    mainStep.onSearchCarsPage().filterControls().expandFilter().click();
    mainStep.onSearchCarsPage().button(buttonName).click();
    mainStep.onSearchCarsPage().filterControls().showResult().click();
    mainStep.shouldSeeParamInUrl("owners_count_group=" + urlParam);

  }

  @DataProvider
  public static Object[][] equipmentCheckboxes() {
    return new Object[][]{
            {"Рейлинги на крыше", "roof-rails"},
            {"Противотуманные фары", "ptf"},
            {"Навигационная система", "navigation"}
    };
  }

  @Test
  @UseDataProvider("equipmentCheckboxes")
  public void shouldSeeEquipmentOptionInUrlWenFilterByEquipmentCheckbox(String optinoName, String optionValue) {

    mainStep.openSearchCarsPage();
    mainStep.onSearchCarsPage().filterControls().expandFilter().click();
    mainStep.scrollToElemenet(mainStep.onSearchCarsPage().checkBox(optionValue));
    mainStep.onSearchCarsPage().checkBox(optionValue).click();
    mainStep.onSearchCarsPage().filterControls().showResult().click();
    mainStep.shouldSeeParamInUrl("catalog_equipment=" + optionValue);

  }

  @DataProvider
  public static Object[][] carMarks() {
    return new Object[][]{
            {"Kia", "kia"},
            {"BMW", "bmw"},
            {"Отечественные", "vendor1"}
    };
  }

  @Test
  @UseDataProvider("carMarks")
  public void shouldSeeMarkInUrlWhenFilterByMark(String markName, String markValue) {

    mainStep.openSearchCarsPage();
    mainStep.onSearchCarsPage().button("Марка").click();
    mainStep.onSearchCarsPage().menuItem(markName).click();
    mainStep.onSearchCarsPage().filterControls().showResult().click();
    mainStep.shouldSeeParamInUrl("cars/" + markValue);

  }
}