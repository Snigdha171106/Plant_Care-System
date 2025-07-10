package com.plantcare;

public class ReminderThread extends Thread 
{
    public void run() 
    {
        try 
        {
            while (true) 
            {
                Thread.sleep(60000);
                System.out.println("Reminder: Check your plants and update their health if needed.\n");
            }
        } 
        catch (InterruptedException e) 
        {
            System.out.println("Reminder stopped.");
        }
    }
}