
public class IntBSTree<T extends Comparable<T>> {
	private T[] dataArr;
	private static final int ARR_SIZE=100;
	
	public IntBSTree(){
		dataArr=(T[])(new Comparable[ARR_SIZE]);
	}
  
  
    
    public void insert(T data){
    	if(dataArr[0]==null){
    		dataArr[0]=data;
    	}
    	else{
    		insert(0,data);
    	}
    }
    public void insert(int index, T data){
    	if(dataArr[index]==null){
    		dataArr[index]=data;
    	}
    	else if(data.compareTo(dataArr[index])< 0){
    		if(index*2+1<dataArr.length){
    			insert(index*2+1, data);
    		}
    	}
    		else if(data.compareTo(dataArr[index])>=0){
    			if(index*2+2<dataArr.length){
    				insert(index*2+2,data);
    			
    		}
    	}
    }
    public void printInorder(){
    	
    	printInorder(0);
    	
    }
    public void printInorder(int index){
    	if(dataArr[index]==null){
    		return;
    	}
    	if(index*2+1<dataArr.length&& dataArr[index*2+1]!=null){
    		printInorder(index*2+1);
    	}
    	System.out.println(dataArr[index].toString());
    	if(index*2+2<dataArr.length&& dataArr[index*2+2]!=null){
            printInorder(index*2+2);
    	}
    }
    public void printBreadthOrder(){
           for(T val: dataArr){
        	   if(val!=null){
        		   System.out.println(val.toString());
        	   }
           }
    }
    public int getDepth(T data){
    	int count =0;
    	return getDepth(0,data, count);
    }
    public int getDepth(int index, T value, int count){
    	
    	if(index >= dataArr.length || dataArr[index]==null){
    		return -1;
    	}
    	if(value.compareTo(dataArr[index])==0){
    		return count;
    	}
    	else if(value.compareTo(dataArr[index])<0){
    		return getDepth(index*2+1,value,count+1);
    	}
    	else if(value.compareTo(dataArr[index])>0){
    		return getDepth(index*2+2,value,count+1);
    	}
    	return -1;
    }
    	
    
}
