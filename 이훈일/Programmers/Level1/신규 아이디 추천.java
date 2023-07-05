class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]" , "");
        new_id = new_id.replaceAll("\\.+",".");

        if(new_id.length() != 0){
            if(new_id.charAt(0) == '.'){
            new_id = new_id.substring(1,new_id.length());
            }
        }
        if(new_id.length() != 0){
            if(new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0,new_id.length()-1);
            }
        }

        if(new_id.length() == 0){
            new_id += "a";
        }
        System.out.println(new_id);

        if(new_id.length() > 15){
            new_id = new_id.substring(0, 15);
        }
        System.out.println(new_id);


        if(new_id.length() != 0){
            if(new_id.charAt(0) == '.'){
            new_id = new_id.substring(1,new_id.length());
            }
        }
        if(new_id.length() != 0){
            if(new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0,new_id.length()-1);
            }
        }

        if(new_id.length() < 3){
            new_id += String.valueOf(new_id.charAt(new_id.length()-1)).repeat(3 - new_id.length());
        }
        return new_id;
    }
}
