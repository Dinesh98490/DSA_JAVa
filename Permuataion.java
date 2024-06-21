public class Permuataion {

    void findPermuation(String str, String Perm){
        if(Perm.length()>1){
            if(Perm.charAt(1)!='B'){
                return;
            }
        }
        if(str.length()==0){
            System.out.println(Perm);
            return; 
        }

        for(int i=0; i<str.length(); i++){
            char newchar = str.charAt(i);
            String newstr = str.substring(0, i) + str.substring(i+1);
            findPermuation(newstr, Perm+newchar); 
        }
    }

    public static void main(String[] args) {
        Permuataion p = new Permuataion();
        String str ="ABC";
        p.findPermuation(str,"");
    }
}