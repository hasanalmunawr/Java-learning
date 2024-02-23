package belajar.java.i18N;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {

    @Test
    void testResource() {

        var resorce = ResourceBundle.getBundle("masage_propertis");

        System.out.println(resorce.getString("seeHy"));
        System.out.println(resorce.getString("goodBye"));
    }
    @Test
    void testResourceIndonesia() {
        var language = "id";
        var country = "ID";
        var indonesia = new Locale(language, country);

        var resorce = ResourceBundle.getBundle("massage", indonesia);

        System.out.println(resorce.getString("seeHy"));
        System.out.println(resorce.getString("goodBye"));
    }
 @Test
    void testResourceUSE() {
        var language = "en";
        var country = "US";
        var Usa = new Locale(language, country);

        var resorce = ResourceBundle.getBundle("massage", Usa);

        System.out.println(resorce.getString("seeHy"));
        System.out.println(resorce.getString("goodBye"));
    }
@Test
    void testBoundleTypel() {
        var language = "en";
        var country = "US";
        var Usa = new Locale(language, country);

        var resorce = ResourceBundle.getBundle("massage", Usa);
        var resorce2 = ResourceBundle.getBundle("massage", Usa);

        System.out.println(resorce.getString("seeHy"));
        System.out.println(resorce.getString("goodBye"));

    System.out.println(resorce == resorce2);
    }

}
