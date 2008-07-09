package lv.accenture.ex08;

public class Printer implements Runnable{

	private Queue printQueue;
	private boolean stateIsRunning;
	private final int MAX = 10;
	
	private static Printer instance = new Printer();

	private Printer() {
		printQueue = new CircularQueue(MAX);
		stateIsRunning = true;
	}
	
	public static Printer getInstance() {
		return instance;
	}
	
	public void halt()
	{
		stateIsRunning = false;
	}
	
	public synchronized void addJob(PrintJob job) throws FullQueueException
	{
		System.out.println("Adding job" + " \'" + job.getName() + "\' " + "to the queue");
		printQueue.addBack(job);
	}
	
	private synchronized PrintJob getJob() throws EmptyQueueException
	{
		PrintJob job = (PrintJob)printQueue.getFront();
		System.out.println("Starting job" + " \'" + job.getName() + "\'");
		printQueue.removeFront();
		
		return job;		
	}
	
	@Override
	public void run() {

		while(stateIsRunning)
		{
			try
			{
				PrintJob curr = getJob();
				for(int i=0;i<curr.getPages();i++)
				{
				}
			}
			catch(Exception EmptyQueueException)
			{
				System.err.println("Queue is EMPTY");
			}
			
		}
	}

}