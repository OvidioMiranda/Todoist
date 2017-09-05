package org.fundacionjala.todoist.core.driver;

import org.openqa.selenium.WebDriver;

/**
 * Interface for getting the current browser.
 */
public interface IBrowser {

    /**
     * Gets the WebDriver to use.
     *
     * @return WebDriver.
     */
    WebDriver getBrowser();
}
