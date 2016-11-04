package de.svenalbert.new_magicroundabout.vehicle;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * abstract vehicle class providing a vehicle's basic functionality
 */
public abstract class CVehicle implements IVehicle {
    private final LinkedList m_route;
    /**
     * true if vehicle has reached end of route
     */
    private boolean m_finished = false;
    /**
     * vehicle is currently on this position in vehicle's route
     */
    private int m_position = 0;
    /**
     * vehicle's maximum speed
     * 30 mph UK speed limit inside city limits
     *   = 48 km/h -> 13.888 m/s (too fast for roundabout)
     * 20 mph -> 30 km/h -> 8.333 m/s is absolute maximum (cell's length is 2m -> 4 cells)
     * for visibility reasons set to "3"
     */
    //TODO choose one variable to continue with, delete the others
    protected final int m_maxSpeed = 3;
    protected final int m_maxSpeedMPH = 20;
    protected final int m_maxSpeedKPH = 30;
    /**
     * vehicle's current speed
     */
    private int m_currentSpeed;
    /**
     * vehicle's color for visualisation purposes
     */
    private Color m_color;
    /**
     * vehicle's label
     * "C" for car, "L" for lorry, "B" for bus ...
     * is set in concrete class
     */
    private String m_label;
    /**
     * vehicle's length
     * is set in concrete class
     */
    private int m_length;



    public CVehicle(final Color p_color, final LinkedList p_route) {
        m_color = p_color;
    }
}
