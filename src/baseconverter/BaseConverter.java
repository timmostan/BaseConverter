/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseconverter;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author stachu
 */
public class BaseConverter {

    private double base;
    private double number;
    private StringBuilder result;
    /*
    examples:
    Input: 25 7
    Output: 34
    Input: 368 4
    Output: 11300
    Input: 78 3
    Output: 2220
    */
    
    /**
     * Create a new BaseCinverter instance.
     */
    public BaseConverter(double number, double base)
    {
        this.number = number;
        this.base = base;
        this.result = new StringBuilder();
    }
     /**
     * Find max power for base
     */
    private double findPower()
    {
        double power = 0;
        double temp = this.number;
        while (temp >= 0)
        {
            temp = temp - Math.pow(this.base, power);
            power = power + 1;
            
        }
        //we need to shift the power - 2, unless we have
        //a number which is square of our base
        if (Math.pow(this.base, power-1)==this.number)
            return power-1;
        else
            return power-2;
    }
    /**
     * The main converter method.
     */
    public String convert()
    {
        double temp, num;
        double power;
        power = findPower();
        num = this.number;
        while(power>=0)
        {
            temp=Math.pow(this.base, power);
            Double i = num / temp;
            this.result.append(i.intValue());
            num = num - i.intValue()*temp;
            power--;
        }
        return this.result.toString();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        double[] input = new double[2];
        Scanner scan = null;
        scan = new Scanner(System.in);
        System.out.println("Input (in format \"<number> <base>\"): ");
        String userInput =  scan.nextLine();
        StringTokenizer st = new StringTokenizer(userInput);
        int i = 0;
        while (st.hasMoreTokens()&&i<2)
	{
	  try {
              input[i] = Double.parseDouble(st.nextToken());
              i++;
          } catch (NumberFormatException e)
          {
              System.err.println("This is not a number!");
          }
	}
        BaseConverter bc = new BaseConverter(input[0], input[1]);
        System.out.println("Output: " + bc.convert());
    }
    
}
