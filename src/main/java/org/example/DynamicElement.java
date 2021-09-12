//Program for handling dynamic elements from google search
package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class DynamicElement {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Pritam Paul\\Downloads\\" +
                "demo1\\untitled\\src\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.co.in/");
        Thread.sleep(1000);

        driver.findElement(By.name("q")).sendKeys("Testing");

        Thread.sleep(1000);

        List<WebElement> elementStore = driver.findElements(By.xpath("//ul[@role='listbox']//descendant::div[@class='wM6W7d']"));
        System.out.println("The number of elements present: " + elementStore.size() + "\n");

        Thread.sleep(1000);

        System.out.println("The search results are: ");
        for (int i = 0; i < elementStore.size(); i++) {
            String items = elementStore.get(i).getText();
            System.out.println(items);
        }

        for (int i = 0; i < elementStore.size(); i++) {
            String items = elementStore.get(i).getText();
            if (items.contains("testing time"))
            {
                elementStore.get(i).click();
                break;
            }
        }
    }
}
