package com.ttn.java_session_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *  6. WAP showing try, multi-catch and finally blocks.
 */



public class Ques6_try_catch {
    private static BufferedReader f;
    public static void main(String[] args) throws IOException {
        try{
            FileReader file = new FileReader("/home/nitin/test.txt");
            f = new BufferedReader(file);
            int i = 0;
            while(i < 5){
                String line = f.readLine();
                System.out.println(line);
                i++;
            }
        }
        catch(FileNotFoundException exp){
            System.out.println("File NOT FOUND! : " + exp.getMessage());
        }
        catch(IOException exp){
            System.out.println("IO Error Occurred: ");
        }
        catch(Exception e){
            System.out.println("Something went wrong!");
        }
        finally{
            try{
                f.close();
                System.out.println("File closed Successfully.");
            }catch (NullPointerException e){
                System.out.println("Error occurred during closing file: " + e.getMessage());
            }
        }

        try{
            FileReader file = new FileReader("/home/nitin/hello.txt");
            f = new BufferedReader(file);
            String line;
            while((line = f.readLine()) != null){
                System.out.println(line);
            }
            int divideByZero = 56/0;
            System.out.println(divideByZero);
        }
        catch(FileNotFoundException exp){
            System.out.println("File NOT FOUND! : " + exp.getMessage());
        }
        catch(IOException exp){
            System.out.println("IO Error Occurred: ");
        }
        catch(Exception e){
            System.out.println("Something went wrong!");
        }
        finally{
            try{
                f.close();
                System.out.println("File closed Successfully.");
            }
            catch (NullPointerException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
