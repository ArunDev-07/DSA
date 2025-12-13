class Main {
    public static void main(String args[]){
        int n = 153;
        isArm(n);
    }

    static void isArm(int a){
        int original = a;
        int ans = 0;

        while(a > 0){
            int rem = a % 10;
            int cube = rem * rem * rem;
            ans += cube;
            a = a / 10;
        }

        System.out.print(original == ans);
    }
}


//it is same like a reversing a number first we store the original value in the original and answer for ans variable.
//then we use while loop it loops until the a==0 then we find the remainder using a%10 then we cube it and a=a/10 that gives the last digit by dividing the value with 10.
//then we store the value in the ans and we check that original == ans.we use this functions to check whether the number is armstrong or not.
