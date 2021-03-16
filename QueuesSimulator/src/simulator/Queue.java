package simulator;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Queue implements Runnable {

	private int queueID;
	private BlockingQueue<Client> clients;
	private AtomicInteger waitingPeriod;
	private boolean isAsleep;

	/**
	 * Public constructor initializes the queue of clients, sets the waitingPeriod
	 * to 0, sets the given id as the queueID
	 * 
	 * @param id
	 */
	public Queue(int id) {
		setQueueID(id);
		clients = new LinkedBlockingQueue<Client>();
		waitingPeriod = new AtomicInteger(0);
		setAsleep(false);
	}

	/**
	 * adds a client in the queue and increments the waitingPeriod of the queue with
	 * the simulationTime of the client
	 * 
	 * @param newClient
	 */
	public void addTask(Client newClient) {
		clients.add(newClient);
		waitingPeriod.addAndGet(newClient.getSimulationTime());
	}

	/**
	 * used to list the clients in a queue
	 */
	public String toString() {
		String s = "";
		for (Client i : clients) {
			s = s + i.toString();
		}
		return s;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isAsleep) {
			try {
				if (clients.peek() != null && clients.peek().getSimulationTime() > 0) {
					Thread.sleep(1000);
					clients.peek().setSimulationTime(clients.peek().getSimulationTime() - 1);
					waitingPeriod.decrementAndGet();
				}
			}

			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (clients.peek() != null && clients.peek().getSimulationTime() == 0) {
				clients.poll();
				if (clients.isEmpty())
					setAsleep(false);
			}

		}
	}

	// getters and setters
	public AtomicInteger getWaitingPeriod() {
		return waitingPeriod;
	}

	public void setWaitingPeriod(AtomicInteger waitingPeriod) {
		this.waitingPeriod = waitingPeriod;
	}

	public int getQueueID() {
		return queueID;
	}

	public void setQueueID(int queueID) {
		this.queueID = queueID;
	}

	public BlockingQueue<Client> getClients() {
		return clients;
	}

	public void setClients(BlockingQueue<Client> clients) {
		this.clients = clients;
	}

	public boolean isAsleep() {
		return isAsleep;
	}

	public void setAsleep(boolean isAsleep) {
		this.isAsleep = isAsleep;
	}

}
