public class QueueImplementation {

    static class Queue {
        int[] arr;
        int front, rear, size, capacity;
        Queue(int capacity){
          this.capacity = capacity;
          arr = new int[capacity];
          front = 0;
          rear =  -1;
          size = 0;
        }

        //push
        void push(int value){
          if (size == capacity) {
            System.out.println("Queue is full");
            return;
          }
          rear++;
          arr[rear] = value;
          size++;
          System.out.println(value+" pushed into Queue");

        }

        //pop
        int pop(){
          if(size==0){
            System.out.println("Queue is empty");
            return -1;
          }

          int removed = arr[front];
          front++;
          size--;
          return removed;
        }

        //peek
        int peek(){
          if(size == 0){
            System.out.println("Queue is empty");
            return -1;
          }

          return arr[front];




        }


        void display(){
          if (size == 0) {
            System.out.println("Queue is empty");
            return;
          }

          System.out.print("Queue: ");
          for (int i = front; i <=rear; i++) {
            System.out.println(arr[i]+" ");
          }

          System.out.println();
        }
      }

      public static void main(String[] args) {
        
        Queue q = new Queue(5);

        q.push(10);
        q.push(20);
        q.push(30);

        q.display();


        System.out.println("Front element: "+q.peek());

        System.out.println("Popped: "+q.pop());

        q.display();

        q.push(40);
        q.push(50);

        q.display();
      }
}
