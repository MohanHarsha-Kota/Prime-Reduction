import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeReduction {

    static int[] pf = new int[500]; //Array to store Prime factors
    static int[] int_array = new int[21000]; //Array to store the Input

    public static void main(String[] args) {

        int c = 0, i;
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String Input;
            while((Input = in.readLine()) != null && !Input.isEmpty()) {
                int_array[c] = Integer.parseInt(Input);
                c++;
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Finding the Prime Reduction
        for(i = 0; i< c;i++) {
            primeReductor(int_array[i]);
        }

    }

    private static int primeornot(int MN) { //Method to check whether the given integer is prime or not

        int p = 0;
        int upto = (int) Math.sqrt(MN); //For ultimate peformance boost
        for(int k =2; k<=upto; k++)
        {
            if(MN%k == 0)
            {
                p = 1;
                break;
            }
        }

        return p; //If p = 0, the number is prime. if p = 1, then the number is not a prime
    }

    private static void primeReductor(int LN) {

        int n = LN, sum = 0, count = 0, flag = 0, j;

        while(flag == 0) {

           count++; // Variable to keep track of the prime reduction iterations
           if(n == 4) {
                // Since prime reduction of 4 results 4 again, we omit it.
                   System.out.println();
                   flag = 1;
               }

               else if (primeornot(n) != 1){
                   System.out.println(n + " " + count);
                   flag = 1;
               }
                else {
                j = 0;
                for (int i = 2; i <=n/i; i++) {
                    while (n % i == 0) { // Finding the prime factors
                        n /= i;
                        pf[j] = i; //Adding the prime factors into an array
                        j++;
                    }
                }
                if (n > 1) {
                    pf[j] = n; // Adding the final prime quotient also into the array.
                    j++;
                }

                for(int i =0; i< j;i++)
                {
                    sum += pf[i]; // Calculating the sum of the prime factors
                }
                n = sum; // changing n to the sum of the prime factors in order to repeat the process again.
                sum = 0;

            }


           }


        }
    }

