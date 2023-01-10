package de.hebk.model.list;

import de.hebk.model.node.Node;

import java.io.Serializable;

/**
 * Objekte der Klasse List verwalten beliebig viele, linear angeordnete Objekte. Auf
 * höchstens ein Listenobjekt, aktuelles Objekt genannt, kann jeweils zugegriffen
 * werden. Wenn eine Liste leer ist, vollständig durchlaufen wurde oder das aktuelle
 * Objekt am Ende der Liste gelöscht wurde, gibt es kein aktuelles Objekt. Das erste
 * oder das letzte Objekt einer Liste können durch einen Auftrag zum aktuellen Objekt
 * gemacht werden. Außerdem kann das dem aktuellen Objekt folgende Listenobjekt
 * zum neuen aktuellen Objekt werden.
 * Das aktuelle Objekt kann gelesen, verändert oder gelöscht werden. Außerdem kann
 * vor dem aktuellen Objekt ein Listenobjekt eingefügt werden
 * @param <T>
 */
public class List<T> implements Serializable {
    private Node<T> first;
    private Node<T> aktuelleNode;
    private int size = 0;

    /**
     * Die Anfrage liefert den Wert true, wenn die Liste keine Objekte
     * enthält, sonst liefert sie den Wert false.
     * @return
     */
    public boolean isEmpty(){
        return first == null;
    }


    /**
     * Die Anfrage liefert den Wert true, wenn es ein aktuelles Objekt
     * gibt, sonst liefert sie den Wert false.
     * @return
     */
    public boolean hasAccess(){
        return aktuelleNode != null;
    }

    /**
     * Falls die Liste nicht leer ist, es ein aktuelles Objekt gibt und
     * dieses nicht das letzte Objekt der Liste ist, wird das dem
     * aktuellen Objekt in der Liste folgende Objekt zum aktuellen
     * Objekt, andernfalls gibt es nach Ausführung des Auftrags kein
     * aktuelles Objekt.
     */
    public void next(){
        if (!isEmpty() && aktuelleNode != null && aktuelleNode.getNext() != null){
            aktuelleNode = aktuelleNode.getNext();
        }
    }

    /**
     * Falls die Liste nicht leer ist, wird das erste Objekt der Liste
     * aktuelles Objekt. Ist die Liste leer, geschieht nichts
     */
    public void toFirst(){
        if (!isEmpty()){
            aktuelleNode = first;
        }
    }

    /**
     * Falls die Liste nicht leer ist, wird das letzte Objekt der Liste
     * aktuelles Objekt. Ist die Liste leer, geschieht nichts.
     */
    public void toLast(){
        if (!isEmpty()){
            Node<T> temp = first;

            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            aktuelleNode = temp;
        }
    }

    public void moveCurrent(int i){
        setCurrent(get(i));
    }


    public int size(){
        return size;
    }
    public Node<T> get(int index){
        Node<T> ret;
        if (index > size){
            ret = null;
        }

        Node<T> temp = first;
        for (int i = 0; i < index; i++){
            temp = temp.getNext();
        }
        ret = temp;
        return ret;
    }

    public boolean find(T value){
        boolean f = false;

        Node<T> temp = first;

        if (temp == null){
            return false;
        }

        if (temp.getContext() == value){
            return true;
        }

        while(temp.getNext() != null){
            if (temp.getContext() == value){
                f = true;
                break;
            }
            temp = temp.getNext();
        }

        if (temp.getContext() == value){
            return true;
        }

        return f;
    }

    /**
     * Falls es ein aktuelles Objekt gibt, wird das aktuelle Objekt
     * zurückgegeben, andernfalls gibt die Anfrage den Wert null
     * zurück.
     * @return
     */
    public T getCurrent(){
        if (!hasAccess()){
            return null;
        }
        return aktuelleNode.getContext();
    }

    /**
     * Falls es ein aktuelles Objekt gibt und value ungleich null ist,
     * wird das aktuelle Objekt durch value ersetzt.
     */
    public void setCurrent(Node<T> value){
        if (aktuelleNode != null && value != null){
            aktuelleNode = value;
        }
    }

    /**
     * Ein neues Objekt value wird am Ende der Liste angefügt.
     * Das aktuelle Objekt bleibt unverändert. Wenn die Liste leer ist,
     * wird das Objekt pObject in die Liste eingefügt und es gibt
     * weiterhin kein aktuelles Objekt.
     * Falls pObject gleich null ist, bleibt die Liste unverändert.
     */
    public void append(T value){
        if (value == null){
            return;
        }

        Node<T> n = new Node<>();
        n.setContext(value);

        if (isEmpty()){
            first = n;
            size++;
        } else {

            if (hasAccess()){
                Node<T> temp = aktuelleNode;
                while(temp.getNext() != null){
                    temp = temp.getNext();
                }
                temp.setNext(n);
                size++;

            } else{
                Node<T> temp = first;
                while(temp.getNext() != null){
                    temp = temp.getNext();
                }
                temp.setNext(n);
                size++;
            }
        }
    }

    /**
     * Falls es ein aktuelles Objekt gibt, wird ein neues Objekt vor
     * dem aktuellen Objekt in die Liste eingefügt. Das aktuelle Objekt
     * bleibt unverändert. Falls die Liste leer ist und es somit kein
     * aktuelles Objekt gibt, wird pObject in die Liste eingefügt und es
     * gibt weiterhin kein aktuelles Objekt. Falls es kein aktuelles
     * Objekt gibt und die Liste nicht leer ist oder value gleich null
     * ist, bleibt die Liste unverändert.
     */
    public void insert(T value){
        if (!hasAccess()) {
            return;
        }

        if (isEmpty()) {
            System.out.println("EMPTY");
            first = new Node<T>();
            first.setContext(value);
            size++;
            return;
        }

        if (aktuelleNode == first){
            Node<T> f = new Node<>();
            f.setContext(first.getContext());
            first.setContext(value);
            Node<T> nn = new Node<>();
            f.setNext(first.getNext());
            first.setNext(f);
            size++;
            return;
        }

        Node<T> temp = first;

        while(temp.getNext() != null && temp.getNext() != aktuelleNode){
            temp = temp.getNext();
        }
        Node<T> n = temp;
        temp.setNext(new Node<>());
        Node<T> nn = n.getNext();
        nn.setContext(value);
        nn.setNext(aktuelleNode);
        size++;
    }

    /**
     * Die Liste pList wird an die Liste angehängt. Das aktuelle Objekt
     * bleibt unverändert. Falls pList null oder eine leere Liste ist,
     * bleibt die Liste unverändert
     */
    public void concat(List<T> pList){
        if (pList == null || pList.isEmpty()){
            return;
        }

        if (isEmpty()){
            first = pList.first;
        }

        Node<T> temp = first;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(pList.first);
    }

    /**
     * Falls es ein aktuelles Objekt gibt, wird das aktuelle Objekt
     * gelöscht und das Objekt hinter dem gelöschten Objekt wird
     * zum aktuellen Objekt. Wird das Objekt, das am Ende der Liste
     * steht, gelöscht, gibt es kein aktuelles Objekt mehr. Wenn die
     * Liste leer ist oder es kein aktuelles Objekt gibt, bleibt die Liste
     * unverändert.
     */
    public void remove(){
        if (isEmpty() || !hasAccess()){
            return;
        }

        Node<T> temp = first;
        while(temp.getNext() != null && temp.getNext() != aktuelleNode){
            temp = temp.getNext();
        }

        if (aktuelleNode.getNext() == null){
            temp.setNext(null);
            aktuelleNode = null;
            size--;
            return;
        }

        temp.setNext(aktuelleNode.getNext());
        aktuelleNode = temp;
        size--;

    }


    public String toString() {
        String valueToReturn = "[";

        Node tmp = first;
        while (tmp != null) {
            valueToReturn += tmp.getContext();

            if (tmp.getNext() != null) {
                valueToReturn += " → ";
            }

            tmp = tmp.getNext();
        }

        valueToReturn += "]";

        return valueToReturn;
    }

}