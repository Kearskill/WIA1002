Tutorial 2: Recursion (Fundamental)

3. Explain the problem that occurs when executing the recursive method f(0).
   public static int f(int n) {
``` java
if (n == 1){
    return n;
} else{
    return n * f(n-1);
}
```
   Answer:
   StackOverFlow – never reaches the base case, coz n=0. In program, the base case is n=1. So what
   happens if a recursive method never reaches a base case? The stack will never stop growing. The
   computer, however, limits the stack to a particular height, so that no program eats up too much
   memory. If a program's stack exceeds this size, the computer initiates an exception, which typically
   would crash the program. (From the operating system's point of view, crashing the program is
   preferable to allowing a program to eat up too much memory and interfere with other better-behaved
   programs that may be running.) The exception is labeled a StackOverflowError

2. Explain the problem that occurs when executing the recursive method f().
   public static int f(int n) {
   if (n == 0)
   return n;
   else
   return f(n+1) + n;
   }
3. Write a recursive method to reverse a string.
   String → gnirts
4. Write a recursive method to calculate the following :
   5 + 4 + 3 + 2 + 1.
   State the base case and recursive case. Trace your solution using number, N of 5.
   Algorithm :
1. Base case = 1
2. Recursive case = n + sum(n-1)
5. Write a recursive method printDigit that prints an integer argument as its constituent digits,
   with a blank space separates each digit with the next. For example, if the argument is 4567,
   this method will print 4 5 6 7 on the screen.