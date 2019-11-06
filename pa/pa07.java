import java.util.*;

public class pa7 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int numJobs = sc.nextInt(), myJob = sc.nextInt(), count = 0;
            int[] jobs = new int[numJobs];
            Queue<Integer> queue = new LinkedList<Integer>();
            for (int i = 0; i < numJobs; i++) {
                jobs[i] = sc.nextInt();
                queue.add(jobs[i])
            }

            Arrays.sort(jobs);

            while (numJobs-->0) {
                int job = queue.poll();
                if (myJob == 0 && job == jobs[numJobs]) {
                    break;
                } else if (job == jobs[numJobs]) {
                    count++;
                } else {
                    queue.add(job);
                    numJobs++;

                    if (myJob == 0) {
                        myJob = numJobs;
                    }
                }
                myJob--;
            }
            System.out.println(++count);
        }
    }
}