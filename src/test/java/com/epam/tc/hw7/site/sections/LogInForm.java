package com.epam.tc.hw7.site.sections;

import static com.epam.tc.hw7.site.pages.HomePage.signInIcon;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.tc.hw7.entities.User;

public class LogInForm extends Form<User> {
    @Css("#name") TextField userName;
    @Css("#password") TextField password;
    @Css("[type=submit]") Button enter;

}