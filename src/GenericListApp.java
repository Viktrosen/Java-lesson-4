import java.util.Objects;

class People {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + this.age;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final People other = (People) obj;
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Name: "+this.name+", age: "+this.age;
    }
}

class Link<T> {
    public T link;
    public Link<T> next;

    public Link(T link){
        this.link = link;
    }


    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    public T getValue(){
        return link;
    }
}

class LinkedList<T> {
    private Link<T> first;





    public LinkedList(){
        first = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insert(T link){
        Link<T> l = new Link<>(link);
        l.setNext(first);
        this.first = l;
    }

    public Link<T> delete(){
        Link<T> temp = first;
        first = first.getNext();
        return temp;
    }

    public void display(){
        Link<T> current = first;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }



    public T find(T searchNode){
        Link<T> findNode = new Link<>(searchNode);
        Link<T> current = first;
        while (current != null) {
            if (current.getValue().equals(findNode.getValue())){
                return findNode.getValue();
            }
            current = current.getNext();
        }
        return null;
    }
}


public class GenericListApp {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.insert("Artem");
        list.insert("Roman");

        System.out.println(list.find("Artem"));

        LinkedList<People> peopleList = new LinkedList<>();
        peopleList.insert(new People("Artem", 22));
        peopleList.insert(new People("Roman", 18));

        System.out.println(peopleList.find(new People("Artem", 22)).toString());
    }
}
