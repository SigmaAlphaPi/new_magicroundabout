package de.svenalbert.new_magicroundabout.graph.network;

import java.text.MessageFormat;

/**
 * define a graph node
 * @tparam T any typo of the node identifier to get a more flexible structure
 */
public final class CNode<T> implements INode<T> {
    /**
     * unique node identifier
     */
    private final T m_id;
    /**
     * x-position within the grid structure
     */
    private final int m_xposition;
    /**
     * y-position within the grid structure
     */
    private final int m_yposition;

    /**
     * ctor
     *
     * @param p_id unique identifier
     */
    public CNode(final T p_id)
    {
        // call other constructor
        this( p_id, 0, 0 );
    }

    /**
     * ctor
     *
     * @param p_id unique identifier
     * @param m_xposition x-position
     * @param m_yposition y-position
     */
    public CNode( final T p_id, final int m_xposition, final int m_yposition )
    {
        if (p_id == null)
            throw new IllegalArgumentException( "node ID need not to be null" );
        m_id = p_id;
        this.m_xposition = m_xposition;
        this.m_yposition = m_yposition;
    }


    @Override
    public final T id()
    {
        return m_id;
    }

    @Override
    public final int xposition()
    {
        return m_xposition;
    }

    @Override
    public final int yposition()
    {
        return m_yposition;
    }

    /**
     * overload the default hashcode method for
     * checking if nodes are equal, so we use the hashcode
     * of the identifier for returning, because if the hashcode
     * of the identifier is equal, the nodes are also equal
     *
     * @return hashcode value based on the identifier
     */
    @Override
    public final int hashCode()
    {
        return m_id.hashCode();
    }

    /**
     * overload equals for checking of equal nodes, nodes
     * are equal iif the use the equal identifier
     *
     * @param p_object any object
     * @return boolean if objects are equal
     */
    @Override
    public final boolean equals( final Object p_object )
    {
        return ( p_object != null ) && ( p_object instanceof INode<?> ) && ( this.hashCode() == p_object.hashCode() );
    }


    /**
     * overload toString, for getting a human-readable
     * output on a System.println call
     * @return human-readable string
     */
    @Override
    public final String toString()
    {
        return MessageFormat.format( "(id: {0}, x: {1}, y:{2})", m_id, m_xposition, m_yposition );
    }
}
