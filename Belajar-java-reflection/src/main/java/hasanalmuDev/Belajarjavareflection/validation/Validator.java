package hasanalmuDev.Belajarjavareflection.validation;

import hasanalmuDev.Belajarjavareflection.Annotations.NotBlank;

import java.lang.reflect.Field;

public class Validator {

    public static void validateNotBlank(Object object) throws IllegalAccessException {
        Class<?> aClass = object.getClass();

        //get all field
        Field[] fields = aClass.getFields();

        //iterate each field
        for(var field : fields) {

            //get not blank annotation
            NotBlank notBlank = field.getAnnotation(NotBlank.class);

            //check if annotation is exist
            if(notBlank != null) {

                //get field value
                field.setAccessible(true);
                String value = (String) field.get(object);

                if (notBlank.allowEmpetyString()) {
                    // allow empety string
                    // egniro
                } else {
                    //not allow empety string
                    value= value.trim(); // menghapus spasi di kanan kiri
                }
                if("".equals(value)) {
                    throw new RuntimeException("field : " + field.getName() + "must not blank");
                }
            }
        }
    }

    public static void validationNoBlank2(Object object) throws IllegalAccessException {
        Class<?> aClass = object.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();

        for(var field : declaredFields) {

            NotBlank notBlank = field.getAnnotation(NotBlank.class);

            if(notBlank != null) {
                field.setAccessible(true);
                String value  = (String) field.get(object);
                if(notBlank.allowEmpetyString()) {

                } else {
                    value = value.trim();
                }
                if("".equals(value)) {
                    throw new RuntimeException("field " + field.getName() + "must not blank");
                }
            }
        }

    }
}
