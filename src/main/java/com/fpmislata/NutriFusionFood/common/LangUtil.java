package com.fpmislata.NutriFusionFood.common;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public class LangUtil {

    public static String getLang(){
        Locale currentLocale = LocaleContextHolder.getLocale();
        return currentLocale.getLanguage();
    }
}
