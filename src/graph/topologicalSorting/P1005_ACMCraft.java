package graph.topologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1005_ACMCraft {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder builder = new StringBuilder();
    public static int[][] buildingRule;
    public static List<Building> buildingList;
    public static Queue<Building> queue = new LinkedList();
    public static List<Integer> resultList = new ArrayList();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            buildingRule = new int[K][2];
            buildingList = new ArrayList();
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int buildingTime = Integer.parseInt(st.nextToken());
                buildingList.add(new Building(j, buildingTime));
            }
            for(int k=0; k<K; k++){
                st = new StringTokenizer(br.readLine());
                int requiredBuildingNum =  Integer.parseInt(st.nextToken()) - 1;
                int buildingNum  = Integer.parseInt(st.nextToken()) - 1;
                Building building = buildingList.get(buildingNum);
                building.requiredBuindNum.add(requiredBuildingNum);
            }
            st = new StringTokenizer(br.readLine());
            int victoryBuildingNum = Integer.parseInt(st.nextToken()) - 1;
            queue = new LinkedList();
            for(int l=0; l<buildingList.size(); l++){
                Building building = buildingList.get(l);
                if(building.requiredBuindNum.isEmpty())
                    queue.add(building);
            }

            while(!queue.isEmpty()){
                Building building = queue.poll();
                if(building.buildingNum == victoryBuildingNum){
                    resultList.add(building.thisBuildingTime);
                    break;
                }
                if(building.visit)
                    continue;
                building.visit = true;
                for(Building tagetBuilding : buildingList){
                    tagetBuilding.completedRequiredBuilding(building.buildingNum);
                }
            }

        }
        for(int result : resultList){
           System.out.println(result);
        }
    }
    static class Building{
        int buildingNum;
        Set<Integer> requiredBuindNum = new HashSet();
        int maxRequiredBuildingTime = 0;
        int thisBuildingTime;
        boolean visit = false;
        Building(int buildingNum, int thisBuildingTime){
            this.buildingNum = buildingNum;
            this.thisBuildingTime = thisBuildingTime;
        }
        void completedRequiredBuilding(int buildingNum){
            if(this.requiredBuindNum.contains(buildingNum)){
                Building building = buildingList.get(buildingNum);
                if(maxRequiredBuildingTime < building.thisBuildingTime)
                    maxRequiredBuildingTime = building.thisBuildingTime;
                requiredBuindNum.remove(buildingNum);
                if(this.requiredBuindNum.isEmpty() && !this.visit) {
                    thisBuildingTime += maxRequiredBuildingTime;
                    queue.add(this);
                }
            }
        }


    }


}
