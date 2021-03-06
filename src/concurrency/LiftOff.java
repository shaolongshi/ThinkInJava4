package concurrency;

/**
 * 模拟起飞倒计时
 * @author long
 */
public class LiftOff implements Runnable{

	protected int countDown = 10;//default
	private static int taskCount = 0;
	private final int id = taskCount++;
	
	public LiftOff() {
	}
	public LiftOff(int countDown) {
		this.countDown = countDown;
	}
	
	public String status() {
		return "#"+id+"("+(countDown>0? countDown : "liftOff!!!")+").";
	}
	
	@Override
	public void run() {
		while(countDown-- >0) {
			System.out.print(status());
			Thread.yield();
		}
	}
}