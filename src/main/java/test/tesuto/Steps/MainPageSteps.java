package test.tesuto.Steps;

import cucumber.api.java.ru.А;
import test.tesuto.Pages.MainPage;

public class MainPageSteps
{
    static public MainPage mainPage = new MainPage();

    @А("Приостановлено выполнение на {int} секунд")
    public void stopForNow(Integer seconds)
    {
        mainPage.justWait(seconds);
    }

    @А("В списке {string} выбран вариант {string}")
    public void chooseFromList(String listBoxName, String optionName) throws Exception
    {
        mainPage.chooseFromList(listBoxName, optionName);
    }

    @А("Выполнено нажатие на клавишу {string} в поле {string}")
    public void pressKey(String keyCodeName, String fieldName) throws Exception
    {
        mainPage.pressKey(keyCodeName, fieldName);
    }

    @А("Сохранено значение {int} поля в коллекции {string}")
    public void savePrice(Integer num, String fieldName) throws Exception
    {
        mainPage.saveData(num, fieldName);
    }

    @А("Выполнено нажатие на {int} поле в коллекции {string}")
    public void pressKey(Integer num, String fieldName) throws Exception
    {
        mainPage.clickButton(num, fieldName);
    }

    @А("Значение поля {string} совпадает с сохранённым значением")
    public void assertRightPrice(String fieldName) throws Exception
    {
        mainPage.checkPrice(fieldName);
    }

    @А("Страница загружена")
    public void loadedFully()
    {
        mainPage.waitForPageLoaded();
    }

    @А("Вывести дополнительную информацию")
    public void extraInfo()
    {
        mainPage.printMoreInfo();
    }

    @А("Выполнен поиск: {string}")
    public void stepSelectMenu(String searchItem)
    {
        mainPage.searchItem(searchItem);
    }

    @А("Выполнено нажатие на кнопку {string}")
    public void stepPressButton(String buttonName) throws Exception
    {
        mainPage.clickButton(buttonName);
    }
}
