public class HanoiDigui {

    public static void move(int n, String source, String des, String temp){
        if(n == 1){
            System.out.printf("move %d from %s to %s \n", n, source, des);
        }else{
            move(n-1, source, temp, des);
            System.out.printf("move %d from %s to %s \n", n, source, temp);
            move(n-1, temp, des, source);
        }
    }

    public static void main(String[] args){
        move(3, "a", "c", "b");
    }
}
