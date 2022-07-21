package d.d.juc;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.ArrayList;
import java.util.Random;

/**
 * 代码编写，5个线程，每个线程计算10个随机数之和，将每个线程结果计算打印，并将所有线程计算结果汇总打印。
 */
class Sum {

	public int sum = 0;

	public synchronized void setSum(int n){
		sum += n;
		System.out.println(Thread.currentThread().getName() + " sum总和 " + sum);
	}
	// 创建数组，求和，计算，打印
	public void calculate(int n){
		ArrayList<Integer> a = new ArrayList(n);
		for (int i = 0; i < n; i++) {
			a.add(new Random().nextInt(10));
		}
		System.out.println(Thread.currentThread().getName() + a);
		int s = a.stream().mapToInt(p->p).sum();
		System.out.println(Thread.currentThread().getName() + " 线程内总和 = " + s);
		setSum(s);
	}
}

public class Demo {
	public static void main(String[] args) {
		Sum s = new Sum();
		for (int i = 0; i < 5; i++) {
			new Thread(()->{
				s.calculate(10);
			}).start();
		}
	}
}
