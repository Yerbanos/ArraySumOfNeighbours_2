import java.util.Random;

public class ArraySumOfNeighbours
{
    public static void main(String[] args)
    {

        int arraySize = 10;
        int[][] randomIntArray = new int[arraySize][arraySize];
        randomIntFillArray(randomIntArray);
        printArray(randomIntArray);
        System.out.println("Rows quantity: " + randomIntArray.length);
        System.out.println("Columns quantity: " + randomIntArray[0].length);
        Maxelement maxelement = getMaxSumOfNeighbours(randomIntArray);
        System.out.println("sum of elements equal: " + maxelement.getMaxSum());
        System.out.println("Element with maximum sum of neighbours values is in row: " +(maxelement.getRowMaxSum()+1)
                            + " , column : " + (maxelement.getColumnMaxSum()+1));
    }

    private static void printArray(int[][] array)
    {
        for (int i=0; i<array.length; i++)
        {
            for(int j=0; j<array[0].length; j++)
            {
                System.out.print(array[i][j] + "\t" );
            }
            System.out.println("\n");
        }
    }


    private static void randomIntFillArray(int[][] array)
    {
        Random generator = new Random();

        for (int i=0; i<array.length; i++)
        {
            for(int j=0; j<array[0].length; j++)
            {
                array[i][j] = generator.nextInt(10);
            }
        }
    }

    private static Maxelement getMaxSumOfNeighbours(int[][] array)
    {
        Maxelement maxelement = new Maxelement(0,0,0);

        for(int i=0; i<array.length; i++)
        {
            for (int j = 0; j < array[0].length; j++)
            {
                // tempSum equals -array[i][j] because its addition below, so tempSum equals zero + neighbours values.
                int tempSum = -array[i][j];
                for (int loopRow = -1; loopRow<2; loopRow++)
                {
                    for (int loopColumn = -1; loopColumn<2; loopColumn++)
                    {
                        if (((i+loopRow >=0) && (i+loopRow < array.length)) && ((j+loopColumn >= 0) && (j+loopColumn < array[0].length )))
                        {
                            tempSum += array[i+loopRow][j+loopColumn];
                        }
                    }
                }

                if (maxelement.getMaxSum() < tempSum)
                {
                    maxelement.setMaxSum(tempSum);
                    //Add 1 to value of maxValueRow and maxValueColumn for print
                    maxelement.setRowMaxSum(i);
                    maxelement.setColumnMaxSum(j);
                }
            }
        }
        
        return maxelement;
    }

}

class Maxelement
{
    private int maxSum, rowMaxSum, columnMaxSum;

    public Maxelement(int maxSum, int rowMaxSum, int columnMaxSum)
    {
        this.maxSum = maxSum;
        this.rowMaxSum = rowMaxSum;
        this.columnMaxSum = columnMaxSum;
    }

    public int getMaxSum()
    {
        return maxSum;
    }

    public int getRowMaxSum()
    {
        return rowMaxSum;
    }

    public int getColumnMaxSum()
    {
        return columnMaxSum;
    }

    public void setMaxSum(int maxSum)
    {
        this.maxSum = maxSum;
    }

    public void setRowMaxSum(int rowMaxSum)
    {
        this.rowMaxSum = rowMaxSum;
    }

    public void setColumnMaxSum(int columnMaxSum)
    {
        this.columnMaxSum = columnMaxSum;
    }
}


