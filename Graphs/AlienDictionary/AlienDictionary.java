import java.util.*;
class AlienDictionary
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<26; i++){
            adjList.add(new ArrayList<Integer>());
        }

        for(int i=0; i<N-1; i++){
            int len = Math.min(dict[i].length(), dict[i+1].length());
            for(int j=0; j<len; j++){
                char ch = dict[i].charAt(j);
                char ch1 = dict[i+1].charAt(j);

                if(ch != ch1){
                    int k = ch - 'a';
                    int l = ch1 - 'a';

                    adjList.get(k).add(l);
                    break;
                }
            }
        }


        int[] indegrees = new int[K];

        for(ArrayList<Integer>list: adjList){
            for(int i=0; i<list.size(); i++){
                indegrees[list.get(i)]++;
            }
        }

        int[] topoSort = new int[N];

        Queue<Integer>q = new LinkedList<>();
        for(int i=0; i<K; i++){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }

        int[] ans = new int[K];
        int k = 0;
        while(q.size() > 0){
            int x = q.poll();
            ans[k++] = x;

            for(Integer i: adjList.get(x)){

                indegrees[i]--;
                if(indegrees[i] == 0){
                    q.add(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<ans.length; i++){
            sb.append((char)(ans[i]+'a'));
        }
        // System.out.println(sb);
        return sb.toString();
    }
}