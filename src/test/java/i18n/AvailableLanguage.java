package i18n;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AvailableLanguage {
    public static List<Arguments> availableLanguages(){
        return List.of(arguments("es"),arguments("en"));
    }
}
