package de.svenalbert.new_magicroundabout.graph.network;

import de.svenalbert.new_magicroundabout.graph.network.INode;

import java.util.Collection;
import java.util.List;

/**
 * interface of graphs
 * @tparam T node identifier type
 */
public interface IGraph<T>
{

    /**
     * calculate a route
     *
     * @param p_start start node identifier
     * @param p_end end node identifier
     * @return list of edges to represent the route
     */
    List<de.svenalbert.new_magicroundabout.graph.network.IEdge<T>> route(final T p_start, final T p_end );

    /**
     * returns a node from the graph
     *
     * @param p_id identifier of the node
     * @return null or node object
     */
    INode<T> node(final T p_id );

    /**
     * returns an edge
     *
     * @param p_start source node identifier
     * @param p_end target node identifier
     * @return edge or null if edge not exists
     */
    IEdge<T> edge( final T p_start, final T p_end );

    /**
     * returns the neighbours of a node
     *
     * @param p_id node identifier
     * @return collection of neighbour nodes
     */
    Collection<INode<T>> neighbours( final T p_id );

}
