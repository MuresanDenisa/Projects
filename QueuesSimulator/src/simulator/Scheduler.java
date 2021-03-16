package simulator;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Scheduler {

	private ArrayList<Queue> queuesList;
	private int maxNoOfQueue;

	/**
	 * sets the maxNoOfQueues with the given number of queues creates the given
	 * status of queues and starts a thread with each queue
	 * 
	 * @param queues
	 */
	public Scheduler(int noOfQueues) {
		setMaxNoOfQueue(noOfQueues);
		queuesList = new ArrayList<Queue>(noOfQueues);
		for (int i = 0; i < maxNoOfQueue; i++) {
			Queue newQueue = new Queue(i);
			queuesList.add(newQueue);

			Thread thread = new Thread(newQueue);
			thread.start();
		}
	}

	/**
	 * browses through the queuesList and finds the minimum Waiting time saves the
	 * id of the queue with the minimum waiting time adds the newClient in the
	 * selected queue
	 * 
	 * @param c
	 */
	public int dispatchClient(Client c) {
		int index = queuesList.get(0).getQueueID();
		AtomicInteger minWaitingTime = queuesList.get(0).getWaitingPeriod();
		for (Queue i : queuesList) {
			if (i.getWaitingPeriod().get() < minWaitingTime.get()) {
				minWaitingTime = i.getWaitingPeriod();
				index = i.getQueueID();
			}
		}
		queuesList.get(index).addTask(c);

		if (!queuesList.get(index).isAsleep()) {
			queuesList.get(index).setAsleep(true);
			Thread thread = new Thread(queuesList.get(index));
			thread.start();
		}
		return queuesList.get(index).getWaitingPeriod().get();
	}

	// getters and setters
	public ArrayList<Queue> getQueues() {
		return queuesList;
	}

	public int getMaxNoOfQueue() {
		return maxNoOfQueue;
	}

	public void setMaxNoOfQueue(int maxNoOfQueue) {
		this.maxNoOfQueue = maxNoOfQueue;
	}

	public ArrayList<Queue> getQueuesList() {
		return queuesList;
	}

	public void setQueuesList(ArrayList<Queue> queuesList) {
		this.queuesList = queuesList;
	}

}
