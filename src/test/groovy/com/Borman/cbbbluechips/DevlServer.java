package com.Borman.cbbbluechips;

import org.springframework.boot.builder.SpringApplicationBuilder;

public class DevlServer extends CbbbluechipsApplication {

    /*
    You need to run with ENV vars -- get String and edit config to save
     */

    public static void main(String[] args) {
        new DevlServer().configure(new SpringApplicationBuilder())
                .initializers()
                .profiles("devl")
                .run(args);
    }

}