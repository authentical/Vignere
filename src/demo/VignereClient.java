package demo;

import java.io.IOException;


public class VignereClient {

    // Load key into argv[]???
    public static void main(String[] args) throws IOException {

        Vigenere vig = new Vigenere();


        String cipher = "AST";  // Cipher is static in this case


        while(true) {

            System.out.println(vig.decode(vig.encode(args), cipher));

        }
    }
}

