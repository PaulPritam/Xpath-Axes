package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Webelements {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Pritam Paul\\Downloads\\" +
                "demo1\\untitled\\src\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Computers')]"));

        Actions action = new Actions(driver);

        //Get and click on the given axis using getlocation()
        int getx = element.getLocation().getX();
        int gety = element.getLocation().getY();
        Thread.sleep(1000);
        System.out.println("Co-ordinates are: ");
        System.out.println("X axis: " + getx);
        System.out.println("Y axis: " + gety);

        action.moveByOffset(getx,gety).click();
        action.build().perform();

        //get the size using getSize()
        Dimension size = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).getSize();
        System.out.println(size);
        Thread.sleep(1000);

        //isDisplayed()
        boolean elementDisplayed = driver.findElement(By.xpath("//div[@id='nav-search']")).isDisplayed();
        System.out.println("Result for element(Search box) displayed: " + elementDisplayed);
        Thread.sleep(1000);

        //isEnabled()
        boolean elementEnabled = driver.findElement(By.xpath("//span[contains(text(),'Under ₹1,000')]")).isEnabled();
        System.out.println("Check if element is enabled: "+ elementEnabled);


    }
}
