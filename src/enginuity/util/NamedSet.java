package enginuity.util;

import enginuity.util.exception.NameableNotFoundException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class NamedSet<E> implements Set<E> {
    
    Vector<Nameable> objects = new Vector<Nameable>();
    
    public void add(Nameable n) {        
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getName().equalsIgnoreCase(n.getName())) {
                objects.remove(i);
                objects.add(i, n);
                return;
            }
        }
        objects.add(n);
    }
    
    public Nameable get(String name) throws NameableNotFoundException {
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getName().equalsIgnoreCase(name)) {
                return objects.get(i);
            }
        }    
        // Name not found, throw exception
        throw new NameableNotFoundException();
    }
    
    public Nameable get(Nameable n) throws NameableNotFoundException {
        return get(n.getName());
    }
    
    public int size() {
        return objects.size();
    }
    
    public void remove(Nameable n) throws NameableNotFoundException { 
        remove(n.getName());
    }
    
    public void remove(String name) throws NameableNotFoundException {
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getName().equalsIgnoreCase(name)) {
                objects.remove(i);
                return;
            }
        }            
        // Name not found, throw exception
        throw new NameableNotFoundException();
    }    

    public boolean isEmpty() {
        return objects.isEmpty();
    }

    public boolean contains(Object o) {
        return objects.contains(o);
    }

    public Iterator<E> iterator() {
        return (Iterator<E>)objects.iterator();
    }

    public Object[] toArray() {
        return objects.toArray();
    }

    public boolean add(E o) {
        add((Nameable) o);
        return true;
    }

    public boolean remove(Object o) {
        return objects.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return objects.containsAll(c);
    }

    public boolean addAll(Collection<? extends E> c) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            add((E)it.next());
        }
        return true;
    }

    public boolean retainAll(Collection<?> c) {
        return objects.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return objects.removeAll(c);
    }

    public void clear() {
        objects.clear();
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }
}