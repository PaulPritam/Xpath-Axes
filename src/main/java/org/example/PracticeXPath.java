//Program for implementing different X-Path axes
package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PracticeXPath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Pritam Paul\\Downloads\\" +
                "demo1\\untitled\\src\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.capitalmarket.com/IPO/New-Listing/BSE");

        //Basic contains
        System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Zomato')]")).getText());

        //Self all and self specific
        System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Zomato Ltd')]//self::*")).getText());
        System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Zomato Ltd')]//self::a")).getText());

        //Parent
        System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Zomato Ltd')]//parent::label")).getText());

        //Parent-Child
        System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Zomato Ltd')]//parent::label/child::a")).getText());

        //Descendant
        System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Zomato Ltd')]//ancestor::td//descendant::a")).getText());

        //Find all elements by ancestor also used following sibling(return the size or total number of elements)
        List<WebElement> sizeOfElements = driver.findElements(By.xpath("//a[contains(text(),'Zomato Ltd')]/ancestor::tr/following-sibling::*"));
        System.out.println("Total number of elements: " + sizeOfElements.size());

        //Similar to above one except used preceding
        List<WebElement> size2 = driver.findElements(By.xpath("//a[contains(text(),'Zomato Ltd')]/preceding::tr"));
        System.out.println(size2.size());

        driver.close();
    }
}
