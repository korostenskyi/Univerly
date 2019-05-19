package com.korostenskyi.app;

import com.korostenskyi.app.core.Univerly;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.korostenskyi.app.config");
        Univerly.launch(applicationContext);
        applicationContext.close();
    }
}
