

import java.awt.geom.*;

public class CollisionDetector {
	
    public static boolean CollisionDetector(Frog frog, Road[] items) {

        for (Road item : items) {
            for (int i = 0; i < item.getRoadItems().size(); i++) {
                Area intersect = new Area(item.getRoadItems().get(i).getBB());
                intersect.intersect(new Area(frog.getBB()));
                if (!intersect.isEmpty()) {
                    return true;
                }
            }	
        }
        return false;
    }
}