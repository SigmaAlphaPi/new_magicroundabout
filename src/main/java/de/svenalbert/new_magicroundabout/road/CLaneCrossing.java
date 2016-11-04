package de.svenalbert.new_magicroundabout.road;

import de.svenalbert.new_magicroundabout.graph.network.CNode;
import de.svenalbert.new_magicroundabout.vehicle.CVehicle;

import java.util.LinkedHashMap;

/**
 * Created by sven on 04.11.16.
 */
public class CLaneCrossing extends CNode {
    protected CVehicle blockCrossing;

    public CLaneCrossing(Object p_id) {
        super(p_id);
    }

    public CLaneCrossing(Object p_id, int m_xposition, int m_yposition) {
        super(p_id, m_xposition, m_yposition);
    }
}
