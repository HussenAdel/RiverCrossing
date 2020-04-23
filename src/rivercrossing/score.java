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
public class score implements Observerr{
private int score=0;

    public int getScore() {
        return score;
    }
    @Override
    public void update() {
       this.score++;
    }

    @Override
    public void setObservabler(Observabler ob) {
        ob.addObserver(this);
    }
    
}
