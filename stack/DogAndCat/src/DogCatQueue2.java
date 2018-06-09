import java.util.*;


public class DogCatQueue2 {
    private Queue<PetEnterQueue> dogQ = null;
    private Queue<PetEnterQueue> catQ = null;
    private int count;

    public DogCatQueue2(){
        this.dogQ = new LinkedList<>();
        this.catQ = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet){
        if(pet.getPetType().equals("dog")){
            this.dogQ.add(new PetEnterQueue(pet, this.count ++));
        }else if(pet.getPetType().equals("cat")){
            this.catQ.add(new PetEnterQueue(pet, this.count ++));
        }else{
            throw new RuntimeException("Not cat and dog");
        }
    }

    public Pet pollDog(){
        if(!isDogEmpty()) {
            Dog dog = (Dog) dogQ.poll().getPet();
            return dog;
        }else{
            throw new RuntimeException("Dog que is empty");
        }
    }

    public Pet pollCat(){
        if(!isCatEmpty()) {
            Cat cat = (Cat) catQ.poll().getPet();
            return cat;
        }else{
            throw new RuntimeException("Cat que is empty");
        }
    }

    public Pet poll() {
        if (!isDogEmpty() && isCatEmpty()) {
            return dogQ.poll().getPet();
        } else if (!isCatEmpty() && isDogEmpty()) {
            return catQ.poll().getPet();
        } else if (!isDogEmpty() && !isCatEmpty()) {
            PetEnterQueue dogEnt = catQ.peek();
            PetEnterQueue catEnt = catQ.peek();
            if (dogEnt.getCount() < catEnt.getCount()) {
                return dogQ.poll().getPet();
            } else {
                return catQ.poll().getPet();
            }
        } else {
            throw new RuntimeException("que is empty");
        }
    }

    public Boolean isEmpty(){
        if(this.catQ.isEmpty() && this.dogQ.isEmpty()){
            return true;
        }
        return false;
    }

    public Boolean isDogEmpty(){
        if (this.dogQ.isEmpty()){
            return true;
        }
        return false;
    }

    public Boolean isCatEmpty(){
        if (this.catQ.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
       System.out.print(11);
    }
}
