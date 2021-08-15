package com.epam.tc.hw4.utils;

import io.qameta.allure.Attachment;

public class AttachmentsUtil {

    @Attachment(type = "image/png", value = "Page screenshot")
    public static byte[] screenshotAttachment(final String name, final byte[] source) {
        return source;
    }
}
