package Fach_5_ParalleleProgrammierung.ReaderWriterProblem.Step3;

import java.util.Random;

public class Writer extends Thread {
	Data data;
	int sleepTime;
	Writer(Data data, int sleepTime) {
		this.data = data;
		this.sleepTime = sleepTime;
	}
	public void run() {
		Random random = new Random();
		while (true) {
			// diese beiden (while und ++ muessen zwingend hintereinander laufen!
			synchronized(data) {
				while(data.noReaders != 0 || data.noWriters != 0) {
				}
				data.noWriters++;
			}
			for (int j=0; j < data.values.length; j++) {
				data.values[j] = random.nextInt();
			}
			data.noWriters--;
			if (sleepTime >= 0) {
				// wait for a random time between 0 and sleepTime
				try {
					Thread.sleep(random.nextInt(sleepTime));
				} catch (InterruptedException e) {		
				}
			}
		}
	}
}
