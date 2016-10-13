

class FixedCycleTime{
	
	public static float calculateAverageWaitingTime(Node node){
		final int totalCycleTime = 120;   	//in seconds
		final int flowRatePerSec = 1;		//vehicles passing per second
		
		int a = node.subnodes.get(0).traffic;
		int b = node.subnodes.get(1).traffic;
		int c = node.subnodes.get(2).traffic;
		int d = node.subnodes.get(3).traffic;
		
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
	
	public static void run(Node[] nodes){
		Thread[] t = new Thread[nodes.length];
		for(int i=0;i<nodes.length;i++){
			t = new Thread(nodes[i]);
			t.start();
		}
	}
}