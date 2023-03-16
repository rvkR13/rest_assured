package utils;

import exception.AnyException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Helper {
    /**
     * Метод, проверяющий, есть ли аннотация для указанного метода в интерфейсе
     *
     * @param methodName      имя проверяемого метода
     * @param feature         класс с интерфейсом фичи
     * @param annotationClass аннотация для этого метода
     * @param parameterTypes  параметры этого метода
     * @return  если аннотация есть - возвращает ее, в противном случае выбрасывает исключение {@link Exception}
     */
    public static <T extends Annotation> T validateAnnotation(final String methodName, final Class<?> feature,
                                                              final Class<T> annotationClass,
                                                              final Class<?>... parameterTypes) {
        try {
            Method thisMethod = feature.getDeclaredMethod(methodName, parameterTypes);
            if (thisMethod.isAnnotationPresent(annotationClass)) {
                return thisMethod.getAnnotation(annotationClass);
            }
        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        }
        throw new AnyException("No annotation for this method!");
    }
}
