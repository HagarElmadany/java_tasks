class CountWord{
    int count_word (String str1,String word1){
        String [] arr =str1.split(" ");
        int counter=0;
        for(int i=0;i<arr.length;i++)
        {
            if(word1.equals(arr[i]))
            {
                counter++;
            }
        }
        return counter;
    }
}

public class Task2 {
    public static void main(String[] args){
        String str ="Hagar Lina Lara Hagar Darien";
        String word ="Hagar";
        CountWord count=new CountWord();
        int res = count.count_word(str,word);
        System.out.println("counter = "+res);
    }
}
