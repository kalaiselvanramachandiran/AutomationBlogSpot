package Practice_1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlogSpot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.navigate().refresh();
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
		WebElement datepicker1=driver.findElement(By.xpath("//*[@id=\"datepicker\"]"));
		datepicker1.click();
		String m="March";
		String y="2025";
		String d="15";
		while(true)
		{
			String month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(month.equals(m) && year.equals(y))
			{
				break;
			}
			driver.findElement(By.xpath("//a[@title='Next']")).click();
		}
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
		 
		//pagination table.
		List<WebElement>pagetable=driver.findElements(By.xpath("//*[@id='productTable']//tr//td[3]"));
		int size1=pagetable.size();
		String str=pagetable.get(0).getText();
		String newStr1= str.substring(1,str.length());
		double lowestprice1=Double.parseDouble(newStr1);
		System.out.print(lowestprice1);
		for(int i=1;i<size1;i++)
		{
			String newStr2=pagetable.get(i).getText();
			String newStr3=newStr2.substring(1,newStr2.length());
			double price1=Double.parseDouble(newStr3);
			
			if(price1<lowestprice1)
			{
				WebElement cbox=driver.findElement(By.xpath("//*[@id='productTable']//tr["+ i +"]//td[4]"));
				cbox.click();
			}
//			WebElement nxtbtn=driver.findElement(By.xpath("//a[normalize-space()='2']"));
//			nxtbtn.click();	
		}

		
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
