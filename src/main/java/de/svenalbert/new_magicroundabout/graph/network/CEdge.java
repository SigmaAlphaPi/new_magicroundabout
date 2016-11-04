package de.svenalbert.new_magicroundabout.graph.network;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CEdge<T> implements IEdge<T>
{
    /**
     * identifier (source of the edge)
     */
    private final T m_sourceidentifier;
    /**
     * identifier (target of the edge)
     */
    private final T m_targetidentifier;
    /**
     * weight of the edge
     */
    private double m_weight;

    /**
     * ctor
     *
     * @param p_sourceidentifier source identifier of the edge
     * @param p_targetidentifier target identifiers of the edge
     */
    public CEdge( final T p_sourceidentifier, final T p_targetidentifier )
    {
        m_sourceidentifier = p_sourceidentifier;
        m_targetidentifier = p_targetidentifier;
    }

    @Override
    public final T from()
    {
        return m_sourceidentifier;
    }

    @Override
    public final double weight()
    {
        return m_weight;
    }

    @Override
    public final IEdge<T> weight( final double p_weight )
    {
        m_weight = p_weight;
        return this;
    }

    @Override
    public final T to() {
        return m_targetidentifier;
    }

    /**
     * overload the toString method
     * to get information about the edge content
     *
     * @return string representation
     */
    @Override
    public final String toString()
    {
        return MessageFormat.format( "{0} --{1}--> {2}", m_sourceidentifier, m_weight, m_targetidentifier );
    }

    /**
     * overload hashcode for checking equality of edge,
     * edges are equal if the source and target node are equal
     *
     * @return hashcode
     */
    @Override
    public final int hashCode()
    {
        // get the hashcode from source & target identifier
        // and multiply it with a large prim number, because for example
        // a identifier is Integer and the source identifier is 2 and target identifier 3
        // than the edge from node 1 to 4 and 2 to 3 are equal, but in this case these nodes
        // are not equal, so the prim number avoid the number collection
        return 	911 * m_sourceidentifier.hashCode() + 313 * m_targetidentifier.hashCode();
    }

    /**
     * check edge equality
     *
     * @param p_object object for checking
     * @return boolean flag if edges are equal
     */
    @Override
    public boolean equals( final Object p_object )
    {
        return ( p_object != null ) && ( p_object instanceof IEdge<?> ) && ( p_object.hashCode() == this.hashCode() );
    }
}
