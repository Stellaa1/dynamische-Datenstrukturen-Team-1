package de.hebk.model.node;

import java.io.Serializable;

/**
 * Generic Node
 * @param <T>
 */
public class Node<T> implements Serializable {

    private T context;
    private Node<T> next;


    /**
     * returns context of a node
     * @return
     */
    public T getContext(){
        return this.context;
    }

    /**
     * set the context of a node
     * @param pContext
     */
    public void setContext(T pContext){
        this.context = pContext;
    }

    /**
     * returns next node
     * @return
     */
    public Node<T> getNext(){
        return this.next;
    }

    /**
     * sets next node
     * @param pNode
     */
    public void setNext(Node<T> pNode){
        this.next = pNode;
    }
}