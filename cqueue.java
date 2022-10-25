import java.io.*;
import java.util.*;
class cqueue 
{
    int que[];
    int size;
    int f, r;

    cqueue(int capacity) 
    {
        size = capacity;
        que = new int[capacity];
        f = -1;
        r = -1;
    }

    void insert(int v) 
    {
        if (f == -1 && r == -1) 
        {
            f = 0;
            r = 0;
            que[r] = v;
        } 
        else if ((r + 1) % size != f) 
        {
            r = (r + 1) % size;
            que[r] = v;
        } 
        else
            System.out.println("Queue is full.");
    }
    int remove()
    {
        int temp;
        if(f == -1)
        {
            System.out.print("Queue is Empty");
            return -1;
        }
    
        temp = que[f];
        if(f == r)
        {
            f = -1;
            r = -1;
        }
        else if(f == size - 1)
        {
            f = 0;
        }
        else
        {
            f = f + 1;
        }
        return temp;
        }
        void isFull() 
        {
            if ((r + 1) % size == f) 
            {
                System.out.println("Queue is full.");
            } 
            else 
            {
                System.out.println("Queue is not full.");
            }
        }

    void isEmpty() 
    {
        if (f == -1 && r == -1)
            System.out.println("Queue is empty.");
        else
            System.out.println("Queue is not empty.");
    }
    void display() 
    {
        int front = f, rear = r;
        if (front == -1 && rear==-1) 
        {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Queue elements are :");
        if (front <= rear) 
        {
           while (front <= rear)
           {
              System.out.print(que[front]+" ");
              front++;
           }
        } 
        else 
        {
           while (front < size ) 
           {
              System.out.print(que[front]+" ");
              front++;
           }
           front = 0;
           while (front <= rear) 
           {
              System.out.print(que[front]+" ");
              front++;
           }
        }
        System.out.println();
    }
    public static void main(String args[]) throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the cqueue:");
        int n = sc.nextInt();
        cqueue obj = new cqueue(n);
        int choice=0;
        while (choice != 6) 
        {
            System.out.println("Press 1: Insert an element");
            System.out.println("Press 2: Delete an element");
            System.out.println("Press 3: Display the element");
            System.out.println("Press 4: Check wheater the queue is empty");
            System.out.println("Press 5: Check wheter the queue is full");
            System.out.println("Press 6: Terminate the program");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            switch (choice) 
            {
                case 1:
                    System.out.println("Enter the element which is to be inserted:");
                    int x = sc.nextInt();
                    obj.insert(x);
                    break;
                case 2:
                    int k=obj.remove();
                    System.out.println(k+" has been removed.");
                    break;
                case 3:
                    obj.display();
                    break;
                case 4:
                    obj.isEmpty();
                    break;
                case 5:
                    obj.isFull();
                    break;
                case 6:
                    System.out.println("Program Terminates.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input.");
            }
        }
        sc.close();
    }
}