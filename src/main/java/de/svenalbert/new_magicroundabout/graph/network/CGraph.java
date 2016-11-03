package de.svenalbert.new_magicroundabout.graph.network;

import com.google.common.base.Function;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * graph class - we are using a component to build graph, so this class
 * wraps only the existing component with a nice structure
 * @tparam T node identifier type
 * @see http://jung.sourceforge.net/doc/api/edu/uci/ics/jung/graph/package-summary.html
 */
public class CGraph<T> implements IGraph<T>
{
    /**
     * graph data structure, store it internally for avoid modification
     */
    private final DirectedSparseGraph<INode<T>, IEdge<T>> m_graph = new DirectedSparseGraph<>();
    /**
     * shortest-path algorthm object
     */
    private final DijkstraShortestPath<INode<T>,IEdge<T>> m_dijekstra;
    /**
     * map with identifier and node objects
     */
    private final Map<T, INode<T>> m_nodemap;


    /**
     * ctor - create graphs tructure
     *
     * @param p_nodes nodes elements
     * @param p_edges edge elements
     */
    public CGraph(final Collection<INode<T>> p_nodes, final Collection<IEdge<T>> p_edges )
    {
        // in Java 8 a function can be written with a lambda expression
        // @see http://www.java2s.com/Tutorials/Java/java.util.function/Function/index.htm
        // (i) -> i.weight()
        // i is the edge and than this expression can be written as a "static function definition IEdge::weight"
        // so the default weight for an edge is: "get the weight value from the edge"
        this( p_nodes, p_edges, IEdge::weight );
    }

    /**
     * ctor - create graphs tructure
     *
     * @param p_nodes nodes elements
     * @param p_edges edge elements
     * @param p_weightfunction weight function
     */
    public CGraph(final Collection<INode<T>> p_nodes, final Collection<IEdge<T>> p_edges, final Function<IEdge<T>, ? extends Number> p_weightfunction )
    {
        // put all nodes into the graph
        p_nodes.forEach( m_graph::addVertex );

        // put edges to the graph and get the corresponding nodes first,
        // so build a  map with node identifier and node object
        // to get the node objects
        m_nodemap = Collections.unmodifiableMap(
                p_nodes.stream()
                        .collect(Collectors.toMap( INode::id, i -> i ) )
        );

        p_edges.stream()
                // check if the nodes "from" and "to" exists on the node map
                .filter( i -> m_nodemap.containsKey( i.from() ) && m_nodemap.containsKey( i.to() ) )
                // create edge and put it to the graph
                .forEach( i -> m_graph.addEdge( i, m_nodemap.get( i.from() ), m_nodemap.get( i.to() ) ) );

        // build dijekstra shortest path algorithm object, the graph must exist before and we would
        // like to build a weight graph, so the second parameter is the function which read the weight
        // of the edge
        m_dijekstra = new DijkstraShortestPath<>( m_graph, p_weightfunction );
    }


    @Override
    public final List<IEdge<T>> route( final T p_start, final T p_end )
    {
        // build two temporary nodes, because nodes are equal on their hashcode method
        // so it is faster to build two new nodes than searching within the node map
        return m_dijekstra.getPath( new CNode<>( p_start ), new CNode<>( p_end ) );
    }

    @Override
    public final INode<T> node( final T p_id )
    {
        return m_nodemap.get( p_id );
    }

    @Override
    public final IEdge<T> edge( final T p_start, final T p_end )
    {
        // build two temporary nodes, because nodes are equal on their hashcode method
        // so it is faster to build two new nodes than searching within the node map
        return m_graph.findEdge( new CNode<>( p_start ), new CNode<>( p_end ) );
    }

    @Override
    public final Collection<INode<T>> neighbours( final T p_id )
    {
        // create a temporary node, because nodes are equal on their hashcode method
        final INode<T> l_node = new CNode<T>( p_id );
        return m_graph.containsVertex( l_node )
                ? m_graph.getNeighbors( l_node )
                : Collections.<INode<T>>emptySet();
    }

    @Override
    public final int hashCode()
    {
        return m_graph.hashCode();
    }

    @Override
    public final boolean equals( final Object p_object)
    {
        return (p_object != null) && (p_object instanceof IGraph<?>) && (p_object.hashCode() == this.hashCode());
    }

    @Override
    public final String toString()
    {
        return m_graph.toString();
    }
}
