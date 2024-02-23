package hasan.almu.testing.generator;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class SimpleDisplayGenerator implements DisplayNameGenerator{


    @Override
    public String generateDisplayNameForClass(Class<?> className) {
        return "Test " + className.getSimpleName();
    }

    @Override
    public String generateDisplayNameForMethod(Class<?> className, Method methodName) {
        return "Test " + className.getSimpleName() + "." + methodName.getName() ;
    }

    @Override
    public String generateDisplayNameForNestedClass(Class<?> aClass) {
        return null;
    }
}
