package com.epam.tc.hw7.site.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.tc.hw7.site.sections.LogInForm;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends WebPage {
    @Css("form")
    public static LogInForm loginForm;
    @Css("img#user-icon")
    public static Icon signInIcon;
    @UI("[id = user-name]")
    public static Text userName;
    @Css("header ul.navbar-nav.m-l8 > li")
    public static Menu headerMenu;
    @Css(".logout")
    Button logOut;

    public void logout() {
        signInIcon.click();
        logOut.click();
    }
}
