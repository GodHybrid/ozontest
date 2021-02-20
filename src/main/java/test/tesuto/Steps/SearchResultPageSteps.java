package test.tesuto.Steps;

import cucumber.api.java.ru.А;
import test.tesuto.Pages.MainPage;
import test.tesuto.Pages.SearchResultPage;

import java.util.List;

public class SearchResultPageSteps
{
    //static public SearchResultPage searchPage = new SearchResultPage();
    static public MainPage mainPage = new MainPage();

    @А("Отметить следующие элементы:")
    public void clickMultiple(List<String> items) throws Exception
    {
        mainPage.clickMultiple(items);
    }
}
