class Link5{
    public String name;
    public int age;

    public Link5 next;

    public Link5(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void display(){
        System.out.println("Name: "+this.name+", age: "+this.age);
    }
}
class LinkedList5{
    private Link5 first;


    public LinkedList5(){
        first = null;

    }

    public Link5 getFirst() {
        return first;
    }

    public void setFirst(Link5 first) {
        this.first = first;
    }

    public LinkInterator getIterator(){
        return new LinkInterator(this);
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void display(){
        Link5 current = first;
        while(current != null){
            current.display();
            current = current.next;
        }
    }
}

class LinkInterator{
    private Link5 current;
    private Link5 previous;
    private LinkedList5 list;

    public LinkInterator(LinkedList5 list){
        this.list = list;
        this.reset();
    }

    public void reset(){
        current = list.getFirst();
        previous = null;
    }

    public boolean atEnd(){
        return (current.next == null);
    }

    public void nextLink(){
        previous = current;
        current = current.next;
    }

    public Link5 getCurrent(){
        return current;
    }

    public void insertAfter(String name, int age){
        Link5 newLink = new Link5(name, age);
        if (list.isEmpty()){
            list.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }

    public void insertBefore(String name, int age){
        Link5 newLink = new Link5(name, age);
        if(previous == null){
            newLink.next = list.getFirst();
            list.setFirst(newLink);
            reset();
        }
        else{
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    public String deleteCurrent(){
        String name = current.name;
        if (previous == null){
            list.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd()){
                reset();
            } else {
                current = current.next;
            }
        }

        return name;
    }

}

public class LinkIteratorApp {


    public static void main(String[] args) {
        LinkedList5 list = new LinkedList5();
        LinkInterator itr = new LinkInterator(list);
        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);
        list.display();
        System.out.println(itr.getCurrent().name+" "+ itr.getCurrent().age);
        itr.nextLink();
        System.out.println(itr.getCurrent().name+" "+ itr.getCurrent().age);

        System.out.println(itr.atEnd());
        itr.reset();
        System.out.println(itr.getCurrent().name+" "+ itr.getCurrent().age);
        itr.deleteCurrent();
        list.display();
    }
}
