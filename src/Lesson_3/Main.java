package Lesson_3;

import Lesson_3.queue.Queue;
import Lesson_3.queue.QueueImpl;
import Lesson_3.stack.Stack;
import Lesson_3.stack.StackImpl;

public class Main {
    public static void main(String[] args) {
        Stack stack = new StackImpl<Integer>(5);

        System.out.println(stack.push(1));
        System.out.println(stack.push(3));
        System.out.println(stack.push(1));
        System.out.println(stack.push(4));
        System.out.println(stack.push(15));
        System.out.println(stack.push(0));

        stack.pop();

        for(int i = stack.size(); i >= 0; i--)
            System.out.println(stack.pop());

        Queue queue = new QueueImpl(3);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);

        for(int i = queue.size(); i >= 0; i--)
            System.out.println(queue.remove());
    }
}
