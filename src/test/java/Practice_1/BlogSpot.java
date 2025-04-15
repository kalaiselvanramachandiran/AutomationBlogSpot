package Practice_1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlogSpot {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement Name=driver.findElement(By.xpath("//input[@id='name']"));
		Name.sendKeys("kalai");
		WebElement Phone=driver.findElement(By.xpath("//input[@id='email']"));
		Phone.sendKeys("kalai@gmail.com");
		WebElement txtarea=driver.findElement(By.xpath("//textarea[@id='textarea']"));
		txtarea.sendKeys("kalaai is a good boy");
		WebElement genderbtn=driver.findElement(By.xpath("//input[@id='male']"));
		genderbtn.click();
		WebElement daycheckbox=driver.findElement(By.xpath("//input[@id='sunday']"));
		daycheckbox.click();
		WebElement countryDropDown=driver.findElement(By.xpath("//select[@id='country']"));
		Select select=new Select(countryDropDown);
		select.selectByIndex(2);
		WebElement colorsDropDown=driver.findElement(By.xpath("//select[@id='colors']"));
		Select select1=new Select(colorsDropDown);
		select1.selectByValue("green");
		WebElement animalsDropDown=driver.findElement(By.xpath("//select[@id='animals']"));
		Select select2=new Select(animalsDropDown);
		select2.selectByIndex(1);
		WebElement datepicker1=driver.findElement(By.xpath("//*[@id='datepicker']"));
		datepicker1.click();
		String m="March";
		String y="2025";
		String d="15";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		int maxTries = 12; // Max 12 months forward
		int tries = 0;
		while (tries < maxTries) {
		    String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		    String year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		    
		   // System.out.println("Current Calendar: " + month + " " + year); // Debug

		    if (month.equalsIgnoreCase(m) && year.equals(y)) {
		        break;
		    }

		    WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Next']")));
		    nextBtn.click();

		    tries++;
		}

//		if (tries == maxTries) {
//		    System.out.println("Target month/year not found after " + maxTries + " attempts. Exiting loop.");
//		}

		List<WebElement>date=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr /td//a"));
		for(WebElement D:date)
		{
			
			if(D.getText().equals(d))
			{
				D.click();
				break;
			}
		}
		//List<WebElement> dates=driver.findElements(By.xpath("//*[@class=\"ui-datepicker-calendar\"]//tbody//tr//td//a"));
		WebElement datepicker2=driver.findElement(By.xpath("//input[@id='txtDate']"));
		datepicker2.click();
		WebElement dateDropDown=driver.findElement(By.xpath("//*[@class='ui-datepicker-month']"));
		Select se=new Select(dateDropDown);
		se.selectByValue("1");
		WebElement Year=driver.findElement(By.xpath("//*[@class='ui-datepicker-year']"));
		Year.click();
		Select se1=new Select(Year);
		se1.selectByValue("2021");
		
		List<WebElement> date2=driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		String d2="25";
		for(WebElement D:date2)
		{
			if(D.getText().equals(d2))
			{
				D.click();
			}
		}
		
		WebElement datePicker3=driver.findElement(By.xpath("//input[@id='start-date']"));
		datePicker3.sendKeys("09/19/2002");
		WebElement datePicker4=driver.findElement(By.xpath("//input[@id='end-date']"));
		datePicker4.sendKeys("05/25/2003");
		WebElement submitbtn=driver.findElement(By.xpath("//button[@class='submit-btn']"));
		submitbtn.click();
		WebElement resulttxt=driver.findElement(By.xpath("//div[@id='result']"));
		String newStr=resulttxt.getText();
		if(newStr.equals("You selected a range of 248 days."))
		{
			System.out.println("Test Passed");
		}
		
		//static webtable....
		List<WebElement> pricetablelist = driver.findElements(By.xpath("//table[@name='BookTable']//tr/td[4]"));
		int size = pricetablelist.size();
		//System.out.println(size);
		int lowestPrice = Integer.parseInt(pricetablelist.get(0).getText().trim());
		System.out.println(lowestPrice);
		for (int i = 1; i < pricetablelist.size(); i++) {
		     int price = Integer.parseInt(pricetablelist.get(i).getText().trim());
		     if (price < lowestPrice) {
		         lowestPrice = price;
		     }
		     
		}
			
		System.out.println("Lowest price is "+lowestPrice);		 
// //dynamic webtable
		List<WebElement> activePage=driver.findElements(By.xpath("//*[@class='pagination']//li//a"));
		System.out.print(activePage.size());
		for(int i=1;i<=activePage.size();i++)
		{
			String pageText=driver.findElement(By.xpath("//*[@class='pagination']//li["+i+"]")).getText();
			int pages=Integer.parseInt(pageText);
			if(pages>1)
			{
				driver.findElement(By.xpath("//*[@class='pagination']//li["+i+"]")).click();
			}
			int rows=driver.findElements(By.xpath("//*[@id='productTable']//tbody//tr")).size();
			for(int r=1;r<=rows;r++)
			{
				String name=driver.findElement(By.xpath("//*[@id='productTable']//tbody//tr["+r+"]//td[2]")).getText();
				WebElement cbox=driver.findElement(By.xpath("//*[@id='productTable']//tbody//tr["+r+"]//*[@type='checkbox']"));
				cbox.click();
				System.out.println(name);
			}
		}
		//handling search Results
//		driver.findElement(By.xpath("//*[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("selenium");
//		driver.findElement(By.xpath("//*[@class='wikipedia-search-button']")).click();
//		List<WebElement> searchResult=driver.findElements(By.xpath("//*[@id='Wikipedia1_wikipedia-search-results']//a"));
//		for(WebElement e:searchResult)
//		{
//			e.click();
//			
//		}
//		Set<String> windowele=driver.getWindowHandles();
//		System.out.println(windowele);
//		List<String>ele=new ArrayList(windowele);
//		for(String currPage: ele)
//		{
//			System.out.println(currPage);
//			driver.switchTo().window(currPage);
//			driver.close();
//		}
			//handling alerts
		//simple alert
			WebElement alertelement=driver.findElement(By.xpath("//*[@id='alertBtn']"));
			alertelement.click();
			Alert myalert=driver.switchTo().alert();
			myalert.accept();
			//confirmation alert
			driver.findElement(By.xpath("//*[@id='confirmBtn']")).click();
			Alert myalert1=driver.switchTo().alert();
			myalert1.dismiss();
			String confirmtxt=driver.findElement(By.xpath("//*[@id='demo']")).getText();
			if(confirmtxt.equals("You pressed Cancel!"))
			{
				System.out.println("you have clicked the canceled button");
			}
			else
			{
				System.out.println("you have clicked the ok button");
			}
			//handling prompt alert
			driver.findElement(By.xpath("//*[@id='promptBtn']")).click();
			Alert myalert2=driver.switchTo().alert();
			myalert2.sendKeys("kalai");
			myalert2.accept();
			if(confirmtxt.equals("Hello Harry Potter! How are you today?"))
			{
				System.out.println("you have clicked ok button");
			}
		//handling mouse hover
		WebElement ele3=driver.findElement(By.xpath("//button[normalize-space()='Point Me']"));
		WebElement el4=driver.findElement(By.xpath("//a[normalize-space()='Mobiles']"));
		Thread.sleep(3000);
		Actions myaction=new Actions(driver);
		myaction.moveToElement(ele3).moveToElement(el4).perform();
		//handling double click
		WebElement btn=driver.findElement(By.xpath("//*[@ondblclick='myFunction1()']"));
		Actions myaction1=new Actions(driver);
		myaction1.doubleClick(btn).perform();
		//handling drag and drop
		WebElement ele1=driver.findElement(By.xpath("//*[@class='ui-widget-content ui-draggable ui-draggable-handle']"));
		WebElement el2=driver.findElement(By.xpath("//*[@class='ui-widget-header ui-droppable']"));
		Actions myaction2=new Actions(driver);
		myaction2.dragAndDrop(ele1, el2).perform();
				WebElement form1=driver.findElement(By.xpath("//input[@id='input1']"));
				form1.sendKeys("kalai");
				WebElement subbtn1=driver.findElement(By.xpath("//button[@id='btn1']"));
				subbtn1.click();
				WebElement form2=driver.findElement(By.xpath("//input[@id='input2']"));
				form2.sendKeys("selvan");
				WebElement subbtn2=driver.findElement(By.xpath("//button[@id='btn2']"));
				subbtn2.click();
				WebElement form3=driver.findElement(By.xpath("//input[@id='input3']"));
				form3.sendKeys("R");
				WebElement subbtn3=driver.findElement(By.xpath("//button[@id='btn3']"));
				subbtn3.click();
	
	
		

	}

}


