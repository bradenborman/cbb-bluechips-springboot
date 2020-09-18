package Borman.cbbbluechips;

import org.springframework.boot.builder.SpringApplicationBuilder;

public class ProdServer extends CbbbluechipsApplication {

    /*
    You need to run with ENV vars -- get String and edit config to save
     */

    public static void main(String[] args) {
        new ProdServer().configure(new SpringApplicationBuilder())
                .initializers()
                .profiles("prod")
                .run(args);
    }

}