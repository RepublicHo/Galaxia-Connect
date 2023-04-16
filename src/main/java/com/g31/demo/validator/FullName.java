//package com.g31.demo.validator;
//
//import javax.validation.Constraint;
//import java.lang.annotation.Documented;
//import java.lang.annotation.Retention;
//import java.lang.annotation.Target;
//
//import static java.lang.annotation.ElementType.FIELD;
//import static java.lang.annotation.ElementType.PARAMETER;
//import static java.lang.annotation.RetentionPolicy.RUNTIME;
//
//@Documented
//@Constraint(validatedBy = FullNameValidator.class)
//@Target({PARAMETER, FIELD})
//@Retention(RUNTIME)
//public @interface FullName {
//    String message() default "Wrong format for the full name.";
//
//    Class[] groups() default {};
//
//    Class[] payload() default {};
//}
