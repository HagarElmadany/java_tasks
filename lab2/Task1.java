import java.util.StringTokenizer;

class IPCutter{
String cmdLine;

public IPCutter(String cmdLine){
    this.cmdLine = cmdLine;
}
int[] doIPSplit(){
 String [] AfterSplit = cmdLine.split("\\.");
 int[] AfterSplitInteger=new int[AfterSplit.length];
 for(int i=0;i<AfterSplit.length;i++)
 {
    AfterSplitInteger[i] = Integer.parseInt(AfterSplit[i]);
 }
 return AfterSplitInteger;
}

int[] doIPSplit_2(){
    StringTokenizer st= new StringTokenizer(cmdLine,".");
    int[] tokens =new int[st.countTokens()];
    for(int i=0;i<tokens.length;i++)
    {
       tokens[i] = Integer.parseInt(st.nextToken());
    }
    return tokens;
}

}

public class Task1{
    public static void main(String[]args){
        String commandLine ="163.121.12.30";
        IPCutter cut =new IPCutter(commandLine);
        System.out.println("The output of "+ commandLine + "is");
        int [] out=cut.doIPSplit();
        for (int i=0;i<out.length;i++)
        {
            System.out.println(out[i]);
        }

        System.out.println("The output of "+ commandLine + " using stringTokenizer is");
        int [] out2 =cut.doIPSplit_2();
        for (int i=0;i<out2.length;i++)
        {
            System.out.println(out2[i]);
        }
        
    }
}