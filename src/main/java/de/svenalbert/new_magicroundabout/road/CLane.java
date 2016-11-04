package de.svenalbert.new_magicroundabout.road;

import de.svenalbert.new_magicroundabout.graph.network.CEdge;

import java.util.LinkedHashMap;

/**
 * Created by sven on 03.11.16.
 */
public final class CLane extends CEdge {

    protected LinkedHashMap<Integer, Integer> lhm_occupiedCells;
    /**
     * ctor
     *
     * @param p_sourceidentifier source identifier of the edge
     * @param p_targetidentifier target identifiers of the edge
     */
    public CLane(Object p_sourceidentifier, Object p_targetidentifier) {
        super(p_sourceidentifier, p_targetidentifier);
    }



}
