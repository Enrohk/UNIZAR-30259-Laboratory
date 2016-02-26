package pract1.v1;


import exceptions.pract1.CalculatorException;

public class CalculatorV1
{
    private static String SPLIT = ",";

    public static int sum (String numbers) throws CalculatorException
    {
        try
        {
            String[] nums = numbers.split(SPLIT);
            if(!(nums.length>2))
            {
                int[] realNums = new int[nums.length];
                for (int i=0; i<nums.length; i++)
                {
                    realNums[i] = Integer.parseInt(nums[i]);
                }
                return 0;
            }
            throw new CalculatorException();
        }
        catch (Exception e)
        {
            throw new CalculatorException();
        }
    }
}
