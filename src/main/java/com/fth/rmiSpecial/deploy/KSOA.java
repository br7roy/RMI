package com.fth.rmiSpecial.deploy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Target说明了Annotation所修饰的对象范围:方法
@Target(ElementType.METHOD)
//RetentionPolicy的属性值是RUTIME,这样注解处理器可以通过反射，
//获取到该注解的属性值，从而去做一些运行时的逻辑处理
@Retention(RetentionPolicy.RUNTIME)
public @interface KSOA {
	String value();

    String desc() default "";
}
