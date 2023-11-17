package miniproject;


public class About extends Thread{

    public About(String thread)
    {
        super(thread);
    }
    
    @Override
    public void run()
    {
       System.out.println("\nWelcome to our OOP mini project - 'RANDOM FACE GENERATOR'");
       System.out.println("\nPlease wait while the application starts :)");
       System.out.println("\n!DISCLAIMER! - Make sure you do not give same colour as face for eyes and mouth as it will not be visible\n");
       try{
       Thread.sleep(1000);}
       catch(InterruptedException e)
       {
         System.out.println("Interrupted exception caught");
       }
    }
}
