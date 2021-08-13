package com.epam.tc.hw3.utils;

public class WebDriverInjector implements DriverInjector {
    @Override
    public DriverService getDriverService() {
        return new DriverManagerImpl();
    }
}
