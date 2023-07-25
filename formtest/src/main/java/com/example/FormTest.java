package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Erike\\Desktop\\FormTest\\chromedriver.exe");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Open the web page with the form
        driver.get("http://localhost:3000/");

        // Find the form elements
        WebElement nameInput = driver.findElement(By.id("name"));
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));

        // Fill in the form
        nameInput.sendKeys("Test Test");
        emailInput.sendKeys("test@example.com");

        // Submit the form
        submitButton.click();

        // Wait for a few seconds to see the result before closing the browser (optional)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}