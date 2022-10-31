package com.multiple.data.source.database.helper;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.lang.NonNull;

/**
 * spring工厂调用辅助类
 *
 */
public class ApplicationContextHelper implements ApplicationContextAware {

    private static DefaultListableBeanFactory springFactory;

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) {
        ApplicationContextHelper.setContext(applicationContext);
        if (applicationContext instanceof AbstractRefreshableApplicationContext) {
            AbstractRefreshableApplicationContext springContext = (AbstractRefreshableApplicationContext) applicationContext;
            ApplicationContextHelper.setFactory((DefaultListableBeanFactory) springContext.getBeanFactory());
        } else if (applicationContext instanceof GenericApplicationContext) {
            GenericApplicationContext springContext = (GenericApplicationContext) applicationContext;
            ApplicationContextHelper.setFactory(springContext.getDefaultListableBeanFactory());
        }
    }

    private static void setContext(ApplicationContext applicationContext) {
        ApplicationContextHelper.context = applicationContext;
    }

    private static void setFactory(DefaultListableBeanFactory springFactory) {
        ApplicationContextHelper.springFactory = springFactory;
    }

    public static DefaultListableBeanFactory getSpringFactory() {
        return springFactory;
    }

    public static ApplicationContext getContext() {
        return context;
    }
}