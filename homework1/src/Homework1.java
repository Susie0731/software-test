public class Homework1 {

    private int[] arr ={1,1,1,5,5,10,20,50};
    public boolean isGiven(int num){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            count+=arr[i];
            if(count<num)
                continue;
            else if(count>num)
                return false;
            else return true;
        }
        return false;
    }

}
