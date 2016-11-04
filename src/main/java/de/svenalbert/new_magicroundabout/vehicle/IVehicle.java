package de.svenalbert.new_magicroundabout.vehicle;

import java.util.concurrent.Callable;

/**
 * Created by sven on 04.11.16.
 */
public interface IVehicle extends Callable<IVehicle> {

    /**
     * lets the vehicle move
     */
    void move();

    /**
     * returns boolean value if vehicle reached end of its route
     * @return
     */
    boolean canRemove();

}
