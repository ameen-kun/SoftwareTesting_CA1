package question1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Question1 {
	static WebDriver driver;
  @Test
  public void test1() throws InterruptedException {
	  driver.navigate().to("https://www.amazon.in/Apple-iPhone-14-128GB-Starlight/dp/B0BDK8LKPJ/ref=sr_1_1_sspa?keywords=Apple%2BIPhone%2B14&qid=1683192020&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&th=1");
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,100)", "");
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
	  Thread.sleep(10000);
	  Assert.assertEquals("Added to Cart", driver.findElement(By.xpath("//*[@id=\"attachDisplayAddBaseAlert\"]/span")).getText());
	  System.out.println("Add to Cart Passed");
	  
  }
  @Test
  public void test2() throws InterruptedException {
	  driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")).click();
	  Thread.sleep(1500);
	  driver.findElement(By.xpath("//*[@value=\"Delete\"]")).click();
	  Thread.sleep(500);
	  System.out.println("Delete Item Passed");
  }
  @Test
  public void test3() throws InterruptedException {
  driver.navigate().to("https://www.amazon.in/Apple-iPhone-14-128GB-Starlight/dp/B0BDK8LKPJ/ref=sr_1_1_sspa?keywords=Apple%2BIPhone%2B14&qid=1683192020&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&th=1");
  JavascriptExecutor js=(JavascriptExecutor) driver;
  js.executeScript("window.scrollBy(0,100)", "");
  Thread.sleep(500);
  driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
  Thread.sleep(10000);
  driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")).click();
  driver.findElement(By.xpath("//*[@id=\"a-autoid-4\"]")).click();
  Thread.sleep(1000);
  driver.findElement(By.xpath("//*[@id=\"a-autoid-4\"]")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
  driver.findElement(By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input")).click();
  Assert.assertEquals("Checkout",driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[3]/h1")).getText());
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  WebDriverManager.edgedriver().setup();
	  EdgeOptions opt=new EdgeOptions();
	  opt.addArguments("--remote-allow-origins=*");
	  driver=new EdgeDriver(opt);
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in/");
	  driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span")).click();
	  driver.findElement(By.id("ap_email")).sendKeys("+917339362038");
	  driver.findElement(By.id("continue")).click();
	  driver.findElement(By.id("ap_password")).sendKeys("@Meen123786");
	  driver.findElement(By.id("signInSubmit")).click();
	  Thread.sleep(10000);
	  Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).getText(), "Hello, Ameen");
	  System.out.println("Login Success");
  }

  @AfterTest
  public void afterTest() {
  }

}
