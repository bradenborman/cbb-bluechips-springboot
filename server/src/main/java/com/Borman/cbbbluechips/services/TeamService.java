package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.models.Teams;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeamService {

    public List<Teams> getTeams() {

        return new ArrayList<Teams>() {{
            add(new Teams(false, "Duke", 1, null));
            add(new Teams(true, "Kentucky", 3, null));
            add(new Teams(false, "UCLA", 7, null));
            add(new Teams(false, "Missouri", 14, null));
        }};
    }


}
