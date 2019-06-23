package Lesson_4.Iterator;

import Lesson_4.LinkedList;
import Lesson_4.SimpleLinkedListImpl;

public class LinkedListIterator<E> implements ListIterator<E> {
    private SimpleLinkedListImpl list;

    private LinkedList.Entry<E> current;
    private LinkedList.Entry<E> previous;

    public LinkedListIterator(SimpleLinkedListImpl list) {
        this.list = list;
        reset();
    }

    @Override
    public void remove() {
        if (previous == null){
            list.firstElement = current.next;
            reset();
        } else {
            previous.next = current.next;
            if ( !hasNext() ) {
                reset();
            } else {
                current = current.next;
            }
        }
    }

    @Override
    public void reset() {
        current = list.firstElement;
        previous = null;
    }

    @Override
    public void insertBefore(E value) {
        LinkedList.Entry newItem = new LinkedList.Entry(value);
        if(previous == null) {
            newItem.next = list.firstElement;
            list.firstElement = newItem;
            reset();
        }
        else {
            newItem.next = previous.next;
            previous.next = newItem;
            current = newItem;
        }
    }

    @Override
    public void insertAfter(E value) {
        LinkedList.Entry newItem = new LinkedList.Entry(value);
        if(list.isEmpty()){
            list.firstElement = newItem;
            current = newItem;
        } else {
            newItem.next = current.next;
            current.next = newItem;
            next();
        }
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public E next() {
        E nextValue = current.value;
        previous = current;
        current = current.next;
        return nextValue;
    }
}
