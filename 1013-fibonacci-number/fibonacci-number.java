class Solution {
    public int fib(int n) {
        if (n <= 1) return n;  //base case
        return fib(n - 1) + fib(n - 2);//recursive case
    }
}

// class Solution {
//     public int fib(int n) {
//         if(n <= 1) return n;
//         int a = 0, b = 1, c = 0;
//         for(int i = 2; i <= n; i++){
//             c = a + b;
//             a = b;
//             b = c;
//         }
//         return c;
//     }
// }
