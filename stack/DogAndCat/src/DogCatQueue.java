import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue(){
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.catQ = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }
    public void add(Pet pet){
        if(pet.getPetType().equals("dog")){
            this.dogQ.add(new PetEnterQueue(pet,this.count++));
        }else if(pet.getPetType().equals("cat")){
            this.catQ.add(new PetEnterQueue(pet,this.count++));
        }else{
            throw new RuntimeException("Not cat and dog");
        }
    }
    public Pet poolAll(){
        if(!this.dogQ.isEmpty() && !this.catQ.isEmpty()){
            if(this.dogQ.peek().getCount() < this.catQ.peek().getCount()){
                return this.dogQ.poll().getPet();
            }else {
                return this.catQ.poll().getPet();
            }
        }else if(!this.dogQ.isEmpty()){
            return this.dogQ.poll().getPet();
        }else if(!this.catQ.isEmpty()){
            return this.catQ.poll().getPet();
        }else{
            throw new RuntimeException("Queue is empty");
        }
    }
    public Dog pollDog() {
        if(!this.isDogQeueEmpty()){
            return (Dog)this.dogQ.poll().getPet();
        }else{
            throw new RuntimeException("Dog queue is empty");
        }
    }
    public Cat pollCat() {
        if(!this.isCatQeueEmpty()){
            return (Cat)this.catQ.poll().getPet();
        }else{
            throw new RuntimeException("Cat queue is empty");
        }
    }
    public boolean isDogQeueEmpty(){
        return this.dogQ.isEmpty();
    }
    public boolean isCatQeueEmpty(){
        return this.catQ.isEmpty();
    }
    public boolean isEmpty(){
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }

    public static void main(String[] args){
        DogCatQueue q = new DogCatQueue();
        Dog d1 = new Dog();
        Dog d2 = new Dog();
        Dog d3 = new Dog();
        Dog d4 = new Dog();
        Cat c1 = new Cat();
        Cat c2 = new Cat();
        Cat c3 = new Cat();
        Cat c4 = new Cat();
        q.add(d1);
        q.add(c1);
        q.add(d2);
        q.add(c2);
        q.add(d3);
        q.add(c3);
        q.add(d4);
        q.add(c4);

        System.out.println(q.isEmpty() + " " + q.poolAll() + " " + q.pollCat());
    }

}
