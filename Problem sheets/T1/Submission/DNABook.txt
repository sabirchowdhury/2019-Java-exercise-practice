public class DNABook implements SocialNetwork{
    boolean friends[][] = new boolean[100][100];
    String[] users = new String[100];
    private int amountOfUsers;
    private int upper;
    private int lower;
    private int half;
    private int i;
    private int j;

    public void registerUser(String name){
        users[amountOfUsers]=name;
        amountOfUsers=amountOfUsers+1;

    }
    public void becomeFriends(String name1, String name2){
        i=userIndex(name1);
        j=userIndex(name2);
        friends[i][j]=true;
        friends[j][i]=true;
    }
    public boolean areTheyFriends(String name1, String name2){
        i=userIndex(name1);
        j=userIndex(name2);
        return friends[i][j];
    }
    private int userIndex(String search){
        /*
        for(int p = 0;p<amountOfUsers;++p){
            if (search==users[p]){
                return p;
            }
        }
        return -1;
        */
        upper=amountOfUsers;
        lower=0;
        while (upper>=lower){
            half = (upper + lower) / 2;
            if (users[half].compareTo(search)>0) {
                upper=half-1;
            }
            else if(users[half].compareTo(search)<0){
                lower=half+1;
            }
            else{
                return half;
            }
            }
        return -1;



    }


}
