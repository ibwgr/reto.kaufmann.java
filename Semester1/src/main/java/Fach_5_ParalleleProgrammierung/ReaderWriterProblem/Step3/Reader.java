package Fach_5_ParalleleProgrammierung.ReaderWriterProblem.Step3;

import java.util.Random;

public class Reader extends Thread {
	Data data;
	int sleepTime;
	Reader(Data data, int sleepTime) {
		this.data = data;
		this.sleepTime = sleepTime;
	}
	public void run() {
		Random random = new Random();
		while (true) {
			StringBuffer buf = new StringBuffer();
			// diese beiden (while und ++ muessen zwingend hintereinander laufen!
			synchronized(data) {
				while (data.noWriters != 0) {
				}
				data.noReaders++;
			}
			for (int j=0; j < data.values.length; j++) {
				buf.append(data.values[j]);
				buf.append(", ");
			}
			data.noReaders--;
			System.out.println(buf.toString());
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
