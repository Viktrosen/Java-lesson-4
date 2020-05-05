class Link4{
    public String name;
    public int age;

    public Link4 next;

    public Link4(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void display(){
        System.out.println("Name: "+this.name+", age: "+this.age);
    }
}

class LinkedList4{
    public Link4 first;
    public Link4 last;

    public LinkedList4(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insert(String name, int age){
        Link4 newLink = new Link4(name, age);
        if (this.isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }

    public String delete(){
        Link4 temp = first;
        if (first.next == null)
            last = null;
        first = first.next;
        return temp.name;

    }

    public void display(){
        Link4 current = first;
        while(current != null){
            current.display();
            current = current.next;
        }
    }
}

class Queue{
    private LinkedList4 queue;

    public Queue(){
        queue = new LinkedList4();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void insert(String name, int age){
        queue.insert(name, age);
    }

    public String delete(){
        return queue.delete();
    }

    public void display(){
        queue.display();
    }

}


public class LinkQueueApp {


    public static void main(String[] args) {
        Queue q = new Queue();
        q.insert("Artem", 30);
        q.insert("Viktor", 20);
        q.insert("Sergey", 10);
        q.display();
        while (!q.isEmpty()) {
            System.out.println("Элемент "+ q.delete()+" удален из стека");
        }
    }

}
