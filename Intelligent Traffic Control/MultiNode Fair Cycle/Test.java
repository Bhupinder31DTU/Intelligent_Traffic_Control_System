import java.util.*;
public class Test{
	
	private static Node[] init(){
		
		//Creating the subnodes
		SubNode[][] subnodes = new SubNode[11][4];
		for(int i=0;i<11;i++){
			for(int j=0;j<4;j++){
				String id = new Integer(i+1).toString() + String.valueOf('.') + new Integer(j+1).toString();
				subnodes[i][j] = new SubNode(id);
			}
		}
		
		//Creating the links between subnodes
		subnodes[0][0].left = subnodes[10][0];
		subnodes[0][0].right = subnodes[7][3];
		subnodes[0][0].straight = subnodes[8][0];
		subnodes[0][1].left = subnodes[8][0];
		subnodes[0][1].right = subnodes[1][0];
		subnodes[0][1].straight = subnodes[7][3];
		subnodes[0][2].left = subnodes[7][3];
		subnodes[0][2].right = subnodes[10][0];
		subnodes[0][2].straight = subnodes[1][0];
		subnodes[0][3].left = subnodes[1][0];
		subnodes[0][3].right = subnodes[8][0];
		subnodes[0][3].straight = subnodes[10][0];
		subnodes[1][0].left = subnodes[2][0];
		subnodes[1][0].right = subnodes[10][1];
		subnodes[1][0].straight = subnodes[9][0];
		subnodes[1][1].left = subnodes[0][0];
		subnodes[1][1].right = subnodes[9][0];
		subnodes[1][1].straight = subnodes[2][0];
		subnodes[1][2].left = subnodes[10][1];
		subnodes[1][2].right = subnodes[2][0];
		subnodes[1][2].straight = subnodes[0][0];
		subnodes[1][3].left = subnodes[9][0];
		subnodes[1][3].right = subnodes[0][0];
		subnodes[1][3].straight = subnodes[10][1];
		subnodes[2][0].left = subnodes[4][3];
		subnodes[2][0].right = subnodes[9][1];
		subnodes[2][0].straight = subnodes[3][0];
		subnodes[2][1].left = subnodes[1][3];
		subnodes[2][1].right = subnodes[3][0];
		subnodes[2][1].straight = subnodes[4][3];
		subnodes[2][2].left = subnodes[9][1];
		subnodes[2][2].right = subnodes[4][3];
		subnodes[2][2].straight = subnodes[1][3];
		subnodes[2][3].left = subnodes[3][0];
		subnodes[2][3].right = subnodes[1][3];
		subnodes[2][3].straight = subnodes[9][1];
		subnodes[3][0].left = subnodes[5][1];
		subnodes[3][0].right = subnodes[10][2];
		subnodes[3][0].straight = subnodes[4][0];
		subnodes[3][1].left = subnodes[2][2];
		subnodes[3][1].right = subnodes[4][0];
		subnodes[3][1].straight = subnodes[5][1];
		subnodes[3][2].left = subnodes[10][2];
		subnodes[3][2].right = subnodes[5][1];
		subnodes[3][2].straight = subnodes[2][2];
		subnodes[3][3].left = subnodes[4][0];
		subnodes[3][3].right = subnodes[2][2];
		subnodes[3][3].straight = subnodes[10][2];
		subnodes[4][0].left = subnodes[2][3];
		subnodes[4][0].right = subnodes[6][0];
		subnodes[4][0].straight = subnodes[5][0];
		subnodes[4][1].left = subnodes[3][2];
		subnodes[4][1].right = subnodes[5][0];
		subnodes[4][1].straight = subnodes[2][3];
		subnodes[4][2].left = subnodes[6][0];
		subnodes[4][2].right = subnodes[2][3];
		subnodes[4][2].straight = subnodes[3][2];
		subnodes[4][3].left = subnodes[5][0];
		subnodes[4][3].right = subnodes[3][2];
		subnodes[4][3].straight = subnodes[6][0];
		subnodes[5][0].left = subnodes[3][3];
		subnodes[5][0].right = subnodes[6][1];
		subnodes[5][0].straight = subnodes[7][0];
		subnodes[5][1].left = subnodes[7][0];
		subnodes[5][1].right = subnodes[4][2];
		subnodes[5][1].straight = subnodes[6][1];
		subnodes[5][2].left = subnodes[6][1];
		subnodes[5][2].right = subnodes[3][3];
		subnodes[5][2].straight = subnodes[4][2];
		subnodes[5][3].left = subnodes[4][2];
		subnodes[5][3].right = subnodes[7][0];
		subnodes[5][3].straight = subnodes[3][3];
		subnodes[6][0].left = subnodes[5][3];
		subnodes[6][0].right = subnodes[9][2];
		subnodes[6][0].straight = subnodes[7][1];
		subnodes[6][1].left = subnodes[7][1];
		subnodes[6][1].right = subnodes[4][1];
		subnodes[6][1].straight = subnodes[9][2];
		subnodes[6][2].left = subnodes[9][2];
		subnodes[6][2].right = subnodes[5][3];
		subnodes[6][2].straight = subnodes[4][1];
		subnodes[6][3].left = subnodes[4][1];
		subnodes[6][3].right = subnodes[7][1];
		subnodes[6][3].straight = subnodes[5][3];
		subnodes[7][0].left = subnodes[0][3];
		subnodes[7][0].right = subnodes[6][2];
		subnodes[7][0].straight = subnodes[8][3];
		subnodes[7][1].left = subnodes[5][2];
		subnodes[7][1].right = subnodes[8][3];
		subnodes[7][1].straight = subnodes[0][3];
		subnodes[7][2].left = subnodes[6][2];
		subnodes[7][2].right = subnodes[0][3];
		subnodes[7][2].straight = subnodes[5][2];
		subnodes[7][3].left = subnodes[8][3];
		subnodes[7][3].right = subnodes[5][2];
		subnodes[7][3].straight = subnodes[6][2];
		subnodes[8][0].left = subnodes[10][3];
		subnodes[8][0].right = subnodes[7][2];
		subnodes[8][0].straight = subnodes[9][3];
		subnodes[8][1].left = subnodes[9][3];
		subnodes[8][1].right = subnodes[0][2];
		subnodes[8][1].straight = subnodes[7][2];
		subnodes[8][2].left = subnodes[7][2];
		subnodes[8][2].right = subnodes[10][3];
		subnodes[8][2].straight = subnodes[0][2];
		subnodes[8][3].left = subnodes[0][2];
		subnodes[8][3].right = subnodes[9][3];
		subnodes[8][3].straight = subnodes[10][3];
		subnodes[9][0].left = subnodes[2][1];
		subnodes[9][0].right = subnodes[8][2];
		subnodes[9][0].straight = subnodes[6][3];
		subnodes[9][1].left = subnodes[6][3];
		subnodes[9][1].right = subnodes[1][2];
		subnodes[9][1].straight = subnodes[8][2];
		subnodes[9][2].left = subnodes[8][2];
		subnodes[9][2].right = subnodes[2][1];
		subnodes[9][2].straight = subnodes[1][2];
		subnodes[9][3].left = subnodes[1][2];
		subnodes[9][3].right = subnodes[6][3];
		subnodes[9][3].straight = subnodes[2][1];
		subnodes[10][0].left = subnodes[1][1];
		subnodes[10][0].right = subnodes[8][1];
		subnodes[10][0].straight = subnodes[3][1];
		subnodes[10][1].left = subnodes[3][1];
		subnodes[10][1].right = subnodes[0][1];
		subnodes[10][1].straight = subnodes[8][1];
		subnodes[10][2].left = subnodes[8][1];
		subnodes[10][2].right = subnodes[1][1];
		subnodes[10][2].straight = subnodes[0][1];
		subnodes[10][3].left = subnodes[0][1];
		subnodes[10][3].right = subnodes[3][1];
		subnodes[10][3].straight = subnodes[1][1];
		
		
		//Putting the subnodes in nodes
		Node[] nodes = new Node[11];
		for(int i=0;i<11;i++){
			int tempj = i +1 ;
			String id = String.valueOf(tempj);
			nodes[i] = new Node(id);
			//System.out.println(nodes[i].getId()+" : ");
			nodes[i].subnodes = new ArrayList<SubNode>();
			for(int j=0;j<4;j++){
				nodes[i].subnodes.add(subnodes[i][j]);
			}
		}
		
		//Entering the traffic at every subnode
		Random r = new Random(1234);
		for(Node node:nodes){
			for(SubNode sub: node.subnodes){
				int n = r.nextInt(60) + 20;				//range is 20 to 80
				sub.currentTraffic = n;
				sub.traffic = new ArrayList<Traffic>();
				System.out.print(n+"  ");
			}
		}

		return nodes;
		
		
	}
	
	public static void main(String[] args) throws Exception{
		
		Node[] graph = init();
		
		//Testing of the graph
		/*for(int i=0;i<graph.length;i++){
			System.out.println(graph[i].getId()+" : ");
			for(int j=0;j<4;j++){
				SubNode s = graph[i].subnodes.get(j);
				System.out.print(s.getId()+" : ");
				System.out.println("Left: "+s.left.getId() +" Right: "+s.right.getId()+" Straight: "+s.straight.getId());
			}
		}*/
		
		/*System.out.println("Node Number\tFixed Cycle Time : Waiting Time\tFair Cycle Time : Waiting Time");
		for(Node n:graph){
			System.out.print(nodeCount++);
			float x1 = FixedCycleTime.calculateAverageWaitingTime(n);
			System.out.print(x1+"\t");
			float x2 = FairCycleTime.calculateAverageWaitingTime(n);
			System.out.println(x2+"\n");
		}*/
		
		for(int i=0;i<11;i++) {
			graph[i].start();
		}
		
		long time=0;
		//Thread.sleep(60*1000);
		//System.out.println("Time\tNode1\tNode2");
		while(time <= 300) {
			System.out.println("Time : "+time);
			for(int i=0;i<11;i++) {
				System.out.print("Node "+(i+1)+" : "+graph[i].getCurrentTraffic(time)+"    ");
			}
			System.out.println("");
			try {
				Thread.sleep(30*1000);
			} catch(Exception e) {
				System.out.println("Exception Caught : " + e.getMessage());
			}
			time += 30;
		}
	}
	
}