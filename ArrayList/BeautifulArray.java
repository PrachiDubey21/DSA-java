import java.util.ArrayList;

public class BeautifulArray {

    public static ArrayList<Integer> beautifulArray(int n) {

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);   // starting array

        for (int i = 2; i <= n; i++) {

            ArrayList<Integer> temp = new ArrayList<>();

            // first add even numbers
            for (int j = 0; j < ans.size(); j++) {
                int val = ans.get(j) * 2;
                if (val <= n) {
                    temp.add(val);
                }
            }

            // then add odd numbers
            for (int j = 0; j < ans.size(); j++) {
                int val = ans.get(j) * 2 - 1;
                if (val <= n) {
                    temp.add(val);
                }
            }

            ans = temp;
        }

        return ans;
    }

    // main function
    public static void main(String[] args) {

        int n = 5;
        ArrayList<Integer> result = beautifulArray(n);

        System.out.println("Beautiful Array for n = " + n + " : " + result);
    }
}
