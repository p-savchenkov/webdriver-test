import org.aeonbits.owner.Config;

public interface TestConfig extends Config {

  @DefaultValue("https://auto.ru")
  String hostName();
}
