package test.tesuto.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.tesuto.Annotations.FieldNameGetter;

public class SearchResultPage extends BasePageObj
{
    public SearchResultPage()
    {
        super();
    }

    @Override
    public WebElement getField(String name) throws Exception
    {
        return getField(name, "test.tesuto.Pages.SearchResultPage");
    }
}
