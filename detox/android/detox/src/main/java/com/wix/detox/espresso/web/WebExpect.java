package com.wix.detox.espresso.web;

import androidx.test.espresso.web.model.ElementReference;
import androidx.test.espresso.web.sugar.Web;

import java.util.Collections;

import static androidx.test.espresso.web.assertion.WebViewAssertions.webMatches;
import static androidx.test.espresso.web.webdriver.DriverAtoms.getText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;

public class WebExpect {
    final WebElement webElement;

    WebExpect(WebElement webElement) {
        this.webElement = webElement;
    }

    private Web.WebInteraction<Void> webViewInteraction() {
        return webElement.webViewInteraction;
    }

    public void toNotExists() {
        webViewInteraction().check(webMatches(webElement.matcherAtom, equalTo(Collections.<ElementReference>emptyList())));
    }

    public void toExists() {
        webViewInteraction().check(webMatches(webElement.matcherAtom, not(equalTo(Collections.<ElementReference>emptyList()))));
    }

    public void toHaveText(String text) {
        webViewInteraction().withElement(webElement.get()).check(webMatches(getText(), containsString(text)));
    }
}