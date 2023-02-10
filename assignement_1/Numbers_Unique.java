import java.util.*;
class Numbers_Unique
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int dup_array[]=new int[N];
        
        for(int i=0;i<N;i++)
        {
            dup_array[i]=sc.nextInt();
        }



        HashMap<Integer,Integer> hash=new HashMap<>();
        
		for(int i=0;i<N;i++)
		{
			if(hash.containsKey((dup_array[i])))		
			{
               hash.put(dup_array[i],hash.get(dup_array[i])+1);

			}
			else
               hash.put(dup_array[i],i);
		}
        for(Map.Entry m : hash.entrySet()){    
            System.out.print(m.getKey()+" ");    
           }  
    }
}