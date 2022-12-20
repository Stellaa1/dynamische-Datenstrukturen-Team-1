package de.hebk.model.stack;

import de.hebk.model.node.Node;

public class Stack<T> {
    private Node<T> first;

    /**
     * Checks if the list is empty
     * @return true or false
     */
    public boolean isEmpty(){

        return first == null;
    }

    /**
     * Das Objekt pObject wird oben auf den Stapel gelegt. Falls
     * pObject gleich null ist, bleibt der Stapel unverändert.
     * @param pInhalt
     */
    public void push(T pInhalt){
        if(pInhalt!=null){
            Node<T> tmp;

            if(first!=null) {
                tmp = first;
                first = new Node<T>();
                first.setContext(pInhalt);
                first.setNext(tmp);
                tmp = first.getNext();

            }else{
                first=new Node<T>();
                first.setContext(pInhalt);
            }


        }
    }

    /**
     * Das zuletzt eingefügte Objekt wird von dem Stapel entfernt.
     * Falls der Stapel leer ist, bleibt er unverändert
     * @return
     */
    public T pop(){
        if(!isEmpty()){
            first=first.getNext();
        }
        return null;
    }

    /**
     * Die Anfrage liefert das oberste Stapelobjekt. Der Stapel bleibt
     * unverändert. Falls der Stapel leer ist, wird null zurückgegeben.
     * @return
     */
    public T top(){
        if(isEmpty()){
            return null;
        }else{
            return first.getContext();
        }
    }

    public T last(){
        Node<T> tmp = first;
        if(isEmpty()){
            return null;
        }else{
            while(tmp.getNext() != null){
                tmp = tmp.getNext();
            }
            return tmp.getContext();
        }
    }

    /**
     * Returns String representation of List
     * @return
     */
    public String toString(){
        String ret = "[";
        Node tmp = first;

        while (tmp != null){
            if(tmp.getNext() == null){
                ret = ret + tmp.getContext();
            }else {
                ret = ret + tmp.getContext() + ";";
            }
            tmp = tmp.getNext();
        }


        ret = ret + "]";
        return ret;
    }

}
