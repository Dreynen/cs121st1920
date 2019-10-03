import java.util.*;
import java.io.*;

public class lab7a {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int N = Integer.parseInt(line);
        int[] arr = new int[N];

        line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        line = br.readLine();
        int Q = Integer.parseInt(line);

        line = br.readLine();
        st = new StringTokenizer(line);
        while(Q-->0) {
            int query = Integer.parseInt(st.nextToken());

            int mid = 0, l = 0, r = N - 1;
            while (l <= r) {
                mid = (l + r) / 2;
                if (arr[mid] == query) {
                    break;
                } else if (query < arr[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            boolean isSingleInteger = false, hasSmaller = true, hasLarger = true;
            int smaller = 0, larger = 0;

            if (arr[0] == arr[N-1]) {
                isSingleInteger = true;
            }

            if (query <= arr[0]) {
                hasSmaller = false;
            } else if (query >= arr[N - 1]) {
                hasLarger = false;
            }

            if (query < arr[mid]) {
                larger = arr[mid];
                if (hasSmaller) {
                    int temp = mid;
                    while (temp-->0) {
                        if (arr[temp] < query) {
                            smaller = arr[temp];
                            break;
                        }
                    }
                }
            } else if (query > arr[mid]) {
                smaller = arr[mid];
                if (hasLarger) {
                    int temp = mid;
                    while (temp++<N-1) {
                        if (arr[temp] > query) {
                            larger = arr[temp];
                            break;
                        }
                    }
                }
            } else if (query == arr[mid]) {
                if (isSingleInteger) {
                    hasSmaller = hasLarger = false;
                } else {
                    int temp;
                    if (hasSmaller) {
                        temp = mid;
                        while (temp-->0) {
                            if (arr[temp] != query) {
                                smaller = arr[temp];
                                break;
                            }
                        }
                    }

                    if (hasLarger) {
                        temp = mid;
                        while (temp++<N) {
                            if (arr[temp] != query) {
                                larger = arr[temp];
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println((hasSmaller ? smaller : "X") + " " + (hasLarger ? larger : "X"));
        }
    }
}