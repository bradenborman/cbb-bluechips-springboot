package Borman.cbbbluechips;

import org.springframework.boot.builder.SpringApplicationBuilder;

public class Server extends CbbBlueChipsApplication {

    public static void main(String[] args) {
        new Server().configure(new SpringApplicationBuilder())
                .initializers()
//                .profiles("devl")
                .run(args);
    }

}