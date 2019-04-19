import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		// Configure the script to determine whether it's a Mac or Windows Machine

		String os = System.getProperty("os.name").toLowerCase();
        WebDriver driver = new ChromeDriver();
        if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/chromedriver");
		} else {
            System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\chromedriver.exe");
        }           
		// Navigate to sign up page
		driver.navigate()
				.to("https://dev.workmarket.com/register/campaign/10081C503B209A0C8E7F05FDCC1AA98D4C904DEEF5F73265CAE38C744E7EAD3E");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		// Click on “Join as Individual”
		driver.findElement(By.xpath("//*[@id=\"landing-page-bucket\"]//div/div/span[contains(text(),'Join as an individual')]")).click();
		Thread.sleep(1000);
		
		driver.get("http://dev.workmarket.com/login");
		Thread.sleep(1000);
		driver.findElement(By.id("login-email")).sendKeys("qa+candidatetest@workmarket.com");
		driver.findElement(By.id("login-password")).sendKeys("candidate123");
		driver.findElement(By.id("login_page_button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"home__Find Talent-button\"]/div/div/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("input-text")).sendKeys("test");
		Thread.sleep(1000);
		driver.findElement(By.id("input-text")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String searchResult = driver.findElement(By.xpath("(//div[@id='search_results']//div[@class='profile-card--details']/h2)[1]")).getText();
		
		String[] arrResult = searchResult.split(" ");
		String firstResult = arrResult[0];
		System.out.println(firstResult);
		
		if(firstResult.equals("test")) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
		driver.close();
	}

}
