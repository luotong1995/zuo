public class Pet {
    private String type;
    public Pet(String type){
        this.type = type;
    }
    public String getPetType() {
        return this.type;
    }

    @Override
    public String toString() {

        return this.type;
    }
}
