/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrossing;

/**
 *
 * @author Adel
 */
public interface Observabler {
    public void addObserver(Observerr listener);
    public void removeobserver(Observerr listener);
    public void setMoves(int moves);
    public void notifyallobservers();
}
