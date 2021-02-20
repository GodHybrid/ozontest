package test.tesuto.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.tesuto.Annotations.FieldNameGetter;

import java.util.*;

public class MainPage extends BasePageObj
{
    @FindBy(xpath = "//div/a[contains(text(),'планшеты')]")
    @FieldNameGetter(name = "Ноутбуки и планшеты")
    public WebElement laptopsTabletsSubcategoryButton;

    @FindBy(xpath = "//div/a[contains(text(),'Игровые')]")
    @FieldNameGetter(name = "Игровые ноутбуки")
    public WebElement gamingLaptopButton;

    @FindBy(xpath = "//div[contains(text(),'Бренды')]/..//span[contains(text(),'Посмотреть все')]")
    @FieldNameGetter(name = "Просмотреть все бренды")
    public WebElement allBrandsOpenButton;

    @FindBy(xpath = "//div[contains(text(),'Бренды')]/../div/div/div/a")
    @FieldNameGetter(name = "Список брендов")
    public List<WebElement> allBrandsList;

    @FindBy(xpath = "//div[contains(text(),'Бренды')]/../div/div/div/a//span[contains(text(),'MSI')]")
    @FieldNameGetter(name = "MSI")
    public WebElement brandMSI;

    @FindBy(xpath = "//div[contains(text(),'Бренды')]/../div/div/div/a//span[contains(text(),'Razer')]")
    @FieldNameGetter(name = "Razer")
    public WebElement brandRazer;

    @FindBy(xpath = "//div[@data-widget='searchResultsSort']//input")
    @FieldNameGetter(name = "Сортировка по")
    public WebElement sortByDropdown;

    @FindBy(xpath = "//div[@data-widget='searchResultsV2']//a/div[contains(@class,'item')]/span[1]")
    @FieldNameGetter(name = "Результаты поиска: Цены")
    public List<WebElement> searchResultsPriceList;

    @FindBy(xpath = "//div[@data-widget='webPrice']//span/span")
    @FieldNameGetter(name = "Цена")
    public WebElement priceTag;

    public MainPage()
    {
        super();
        allBrandsList = new ArrayList<>();
    }

    @Override
    public WebElement getField(String name) throws Exception
    {
        return getField(name, "test.tesuto.Pages.MainPage");
    }
}
