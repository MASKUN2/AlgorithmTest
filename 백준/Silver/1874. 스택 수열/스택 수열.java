import java.util.*;

public class Main{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int n = next();

        Stack<Integer> st = new Stack<>();

        List<String> r = new ArrayList<>();

        Queue<Integer> needs = getNeeds(n);
        int i = 1;
        for(int need : needs){
            while(i <= need){
                st.push(i++);
                r.add("+");
            }
            int top = st.pop();
            if(top != need){
                System.out.println("NO");
                return;
            }
            r.add("-");
        }
        
        r.forEach(System.out::println);
    }

    static int next(){
        return sc.nextInt();
    }
    
    static Queue<Integer> getNeeds(int n){
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
            q.offer(next());
        }
        return q;
    }
}
