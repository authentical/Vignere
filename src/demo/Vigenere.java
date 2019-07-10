package demo;

import java.util.Arrays;
import java.util.Scanner;


class Vigenere {

    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    private static int runs=0;

    public int[] encode(String[] args) {


        // Demo key
        char demoCipher[] = {'a', 'a', 'a'};
        prints("DEFAULT: " + String.valueOf(demoCipher));

        // If you got param, use it, otherwise use the a[]
        char[] cipher = (args.length > 1 ? (args[1]).toCharArray() : demoCipher);

        String plaintextBuffer = new String(); // Inst during user input

        int[] encryptedMsg;    // Inst during user input

        // Prompt for a keyword
        // If you have required args
        if (!(cipher.length < 2)) {

            println("Plaintext: ");
            StringBuilder sb = new StringBuilder();
            // No key check


            // Get Plaintext from user, delimiter \n
            Scanner systemIn = scannerInit();
            systemIn.useDelimiter("\\s*\n\\s*");



            if (systemIn.hasNext()){    // Does buffer have data?

                //Print request for input
                println("Plaintext:");
                plaintextBuffer = systemIn.next();  // Type Hello as a string
            }

            encryptedMsg = new int[plaintextBuffer.length()];   // Encrypted message is same length is original
            char[] decryptedMsg = plaintextBuffer.toCharArray();    // decrypted message has H e l l o

            System.out.println(Arrays.toString(decryptedMsg));  // SHow the decrypted message

            // Encrypt and Copy message chars into encryptedMsg
            // Each message char at i is incremented by the value of the cipher char at j
            for (int i = 0, j = 0; i < decryptedMsg.length; i++) {


                // Reset cipher index - Cipher is length j but in effect is as long as the plaintext to encrypt.
                // e.g. For a cipher = AST, cipher[j] = A, cipher[j+2700] = A, cipher[j+2701] = S
                if (j == (cipher).length) {
                    j = 0;
                }

                // Encrypt
                encryptedMsg[i] = decryptedMsg[i] + cipher[j];
                if (encryptedMsg[i] > 255) {
                    encryptedMsg[i] = encryptedMsg[i] - 255;
                }

//                prints(decryptedMsg[i] + " " + cipher[j] + " ");
//
//                // print int array
//                prints(" " + (char) encryptedMsg[i]);
//                printInt(encryptedMsg[i]);
//                fourSpaces();


            }



            return encryptedMsg;

        } else {

            prints("Buddy you have to use like a parameter");
        }

        return null;
    }


    public String  decode(int[] encryptedMsg, String password){

        StringBuilder sb = new StringBuilder();

        for(int i=0, j=0; i< encryptedMsg.length; i++){

            if(j>=password.length()){ j=0; }

            sb.append ((char)(encryptedMsg[i]-password.charAt(j)));
        }



        return sb.toString();
    }


    // == UTILITY ==

    public static void println(String a) {

        System.out.println("\n" + a);
    }
    public static void prints(String a) {

        gridAutoCR();

        System.out.print(a);
    }
    public static void prints(int a) {

        gridAutoCR();
        System.out.print((char) a);
    }
    public static void printInt(int a) {

        gridAutoCR();
        System.out.print(a);
    }


    public static void gridAutoCR(){

        runs++;
        if(runs>10){
            System.out.println("\n");
            runs=0;
        }
    }
    public static void fourSpaces(){

        System.out.print("    ");
    }


    public static Scanner scannerInit() {

        Scanner in = new Scanner(System.in);

        return in;
    }
}
