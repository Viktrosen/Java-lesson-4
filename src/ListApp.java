

class Link2{
    public String name;
    public int age;

    public Link2 next;

    public Link2(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void display(){
        System.out.println("Name: "+this.name+", age: "+this.age);
    }
}
class LinkedList2{
    public Link2 first;
    public Link2 last;

    public LinkedList2(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insert(String name, int age){
        Link2 newLink = new Link2(name, age);
        if (this.isEmpty())
            last = newLink;
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(String name, int age){
        Link2 newLink = new Link2(name, age);
        if (this.isEmpty()){
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }
    public Link2 delete(){

        Link2 temp = first;
        if (first.next == null)
            last = null;
        first = first.next;
        return temp;

    }

    public void display(){
        Link2 current = first;
        while(current != null){
            current.display();
            current = current.next;
        }
    }
    public Link2 find(String name){
        Link2 current = first;
        while(current.name != name){
            if(current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public Link2 delete(String name){
        Link2 current = first;
        Link2 previous = first;
        while(current.name != name){
            if(current.next == null)
                return null;
            else{
                previous = current;
                current = current.next;
            }
        }
        if(current == first)
            first = first.next;
        else
            previous.next = current.next;
        return current;
    }



}


public class ListApp {

    public static void main(String[] args) {
        LinkedList2 list = new LinkedList2();
        list.insert("Artem", 30);
        list.insert("Misha", 10);
        list.insert("Vova", 5);
        list.insertLast("Petya", 25);

        list.display();
        System.out.println("Удаление элементов списка");

        list.delete("Vova");
        list.display();
    }
}
