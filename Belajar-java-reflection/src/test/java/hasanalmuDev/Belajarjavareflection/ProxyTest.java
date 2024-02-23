package hasanalmuDev.Belajarjavareflection;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    void testProxy() {
         final String collor;
        InvocationHandler invocationHandler = new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("getName")) {
                    return "car Proxy";
                } else if (method.getName().equals("run")) {
                    System.out.println("car is running");
                } else if (method.getName().equals("setCollor")) {
                    System.out.println("the collor is " + String.valueOf(method.getDefaultValue()));
                }
                return null;
            }
        };

        Car car = (Car) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), // ini penting
                new Class[]{Car.class}, invocationHandler);

        System.out.println(car.getClass());
        System.out.println(car.getName());
        System.out.println(car.setCollor("green"));
        car.run();
    }
}
