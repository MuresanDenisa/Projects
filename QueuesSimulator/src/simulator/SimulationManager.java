package simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;

public class SimulationManager implements Runnable {

	private int noOfClients;
	private int noOfQueues;
	private int timeLimit;
	private int minArrivalTime;
	private int maxArrivalTime;
	private int minSimulationTime;
	private int maxSimulationTime;

	// entity responsible with queue management and client distribution
	private Scheduler scheduler;

	// list of clients in the store
	private ArrayList<Client> clients;

	/**
	 * sets the input data calls the scheduler's constructor in order to initiate
	 * and start the threads generates random clients
	 * 
	 * @param noOfClients
	 * @param noOfQueues
	 * @param timeLimit
	 * @param minSimulationTime
	 * @param maxSimulationTime
	 * @param minArrivalTime
	 * @param maxArrivalTime
	 */
	public SimulationManager(int noOfClients, int noOfQueues, int timeLimit, int minArrivalTime, int maxArrivalTime,
			int minSimulationTime, int maxSimulationTime) {
		setNoOfClients(noOfClients);
		setNoOfQueues(noOfQueues);
		setTimeLimit(timeLimit);
		setMinArrivalTime(minArrivalTime);
		setMaxArrivalTime(maxArrivalTime);
		setMinSimulationTime(minSimulationTime);
		setMaxSimulationTime(maxSimulationTime);

		scheduler = new Scheduler(noOfQueues);
		clients = generateRandomClients();
	}

	/**
	 * Generates random clients respecting the given constrains
	 * 
	 * @return
	 */
	public ArrayList<Client> generateRandomClients() {

		ArrayList<Client> clients = new ArrayList<Client>(noOfClients);
		int id = 1;
		Random randArrivalTime = new Random();
		Random randSimulationTime = new Random();
		for (int i = 0; i < noOfClients; i++) {
			Client client = new Client(id,
					minArrivalTime + randArrivalTime.nextInt(maxArrivalTime - minArrivalTime + 1),
					minSimulationTime + randSimulationTime.nextInt(maxSimulationTime - minSimulationTime + 1));
			id++;
			clients.add(client);

		}

		return clients;
	}

	public String toString() {
		String s = "";

		for (Client i : clients)
			s = s + i.toString();
		return s;
	}

	public void run() {
		// TODO Auto-generated method stub
		int actualTime = 0;
		int totalWaitingPeriod = 0;

		while (actualTime < timeLimit) {
			int addedClients[] = new int[noOfClients];

			for (int i = 0; i < noOfClients; i++) {
				addedClients[i] = 0;
			}

			int j = 0;
			for (Client i : clients) {
				if (i.getArrivalTime() == actualTime) {
					totalWaitingPeriod += scheduler.dispatchClient(i);
					addedClients[j] = 1;
				}
				j++;
			}

			int index = 0;
			while (index < noOfClients) {
				if (addedClients[index] == 1 && !clients.isEmpty()) {
					clients.remove(index);
					for (int i = 1; i < noOfClients; i++) {
						addedClients[i - 1] = addedClients[i];
					}
				} else
					index++;
			}
			System.out.println("Time " + actualTime);
			if (!clients.isEmpty())
				System.out.println("Waiting pool: " + clients.toString());
			else
				System.out.println("Waiting pool:");

			for (Queue i : scheduler.getQueues()) {
				if (i.getWaitingPeriod().get() == 0)
					System.out.println("Queue" + i.getQueueID() + ": closed");
				else
					System.out.println("Queue" + i.getQueueID() + ": " + i.getClients());
			}
			actualTime++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Average waiting time:" + (float) (totalWaitingPeriod / noOfClients));
	}

	// getters and setters
	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public int getMaxSimulationTime() {
		return maxSimulationTime;
	}

	public void setMaxSimulationTime(int maxSimulationTime) {
		this.maxSimulationTime = maxSimulationTime;
	}

	public int getMinSimulationTime() {
		return minSimulationTime;
	}

	public void setMinSimulationTime(int minSimulationTime) {
		this.minSimulationTime = minSimulationTime;
	}

	public int getMinArrivalTime() {
		return minArrivalTime;
	}

	public void setMinArrivalTime(int minArrivalTime) {
		this.minArrivalTime = minArrivalTime;
	}

	public int getMaxArrivalTime() {
		return maxArrivalTime;
	}

	public void setMaxArrivalTime(int maxArrivalTime) {
		this.maxArrivalTime = maxArrivalTime;
	}

	public int getNoOfQueues() {
		return noOfQueues;
	}

	public void setNoOfQueues(int noOfQueues) {
		this.noOfQueues = noOfQueues;
	}

	public int getNoOfClients() {
		return noOfClients;
	}

	public void setNoOfClients(int noOfClients) {
		this.noOfClients = noOfClients;
	}

	public Scheduler getScheduler() {
		return scheduler;
	}

	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	public static void main(String[] args) {
		int noOfClients = 0;
		int noOfQueues = 0;
		int timeLimit = 0;
		int minArrivalTime = 0;
		int maxArrivalTime = 0;
		int minSimulationTime = 0;
		int maxSimulationTime = 0;
		File file = null;
		String buffer;

		try {
			String inFileName = args[0];
			file = new File(inFileName);
			BufferedReader bw = new BufferedReader(new FileReader(file));
			noOfClients = Integer.valueOf(bw.readLine());
			noOfQueues = Integer.valueOf(bw.readLine());
			timeLimit = Integer.valueOf(bw.readLine());

			buffer = bw.readLine();
			String[] auxBw = buffer.split(",");
			minArrivalTime = Integer.valueOf(auxBw[0]);
			maxArrivalTime = Integer.valueOf(auxBw[1]);

			buffer = bw.readLine();
			auxBw = buffer.split(",");
			minSimulationTime = Integer.valueOf(auxBw[0]);
			maxSimulationTime = Integer.valueOf(auxBw[1]);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			String outFileName = args[1];
			System.setOut(new PrintStream(new File(outFileName)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		SimulationManager manager = new SimulationManager(noOfClients, noOfQueues, timeLimit, minArrivalTime,
				maxArrivalTime, minSimulationTime, maxSimulationTime);
		Thread thread = new Thread(manager);
		thread.start();

		return;
	}
}
