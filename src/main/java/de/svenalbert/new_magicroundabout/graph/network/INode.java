package de.svenalbert.new_magicroundabout.graph.network;

/**
 * interface of graph nodes to create different types of nodes
 * @tparam T any type of the identifier
 */
public interface INode<T>
{

    /**
     * returns the identifier of the node
     *
     * @return identifier
     */
    T id();

    /**
     * x-position of the node
     *
     * @return position
     */
    int xposition();

    /**
     * y-position of the node
     *
     * @return position
     */
    int yposition();

}
