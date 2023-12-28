package sdet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignmentsdet {

	public static void main(String[] args) {
		// Setup EdgeDriver using WebDriver Manager
		WebDriverManager.chromedriver().setup();
		// Create an instance of the Edge driver
		WebDriver Driver=new ChromeDriver();

	            // Navigate to the specified URL
		        System.out.println("Navigating to the URL...");
		        Driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");

		        // Click on the "Table Data" button
		        System.out.println("Clicking on the 'Table Data' button...");
		        WebElement tableDataButton = waitForElement(Driver, By.xpath("//div[@class='centered']/details/summary"));

		        tableDataButton.click();

		        // Insert data into the text box and click the "Refresh Table" button
		        System.out.println("Inserting data and refreshing the table...");
		        insertAndRefreshTable(Driver);

		        // Assert the data in the table
		        System.out.println("Asserting the data in the table...");
		        assertTableData(Driver);

		        // Close the browser
		        System.out.println("Closing the browser...");
		        Driver.quit();
		    }

		 // ...
		 // ...

		    private static void insertAndRefreshTable(WebDriver driver) {
		        WebElement dataInput = waitForElement(driver, By.id("jsondata"));

		        // Clear existing data
		        dataInput.clear();

		        String jsonData = "[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, " +
		                          "{\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, " +
		                          "{\"name\": \"Sara\", \"age\" : 42, \"gender\": \"female\"}, " +
		                          "{\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, " +
		                          "{\"name\": \"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]";

		        dataInput.sendKeys(jsonData);

		        WebElement refreshButton = waitForElement(driver, By.id("refreshtable"));
		        refreshButton.click();
		    }

		    // ...


		    // ...

		    @SuppressWarnings("unused")
			private static void assertTableData(WebDriver driver) {
		        // Your existing code for asserting data in the table
		        // ...

		        // Example: wait for a table row to be present
		        WebElement tableRow = waitForElement(driver, By.xpath("//table[@id='data-table']/tbody/tr"));
		        // Implement your assertions based on the actual and expected data
		    }

		   

		    private static WebElement waitForElement(WebDriver driver, By by) {
		        WebDriverWait wait = new WebDriverWait(driver, 30);

		        // Wait for document.readyState to be complete
		        wait.until((WebDriver webDriver) ->
		                ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

		        // Wait for the presence of the element
		        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
		    }

	}
