package test.tesuto.Steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import test.tesuto.Pages.BasePageObj;
import test.tesuto.Utility.Initialization;

public abstract class BaseSteps
{
    @Before
    public static void preparation() { Initialization.initializeDriver(); }

    @After
    public static void quitAfter()
    {
        Initialization.getDriver().close();
    }
}
