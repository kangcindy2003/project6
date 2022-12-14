public class algs {
    int len;
    int[] dis = new int [len];

    int minmum (boolean[] visit) {

        int min = Integer.MAX_VALUE;
        int min_index = 0;
        for (int i = 0; i < len; i += 1) {
            if (visit[i] == false && dis[i]<min){
                min = dis[i];
                min_index = i;
            }
        }
        return min_index;
    }
    void name(int[][] graph, int start){
        len = graph.length;
        int[] dis = new int[len];
        this.dis = dis;
        boolean [] visit = new boolean[len];

        for (int i = 0; i < len; i+=1) {
            dis[i] = Integer.MAX_VALUE;
            visit[i] = false;
        }

        dis[start] = 0;

        for (int i = 0; i < len; i+=1) {
            int now = minmum(visit);
            visit [now] = true;
            for (int j = 0; j < len; j+=1) {
                if(visit[j] == false && graph[now][j] != 0 && dis[j]>dis[now] && dis[j] + graph[j][now] < dis[j]) {
                    dis[j] = dis[now] + graph[now][j];
                }

            }
        }

    }

    void print() {
        System.out.println("Index:\t\t Distance:");
        for (int i=0; i<len; i+=1){
            System.out.println(i + "\t\t\t" + dis[i]);
        }
    }

}
