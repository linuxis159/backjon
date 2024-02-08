package graph.topologicalSorting;

import javax.security.auth.Subject;
import java.util.*;

public class P14567_선수과목 {
    private static Scanner sc = new Scanner(System.in);
    private static Map<Integer, Node> subjectMap = new HashMap();
    private static Queue<Integer> targetSubject = new LinkedList();
    private static int currentSemester = 0;
    public static void main(String[] args){
        int N = sc.nextInt();
        int M = sc.nextInt();
        for(int i=1; i<=N; i++){
            Node node = new Node(i);
            subjectMap.put(i, node);
        }
        for(int i=0; i<M; i++){
            int requiredSubject = sc.nextInt();
            int subject = sc.nextInt();

            Node subjectNode;

            subjectNode = subjectMap.get(subject);

            subjectNode.addRequiredSubejct(requiredSubject);

        }

        while(true) {
            setTargetNode();
            if(targetSubject.isEmpty())
                break;

                while (!targetSubject.isEmpty()) {
                    Node requiredSubject = subjectMap.get(targetSubject.poll());
                    for(int subject : subjectMap.keySet()){
                        Node subjectNode = subjectMap.get(subject);
                        if(subjectNode.requiredSubject.contains(requiredSubject.subjectNum))
                            subjectNode.requiredSubject.remove(requiredSubject.subjectNum);
                    }
                }
        }
        for(int i=1; i<=N; i++){
            Node subject = subjectMap.get(i);
            System.out.print(subject.semester + " ");
        }


    }
    static void setTargetNode(){
        currentSemester++;
        for(int subject : subjectMap.keySet()){
            Node subjectNode = subjectMap.get(subject);
            if(subjectNode.requiredSubject.isEmpty() && !subjectNode.visit){
                targetSubject.add(subject);
                subjectNode.semester = currentSemester;
                subjectNode.visit = true;
            }
        }
    }
    private static class Node{
        int subjectNum;
        int semester;
        boolean visit = false;
        Set<Integer> requiredSubject = new HashSet();
        Node(int subjectNum){
            this.subjectNum = subjectNum;
        }
        void addRequiredSubejct(int subjectNum){
            requiredSubject.add(subjectNum);
        }


    }

}
