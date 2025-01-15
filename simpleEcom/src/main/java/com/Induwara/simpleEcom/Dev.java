package com.Induwara.simpleEcom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // This annotation is used to create a bean of this class, which means new Dev() is not needed to create an object of this class. 
           // Object is automatically created by the spring framework, because of this annotation.
public class Dev {
    
    // @Autowired // This annotation is used to inject the Laptop object to this class. This is called feild injection.
    // private Laptop laptop;

    // public Dev(Laptop laptop) { // Constructor injection (no need to use @Autowired annotation)
    //     this.laptop = laptop;
    // }

    // @Autowired 
    // public void setLaptop(Laptop laptop) { // Setter injection (need to use @Autowired annotation)
    //     this.laptop = laptop;
    // }

    // public void build(){
    //     laptop.compile();
    //     System.out.println("Building...");
    // }

    @Autowired
    @Qualifier("laptop") // This annotation is used to specify which object to inject when there are multiple objects that implement the same interface.    
    private Computer computer; //Eventhough Computrer is an interface and it does not have a concrete implementation, spring framework will automatically inject the Laptop object to this variable because Laptop implements Computer interface.

    public void build(){
        computer.compile();
        System.out.println("Building...");
    }

}
