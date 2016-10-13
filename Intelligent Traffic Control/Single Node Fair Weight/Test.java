import java.util.ArrayList;
public class Test{
	
	private static Node[] init(){
		
		SubNode[][] subnodes = new SubNode[11][4];
		for(int i=0;i<11;i++){
			for(int j=0;j<4;j++){
				String id = String.valueOf(i+1) + String.valueOf('.') + String.valueOf(j+1);
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
			String id = String.valueOf(i+1);
			nodes[i] = new Node(id);
			//System.out.println(nodes[i].getId()+" : ");
			nodes[i].subnodes = new ArrayList<SubNode>();
			for(int j=0;j<4;j++){
				nodes[i].subnodes.add(subnodes[i][j]);
			}
		}
		
		return nodes;
		
		
	}
	
	public static void main(String[] args){
		
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
		
		graph[0].traffic = new ArrayList();
		graph[0].traffic.add(62);
		graph[0].traffic.add(80);
		graph[0].traffic.add(50);
		graph[0].traffic.add(48);
		
		float x1 = calculateAverageWaitingTime1(graph[0]);
		System.out.println("Average Waiting Time in Normal Case : \t"+x1);
		float x2 = calculateAverageWaitingTime2(graph[0]);
		System.out.println("Average Waiting Time in Case of Fair Weighted Green Light Timings : \t"+x2);
		float improvementPercentage = ((x1 - x2)/x1)*100;
		System.out.println("Improvement : "+improvementPercentage+"%");
		
	}
	
	public static float calculateAverageWaitingTime1(Node node){
		final int totalCycleTime = 120;   	//in seconds
		final int flowRatePerSec = 1;		//vehicles passing per second
		
		int a = node.traffic.get(0);
		int b = node.traffic.get(1);
		int c = node.traffic.get(2);
		int d = node.traffic.get(3);
		
		int totalTraffic = a+b+c+d;
		int totalWaitingTime = 0;
		int OnecyclePeriod = totalCycleTime/4;   //time alloted to one subnode
		int flowPerCycle = OnecyclePeriod*flowRatePerSec;
		
		int waitingTime = 0;
		while(a > 0){
			if(a >= flowPerCycle)
				totalWaitingTime += waitingTime*flowPerCycle;
			else
				totalWaitingTime += waitingTime*a;
			a = a-flowPerCycle;
			waitingTime += 120;
		}
		waitingTime = 30;
		while(b > 0){
			if(b >= flowPerCycle)
				totalWaitingTime += waitingTime*flowPerCycle;
			else
				totalWaitingTime += waitingTime*b;
			b = b-flowPerCycle;
			waitingTime += 120;
		}
		waitingTime = 60;
		while(c > 0){
			if(c >= flowPerCycle)
				totalWaitingTime += waitingTime*flowPerCycle;
			else
				totalWaitingTime += waitingTime*c;
			c = c-flowPerCycle;
			waitingTime += 120;
		}
		waitingTime = 90;
		while(d > 0){
			if(d >= flowPerCycle)
				totalWaitingTime += waitingTime*flowPerCycle;
			else
				totalWaitingTime += waitingTime*d;
			d = d-flowPerCycle;
			waitingTime += 120;
		}
		
		float averageWaitingTime = (float)totalWaitingTime/totalTraffic;
		return averageWaitingTime;
	}
	
	public static float calculateAverageWaitingTime2(Node node){
		final int totalCycleTime = 120;   	//in seconds
		final int flowRatePerSec = 1;		//vehicles passing per second
		
		int a = node.traffic.get(0);
		int b = node.traffic.get(1);
		int c = node.traffic.get(2);
		int d = node.traffic.get(3);
		
		int totalTraffic = a+b+c+d;
		int totalTraffic2 = a+b+c+d;
		int totalWaitingTime = 0;
		
		int waitingTime = 0;
		while(a > 0 && b > 0 && c > 0 && d > 0){
			//Now the cycle period will be allocated according to the traffic
			totalTraffic = a+b+c+d;
			int cyclePeriod1 = (int)(((float)totalCycleTime/totalTraffic)*a);   //time alloted to first subnode
			int cyclePeriod2 = (int)(((float)totalCycleTime/totalTraffic)*b);
			int cyclePeriod3 = (int)(((float)totalCycleTime/totalTraffic)*c);
			int cyclePeriod4 = totalCycleTime - (cyclePeriod1+cyclePeriod2+cyclePeriod3);
			//System.out.println(cyclePeriod1 +" "+cyclePeriod2+" "+cyclePeriod3+" "+cyclePeriod4);
			
			int flowPerCycle = cyclePeriod1*flowRatePerSec;
			if(a >= flowPerCycle)
				totalWaitingTime += waitingTime*flowPerCycle;
			else
				totalWaitingTime += waitingTime*a;
			a = a-flowPerCycle;
			waitingTime += cyclePeriod1;
		
			flowPerCycle = cyclePeriod2*flowRatePerSec;
			if(b >= flowPerCycle)
				totalWaitingTime += waitingTime*flowPerCycle;
			else
				totalWaitingTime += waitingTime*b;
			b = b-flowPerCycle;
			waitingTime += cyclePeriod2;
			
			flowPerCycle = cyclePeriod3*flowRatePerSec;
			if(c >= flowPerCycle)
				totalWaitingTime += waitingTime*flowPerCycle;
			else
				totalWaitingTime += waitingTime*c;
			c = c-flowPerCycle;
			waitingTime += cyclePeriod3;
			
			flowPerCycle = cyclePeriod4*flowRatePerSec;
			if(d >= flowPerCycle)
				totalWaitingTime += waitingTime*flowPerCycle;
			else
				totalWaitingTime += waitingTime*d;
			d = d-flowPerCycle;
			waitingTime += cyclePeriod4;
		}
		//System.out.println(totalWaitingTime);
		float averageWaitingTime = (float)totalWaitingTime/totalTraffic2;
		return averageWaitingTime;
	}
}






