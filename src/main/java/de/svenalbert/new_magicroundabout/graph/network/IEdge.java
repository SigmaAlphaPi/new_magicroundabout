package de.svenalbert.new_magicroundabout.graph.network;

import java.util.Collection;

/**
 * interface of edges
 */
public interface IEdge<T>
{

    /**
     * returns the identifier of the source / start node
     * on which the edge starts
     *
     * @return node identifier
     */
    T from();

    /**
     * return the identifier of the target / end node
     * on which the edge points to
     *
     * @return node identifier
     */
    T to();

    /**
     * returns the weight of the edge
     *
     * @return weight
     */
    double weight();

    /**
     * sets the weight
     *
     * @param p_weight new weight of the edge
     * @return self reference
     */
     IEdge<T> weight( final double p_weight );

}
