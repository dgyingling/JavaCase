package com.tkom.java.annotation;

import java.lang.reflect.Method;

/**测试注解
 * @author tkom
 * @version 1.0
 * @date 2019/8/6 0006
 */
@Author
public class Test {

    public static void main(String[] args) throws NoSuchMethodException {
        boolean haveAnnotation = Test.class.isAnnotationPresent(Author.class);
        if(haveAnnotation){
            Author author = Test.class.getAnnotation(Author.class);
            System.out.println(author.description());
        }


        Method method = Test.class.getMethod("test");
        Author annotation = method.getAnnotation(Author.class);
        System.out.println(annotation.description());
    }

    @Author(description = "tkom")
    public static void test(){
        System.out.println("ddddddddddddd");
    }
}
