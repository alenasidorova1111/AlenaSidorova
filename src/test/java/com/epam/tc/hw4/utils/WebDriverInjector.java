package com.epam.tc.hw4.utils;

public class WebDriverInjector implements DriverInjector {
    @Override
    public DriverService getDriverService() {
        return new DriverManagerImpl();
    }
}
