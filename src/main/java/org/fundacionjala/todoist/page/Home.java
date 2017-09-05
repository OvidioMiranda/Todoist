package org.fundacionjala.todoist.page;

import org.fundacionjala.todoist.page.base.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Class for the Home Page.
 */
public class Home extends BasePage {

    /**
     * Wait for page load and get the title from Home Page.
     *
     * @return Url current.
     */
    public String getTitleHomePage() {
        wait.until(ExpectedConditions.titleContains("Todoist"));
        return driver.getCurrentUrl();
    }
}
