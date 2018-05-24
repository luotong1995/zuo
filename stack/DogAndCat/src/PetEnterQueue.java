public class PetEnterQueue {
    private Pet pet;
    private long count;//代表进来的时间戳

    public PetEnterQueue(Pet pet,long count){
        this.pet = pet;
        this.count = count;
    }
    public Pet getPet(){
        return this.pet;
    }
    public long getCount(){
        return this.count;
    }
    public String getEnterPetType() {
        return this.pet.getPetType();
    }
}
