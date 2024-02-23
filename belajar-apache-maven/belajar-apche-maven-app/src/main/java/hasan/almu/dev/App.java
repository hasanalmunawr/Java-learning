package hasan.almu.dev;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Gson gsonSan = new Gson();

        Person personSan = new Person("hasan almunawar");
        String json = gsonSan.toJson(personSan);

        System.out.println(json);
    }
}
