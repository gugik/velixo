package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Wait {
    private Browser browser;

    public Wait(Browser browser) {
        this.browser = browser;
    }

    public void waitForLoad() {
        try {
            new FluentWait<>(browser.getDriver()).withTimeout(Duration.ofSeconds(5))
                    .pollingEvery(Duration.ofMillis(2))
                    .ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
                    .until(readyStateComplete());
        } catch (TimeoutException exception) {
        }
    }

    private ExpectedCondition readyStateComplete() {
        return new ExpectedCondition() {
            public Object apply(Object o) {
                boolean ready = false;
                try {
                    ready = ((JavascriptExecutor) browser.getDriver()).executeScript("return document.readyState")
                            .equals("complete");
                } catch (WebDriverException ignored) {
                }
                return ready;
            }

            public String toString() {
                return "Waiting for the document to reach 'complete' status";
            }
        };
    }

    public void sleep(long delay) {
        try {
            TimeUnit.SECONDS.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            Assert.fail(e.getMessage());
        }
    }

}
