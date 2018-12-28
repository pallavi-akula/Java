//package com.capgemini.beans;

class RunnableDemo implements Runnable {
       private Thread t;
       private String threadName;
       private int k;
       private int l;
       
       RunnableDemo( String name ,int k ,int l) {
          threadName = name;
          this.k=k;
          this.l=l;
          System.out.println( threadName );
       }
       
       public void run() {
          System.out.println("Running " +  threadName );
          try {
             for(int i =k ; i <=l ; i++) {
                
                     System.out.println("Thread: " + threadName + " " + i);
                     // Let the thread sleep for a while.
                     Thread.sleep(50);
              // Thread.sleep(50);
             }
          } catch (InterruptedException e) {
             System.out.println("Thread " +  threadName + " interrupted.");
          }
          System.out.println("Thread " +  threadName + " exiting.");
       }
       
       public void start () throws InterruptedException {
          System.out.println("Starting " +  threadName );
          if (t == null) {
             t = new Thread (this, threadName);
             t.start ();
             t.join();
          }
       }
    }

    public class TestThread {

       public static void main(String args[]) {
          RunnableDemo R1 = new RunnableDemo( "First",1,10);
          try {
            R1.start();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
          
          
          
          RunnableDemo R2 = new RunnableDemo( "Second",10,20);
          try {
            R2.start();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
          
          RunnableDemo R3 = new RunnableDemo( "Third",20,30);
          try {
            R3.start();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

       }   
    }