package main.java.leetcode;
/*
Question: 476. Number Complement
Link: https://leetcode.com/problems/number-complement/description
 */
public class NumberComplement_476 {
    public static void main(String[] args) {
        var obj = new NumberComplement_476();
        System.out.println(obj.findComplement(5));
        System.out.println(obj.findComplement(1));
    }

    public int findComplement(int num) {
        int temp = num;
        int count=0;
        while(temp!=0) {
            temp = temp>>1;
            count++;
        }

        int result = num ^ ((1<<count)-1);
        return result;
    }
}


/*
Understanding the Problem Statement

INPUT 1 0 1 - 5
OUTPUT 0 1 0 - 2 just flipping the bits as you can see. 1 transforms to 0 and 0 to 1. thats it!

STEPS

The first thing that should come to your mind when you want the opposite of any bit is the great XOR operation. Remember the simple rule of XOR. Whenever there is a bit say 1 ^ 0 , 0 ^ 1 then you will always get 1. Rest everytime you get 0.
Next, you need to figure the bit mask to get the result. Lets take the example of the input - 101 and output 010.
so if you XOR these two number then you get your mask required. Example - (101) ^ (010) = 111 which is 7.
So, if you do 101 ^ 111 = 010 and thats the answer or the output we want! So this is how you got your ** mask**
Now that you have the mask you just have to convert this logic into meaningful code so that it works for any input.
one simple formula is. (2Power3)- 1. This will give you 8 AND THEN -1 WILL GIVE YOU 7. Notice that 3 is the number of bits in the number.
Just do 101 ^ (2Power3)-1 and thats your output answer.
TASK 1

Our first task is to find the number of bits a number has. For this we will run a while loop till the number becomes 0.
You can do this by taking the MSB (the first bit from the left side) and shift it one time. You can also take the LSB.
something like this while(num!-0) we do num = (num>>1) and COUNT THE NUMBER OF ITERATIONS, THAT WILL BE THE NUMBER OF BITS IN A NUMBER. THIS WILL GIVE US THE POWER.
TASK 2

Now you know what the power is going to be for your number (2(Power)count)-1. Is what you have to do.
TASK 3

Just XOR NUM with (2(Power)count) -1 and you will get the result.
NOTE: YOU NEED TO SAVE THE NUM IN A TEMP VARIABLE BECASUE THE VALUE OF NUM WILL CHANGE TO 0 UPON DOING THE RIGHT SHIFT OPERATION. SO AT THE END JUST DO RESULT = (TEMP ^ (2(POWER)COUNT)-1).

2 POWER Count is basically 2 being the base and count being the Exponent. I could have used 2^3 to explain but this alsoc could confuse you between the XOR operation.

PRO TIP

2(Power)COUNT IS SAME AS (1<<COUNT)
SO BASICALLY YOU HAVE TO DO RESULT = TEMP ^ (1<<COUNT) - 1;
 */