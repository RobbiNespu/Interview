
public class Math {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {3, 5, 8, 10};
		int[] b = {4, 6, 7, 11};
		int[] c = mergeSort(a, b);
		int i = 0;
		while(i<c.length){
			System.out.println(c[i]);
			i++;
		}		
	}

	// prime can just divide by 1 and itself 
	public static boolean isPrime(int n)
	{
		if(n % 2 == 0 && n != 2)
			return false;
	
		for(int i = 3; i< n; i+=2){
		 if(n % i == 0)
			 return false;		 
		}
		return true;
	}
	
	public static void selectSort(int a[]){
		
		for(int i = 0; i< a.length-1;i++)
		{   int t;
		    int m = i;
			for(int j=i+1; j<a.length;j++)
			{    
				if(a[j] < a[m])
				{
		            m= j;		            
				}				
			}			
				t = a[i];
				a[i]=a[m];
				a[m] = t;
					
		}
	}
	
	public static int binSearch(int[] a, int x){
		int low=0;
		int high = a.length-1;
		while(low <= high){
			int middle = (low + high)/2;
			if(x == a[middle])
				return middle;
			else if(x > a[middle])
			{
				low = middle+1;
			}else{
				high = middle-1;
			}	
		}
		return -1;
	}
	
	public static void permutation (String s)
	{
		
	}
	
	public static int[] mergeSort(int[] a, int[] b){
		int m = a.length + b.length; 
		int[] c = new int[m];
		int i =0, j=0, k=0;
		
		while(i< a.length && j < b.length){
			if(a[i] <= b[j]){
				c[k] = a[i];
				i++;
				k++;
			}else
			{
				c[k] = b[j];
				j++;
				k++;
			}
		}
		
		while(i<a.length){
			c[k] = a[i];
			i++;
			k++;
		}
		
		while(j<b.length){
			c[k] = b[j];
			j++;
			k++;
		}		
		return c;			
	}
	
	
}
