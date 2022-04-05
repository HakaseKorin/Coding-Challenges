package project.CodingChallenge;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T>{
    private T[] items;
    private int head;
    private int count;

    public CircularArray(int size){
        this.items = (T[]) new Object[size];
        this.head = 0;
        this.count = 0;
    }

    public int size(){ return items.length;}

    public int getHead(){return head;}

    public void incrHead(){
        head = (head+1)%items.length;
    }

    public void rotateForward(){
        incrHead();
    }

    public void rotateBackward(){
        head--;
        if(head < 0)
            head = size()-1;
    }

    public void add(T item){
        if(isFull())
            resizeArray();

        int index = ((head+count)%items.length);
        items[index] = item;
        count++;
    }

    public T get(int index){
        return items[index];
    }

    public void pop(){
        items[head] = null;
        incrHead();
        count--;
   }

   public void resizeArray(){
       T[] newList = (T[]) new Object[items.length*2];
       for (int i = 0; i < size(); i++)
           newList[i] = items[i];
       this.items = newList;
   }

   public boolean isFull(){
        return (count == size());
   }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }

    private class ListIterator implements Iterator<T>{
        private CircularArray<T> list;
        private int index;

        public ListIterator(CircularArray<T> list){
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return (index < list.count);
        }

        @Override
        public T next() {
            return list.get(index++);
        }
    }
}
