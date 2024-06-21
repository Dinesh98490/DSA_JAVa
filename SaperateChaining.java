public class SaperateChaining {

    SinglyLinkedList[] hastable;
    void SaperateChaining(){
        hastable = new SinglyLinkedList[10];
       for(int i =0; i < 10; i++){
        hastable[i] = new SinglyLinkedList();
       }
    }
    void add(int key){
        int location =  hasfunction(key);
        hastable[location].addNode(key);   
    }
    int  get(int key){
        int location = hasfunction(key);
        SinnglyLinkedList.Node current =  hastable[location].head;
        while(current != null){
            if(current.data == key){
            //return value: return current.value;
            return current.data;

            }
            current =  current.next;

        }
        return -1;
        


    }
    int hasfunction(int key){
         return (2*key + 3) %10;

    }
}
