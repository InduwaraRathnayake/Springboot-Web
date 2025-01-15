package com.Induwara.simpleEcom;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary // This annotation is used to give priority to this class when there are multiple classes that implement the same interface.
public class Desktop implements Computer {
    
    public void compile() {
        System.out.println("Compiling... from Desktop");
    }  
    
}
