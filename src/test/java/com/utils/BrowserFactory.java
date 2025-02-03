package com.utils;

import com.config.ConfigurationManager;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public enum BrowserFactory {

    CHROMIUM {
        @Override
        public Browser createInstance(final Playwright playwright) {
            return playwright.chromium().launch(options());
        }
    },
    FIREFOX {
        @Override
        public Browser createInstance(final Playwright playwright) {
            return playwright.firefox().launch(options());
        }
    },
    WEBKIT {
        @Override
        public Browser createInstance(final Playwright playwright) {
            return playwright.webkit().launch(options());
        }
    };

    public BrowserType.LaunchOptions options() {
        return new BrowserType.LaunchOptions()
                .setHeadless(ConfigurationManager.config().headless())
                .setSlowMo(ConfigurationManager.config().slowMotion());
    }

    public abstract Browser createInstance(final Playwright playwright);
}