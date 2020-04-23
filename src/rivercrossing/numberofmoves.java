/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrossing;

import java.util.ArrayList;
/**
 *
 * @author Adel
 */
public class numberofmoves implements Observabler{
private ArrayList<Observerr> observers = new ArrayList(15);
private int moves=0;
private int i;
@Override
    public void addObserver(Observerr listener) {
       observers.add(listener);
    }

@Override
    public void removeobserver(Observerr listener) {
              observers.remove(listener);

    }

@Override
    public void setMoves(int moves) {
        this.moves=moves;
     if (this.moves>15)
      {    
        notifyallobservers();
       }
     else if (this.moves>12)
     {
         notifyallobservers();
         notifyallobservers();
     }
     else
     {
          notifyallobservers();
         notifyallobservers();
         notifyallobservers();
     }
       
    }
@Override
    public void notifyallobservers()
    {
       for (i=0;i<observers.size();i++)
       {
           observers.get(i).update();
       }
    }

}
