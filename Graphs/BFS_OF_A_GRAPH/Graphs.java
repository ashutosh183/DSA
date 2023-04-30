import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Graphs {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int vts = sc.nextInt();

            ArrayList<Edge>[] graph = new ArrayList[vts+1];

            for(int i=0; i<=vts; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i=0; i<=vts; i++){
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();

                graph[v1].add(new Edge(v1, v2));
                graph[v2].add(new Edge(v2, v1));
            }
            bfsTraversal(graph);
            display(graph);
        }
        static void display(ArrayList<Edge>[] graph){
            int vts = graph.length;
            for (int i=0; i<vts; i++) {
                System.out.println("i: "+" "+i);
                for (Edge e : graph[i]){
                    System.out.print(e.src + " " + e.nbr);
                    System.out.println();
                }
            }
        }

        static void bfsTraversal(ArrayList<Edge>[] graph){
            Queue<Integer> q = new ArrayDeque<>();
            int n = graph.length;
            q.add(0);
            ArrayList<Integer> ans = new ArrayList<>();
            boolean[] visited = new boolean[n];
            while(q.size() > 0){
                int x = q.remove();
                if(visited[x]){
                    continue;
                }

                visited[x] = true;
                ans.add(x);
                for(Edge e: graph[x]){
                    q.add(e.nbr);
                }
            }

            for(Integer ele: ans){
                System.out.print("Element: "+ele);
            }
            System.out.println();
        }
    }
