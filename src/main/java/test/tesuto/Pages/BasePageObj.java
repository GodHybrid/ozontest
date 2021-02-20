package test.tesuto.Pages;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import test.tesuto.Annotations.FieldNameGetter;
import test.tesuto.Utility.Initialization;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Field;
import java.util.*;

public abstract class BasePageObj {
    public static WebDriver driver;
    public JavascriptExecutor je;
    public Actions bobDoSomething;
    public static WebDriverWait waitForLoad;

    String pricetag = "";

    @FindBy(name = "search")
    WebElement searchLine;

    @FindBy(xpath = "//li/a[text()='Электроника']")
    @FieldNameGetter(name = "Электроника")
    public WebElement electronicsCategoryButton;

    BasePageObj()
    {
        driver = Initialization.getDriver();
        waitForLoad = new WebDriverWait(driver, 30);
        je = (JavascriptExecutor) driver;
        bobDoSomething = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickButton(String nameButton) throws Exception
    {
        try
        {
            WebElement field = getField(nameButton);
            waitForPageLoaded();
            waitForVisibilityOfElement(field);
            waitForElementClickable(field);
            field.click();
        }
        catch (Exception e)
        {
            System.out.println("Exception in " + this.getClass().toString());
            e.printStackTrace();
        }
    }

    public void clickButton(Integer num, String nameCollection) throws Exception
    {
        try
        {
            WebElement field;
            List<WebElement> tmp = driver.findElements(By.xpath("//div[@data-widget='searchResultsV2']//a/div[contains(@class,'item')]/span[1]"));
            if(tmp.size() > 0) field = tmp.get(num - 1);
            else throw new Exception("\nNo fields found\n");
            waitForPageLoaded();
            waitForVisibilityOfElement(field);
            waitForElementClickable(field);
            field.click();
        }
        catch (Exception e)
        {
            System.out.println("Exception in " + this.getClass().toString());
            e.printStackTrace();
        }
    }

    public void clickMultiple(List<String> names) throws Exception
    {
        try
        {
            for(String nameButton : names)
            {
                waitForPageLoaded();
                WebElement field = getField(nameButton);
                waitForPageLoaded();
                waitForVisibilityOfElement(field);
                waitForElementClickable(field);
                field.click();
                justWait(2);
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception in " + this.getClass().toString());
            e.printStackTrace();
        }
    }

    public void chooseFromList(String listBoxName, String optionName) throws Exception
    {
        Select dropdown = new Select(getField(listBoxName));
        dropdown.selectByVisibleText("optionName");
    }

    public void justWait(Integer seconds)
    {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForPageLoaded()
    {
        waitForLoad.until(dummy -> ((JavascriptExecutor) dummy).executeScript("return document.readyState").equals("complete"));
    }

    public WebElement waitForVisibilityOfElement(WebElement element)
    {
        return waitForLoad.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementClickable(WebElement element)
    {
        return waitForLoad.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void searchItem(String searchItem)
    {
        searchLine.click();
        searchLine.sendKeys(searchItem + Keys.ENTER);
    }

    public abstract WebElement getField(String name) throws Exception;

    public WebElement getField(String name, String className) throws Exception {
        Class aClass = Class.forName(className);
        List<Field> fields = Arrays.asList(aClass.getFields());
        for (Field field : fields) {
            if (field.getType().getName().contains("WebElement") && field.getAnnotations() != null && field.getAnnotation(FieldNameGetter.class).name().equalsIgnoreCase(name)) {
                return driver.findElement(By.xpath(field.getAnnotation(FindBy.class).xpath()));
            }
        }
        return null;
    }

    public void pressKey(String keyCodeName, String fieldName)
    {
        try {
            WebElement we = getField(fieldName);
            we.sendKeys(Keys.valueOf(keyCodeName));
            waitForPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveData(Integer num, String fieldName)
    {
        List<WebElement> tmp = driver.findElements(By.xpath("//div[@data-widget='searchResultsV2']//a/div[contains(@class,'item')]/span[1]"));
        if(tmp.size() > 0) pricetag = tmp.get(num - 1).getText();
    }

    public void checkPrice(String fieldName) throws Exception
    {
        removeObstructionIfPresent();
        WebElement tmp = getField(fieldName);
        waitForVisibilityOfElement(tmp);
        String ds = tmp.getText();
        //ds = ds.replaceAll("\\D","");
        //pricetag = pricetag.replaceAll("\\D","");
        Assert.assertTrue(ds.replaceAll("\\D","").equals(pricetag.replaceAll("\\D","")));
    }

    public void removeObstructionIfPresent()
    {
        try
        {
            waitForPageLoaded();
            WebElement toRemove = driver.findElement(By.xpath("//h2[text()='Товар из-за рубежа']/..//button/div"));
            if(toRemove != null) waitForElementClickable(toRemove).click();
            else return;
            justWait(1);
            //driver.navigate().refresh();
            waitForPageLoaded();
        }
        catch(Exception e){};
    }

    public void printMoreInfo()
    {
        String baseXPath = "//div[@data-widget='webCharacteristics']";
        WebElement x = driver.findElement(By.xpath(baseXPath + "//span[text()='Операционная система']/../../dd"));
        WebElement y = driver.findElement(By.xpath(baseXPath + "//span[text()='Цвет']/../../dd"));
        System.out.println("System: " + x.getText() + "\nColor: " + y.getText());
    }
}
