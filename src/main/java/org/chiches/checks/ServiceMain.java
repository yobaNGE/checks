package org.chiches.checks;

import jakarta.websocket.Session;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServiceMain {
    private Set<Session> sessions;
    private final ArrayOfBools arrayOfBools;

    public ServiceMain(ArrayOfBools arrayOfBools) {
        this.arrayOfBools = arrayOfBools;
    }


    public boolean[] getBools() {
        System.out.println("getBools");
        return arrayOfBools.getBools();
    }
    public void setTwoDimBools(int x, int y, boolean value) {
        TwoDimArrayOfBools.setBools(x, y, value);
    }
    public boolean[][] getTwoDimBools() {
        return TwoDimArrayOfBools.getBools();
    }

}
