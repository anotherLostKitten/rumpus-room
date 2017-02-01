import java.util.ArrayList;

public class ALTester {
    
    public static boolean sorted(ArrayList<Integer> a){
        for (int x = 1; x < a.size(); x ++){
            if (a.get(x) < a.get(x-1)){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        ArrayList<Integer> Arr = new ArrayList<Integer>();
        for (int x = 0; x < 23; x++){
            Arr.add(x);
        }
	//Arr.set(0, 10);

        System.out.println(sorted(Arr));
        
    }
}
