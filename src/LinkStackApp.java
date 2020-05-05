class Link3{
    public String name;
    public int age;

    public Link3 next;

    public Link3(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void display(){
        System.out.println("Name: "+this.name+", age: "+this.age);
    }
}

class LinkedList3{
    public Link3 first;

    public LinkedList3(){
        first = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insert(String name, int age){
        Link3 newLink = new Link3(name, age);
        newLink.next = first;
        first = newLink;
    }

    public Link3 delete(){

        Link3 temp = first;
        first = first.next;
        return temp;

    }

    public void display(){
        Link3 current = first;
        while(current != null){
            current.display();
            current = current.next;
        }
    }
}

class StackList{
    private LinkedList3 list;
    public StackList(){
        list = new LinkedList3();
    }

    public void push(String name, int age){
        list.insert(name, age);
    }

    public String pop(){
        return list.delete().name;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void display(){
        list.display();
    }

}


public class LinkStackApp {


    public static void main(String[] args) {
        StackList sl = new StackList();
        sl.push("Artem", 30);
        sl.push("Viktor", 20);
        sl.push("Sergey", 10);
        sl.display();
        while (!sl.isEmpty()) {
            System.out.println("Элемент "+ sl.pop()+" удален из стека");
        }
    }
}



