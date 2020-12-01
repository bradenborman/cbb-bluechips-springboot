package Borman.cbbbluechips;

import org.springframework.boot.builder.SpringApplicationBuilder;

public class DevlServer extends CbbBlueChipsApplication {

    public static void main(String[] args) {
        new DevlServer().configure(new SpringApplicationBuilder())
                .initializers()
                .profiles("devl")
                .run(args);
    }

}