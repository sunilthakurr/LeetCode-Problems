class Solution {
    public String defangIPaddr(String address) {
        if(address.length() == 0)
            return address;
        if(address.charAt(0) == '.'){
            return "[.]" + defangIPaddr(address.substring(1));
        }
        return String.valueOf(address.charAt(0)) + defangIPaddr(address.substring(1));
        
    }
}