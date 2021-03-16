package simulator;

public class Client {

	private int id;
	private int arrivalTime;
	private int simulationTime;

	/**
	 * Public constructor
	 * 
	 * @param id
	 * @param arrivalTime
	 * @param simulationTime
	 */
	public Client(int id, int arrivalTime, int simulationTime) {
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.simulationTime = simulationTime;
	}

	/**
	 * toString method aimed to display clients' info
	 */
	public String toString() {
		String s = "";
		if (this.getSimulationTime() != 0)
			s = "(" + getId() + ", " + getArrivalTime() + ", " + getSimulationTime() + ")";
		return s;
	}

	// getters and setters
	public int getArrivalTime() {
		return arrivalTime;
	}

	public int getSimulationTime() {
		return simulationTime;
	}

	public void setSimulationTime(int simulationTime) {
		this.simulationTime = simulationTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
