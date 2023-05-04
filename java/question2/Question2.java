package question2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Question2 {
	static WebDriver driver;
  @Test
  public void f() {
	  driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Gaming Laptop");
	  driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
	  driver.findElement(By.xpath("//*[@id=\"p_89/HP\"]/span/a")).click();
	  for(int i=0;i<5;i++) {
		  System.out.println(driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div["+(3+i)+"]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")).getText());
	  }
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
	  Thread.sleep(20000);
	  Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).getText(), "Hello, Ameen");
	  System.out.println("Login Success");
  }

  @AfterTest
  public void afterTest() {
  }

}
