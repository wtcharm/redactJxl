package com.soft.redactJxl.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 可重入锁
 * @ClassName: LockTest 
 * @date 2019年5月31日
 * @author tang wang
 */
public class LockTest {

	private ArrayList<Integer> arratlist= new ArrayList<Integer>();
	Lock lock = new ReentrantLock();
	public static void main(String[] args) {
		final LockTest test = new LockTest();

		new Thread() {
			public void run() {
				test.insert(Thread.currentThread());
			};
		}.start();

		new Thread() {
			public void run() {
				test.insert(Thread.currentThread());
			}
		}.start();

		new Thread() {
			public void run() {
				test.insert(Thread.currentThread());
			}
		}.start();
	}



	public void insert(Thread thread) {
		
		lock.lock();//获取锁
		try {
			System.out.println(thread.getName() + "得到了锁");

			for (int i = 0; i < 5; i++) {
				arratlist.add(i);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			System.err.println(thread.getName() + "释放了锁");
			lock.unlock();//释放锁
		}

	}

}
