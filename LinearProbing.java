public class LinearProbing {
    int [] keys;
    int[] values;
    int capacity;
    public LinearProbing(int capacity){
        this.capacity = capacity;
        keys = new int[capacity];
        values = new int[capacity];

    }
    void insert(int key, int value){
       int tmp  = hasFunction(key);
       int i = tmp;
       do{
        if(keys[i] != 0){
            values[i] = value;
            return;
        }
        if(keys[i]==0){
            keys[i] = key;
            values[i] = value;
            return;

        }
        i=(i+1)%capacity;

       }
       while(tmp != i);

    }
    int get(int key){
        int tmp =  hasFunction(key);
        int i = tmp;
      do{
          if(keys[tmp] == key){
            return values[tmp];
        }
        i =(i++)%capacity;
    }while(tmp!=1);
        return -1;

    }
    int hasFunction(int key){
        return (2*key+3)%capacity;
    }
}
