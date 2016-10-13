

class FairCycleTime{
	
	public static float calculateAverageWaitingTime(Node node){
		final int totalCycleTime = 120;   	//in seconds
		final int flowRatePerSec = 1;		//vehicles passing per second
		
		int a = node.subnodes.get(0).traffic;
		int b = node.subnodes.get(1).traffic;
		int c = node.subnodes.get(2).traffic;
		int d = node.subnodes.get(3).traffic;
		
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