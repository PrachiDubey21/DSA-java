import java.util.*;

public class jobSequence {

    static class job {
        int deadline;
        int profit;
        int id;

        public job(int d, int p, int i) {
            deadline = d;
            profit = p;
            id = i;
        }
    }

    public static void main(String[] args) {

        int jobsinfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

        ArrayList<job> jobs  = new ArrayList<>();

        for (int i = 0; i < jobsinfo.length; i++) {
            jobs.add(new job(jobsinfo[i][0], jobsinfo[i][1], i));
        }

        //for sorting in descending order
        Collections.sort(jobs , (a,b) -> b.profit - a.profit);

        ArrayList<Integer> list = new ArrayList<>();
        
        int time = 0;

        for(int i=0;i<jobs.size() ; i++){
            job curr = jobs.get(i);

            if(curr.deadline > time){
                list.add(curr.id);
                time++; 
            }
        }

        System.out.println("total jobs are : " + list.size());
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

}
