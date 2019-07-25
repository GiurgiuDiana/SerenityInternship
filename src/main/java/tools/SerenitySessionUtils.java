package tools;

import net.serenitybdd.core.Serenity;

public class SerenitySessionUtils {

    @SuppressWarnings("unchecked")
    public static <T> T getFromSession(String key) {
        return (T) Serenity.getCurrentSession().get(key);
    }

    public static void putOnSession(String key, Object object) {
        Serenity.getCurrentSession().put(key, object);
    }
}