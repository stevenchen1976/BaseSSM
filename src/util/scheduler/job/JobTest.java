package util.scheduler.job;

import util.Tools;
import util.scheduler.TaskJob;

public class JobTest extends TaskJob{

	@Override
	public void run() {
		Tools.out("scheduler quartz run test");
		
	}

	
}
