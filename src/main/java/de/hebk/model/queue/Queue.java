package de.hebk.model.queue;

import de.hebk.model.node.Node;

/**
 * Objekte der Klasse Queue (Warteschlange) verwalten beliebige Objekte nach dem
 * First-In-First-Out-Prinzip, d.h., das zuerst abgelegte Objekt wird als erstes wieder
 * entnommen.
 * @param <T>
 */
public class Queue<T> {

    private Node<T> first;

    /**
     * Die Anfrage liefert den Wert true, wenn die Schlange keine
     * Objekte enthält, sonst liefert sie den Wert false.
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * Das Objekt pObject wird an die Schlange angehängt. Falls
     * pObject gleich null ist, bleibt die Schlange unverändert
     */
    public void enqueue(T pObject){
        if(pObject != null) {
            Node<T> tmp = first;

            if(pObject != null) {
                if (first == null) {
                    first = new Node<T>();
                    first.setContext(pObject);
                } else {
                    while (tmp.getNext() != null) {
                        tmp = tmp.getNext();
                    }
                    Node<T> tmp2 = new Node<T>();
                    tmp2.setContext(pObject);
                    tmp.setNext(tmp2);
                }
            }

        }
    }


    /**
     * Das erste Objekt wird aus der Schlange entfernt. Falls die
     * Schlange leer ist, wird sie nicht verändert.
     */
    public void dequeue(){
        if (first != null) {
            first = first.getNext();
        }
    }

    /**
     * Die Anfrage liefert das erste Objekt der Schlange. Die
     * Schlange bleibt unverändert. Falls die Schlange leer ist, wird
     * null zurückgegeben.
     */
    public T front(){
        if(first != null) {
            return first.getContext();
        }
        return null;
    }
}