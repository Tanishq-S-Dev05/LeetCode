class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> time = new ArrayList<>();
        for(int h =0; h<=11; h++){
            for(int m =0;m<=59;m++){
                if(bitcount(h) + bitcount(m) == turnedOn){
                    time.add(formatted(h,m));
                }
            }
        }
        return time;
    }

    public int bitcount(int value){
          return Integer.bitCount(value);
    }

    public String formatted(int h,int m){
        String formatedTime = h + ":";
        if(m<10){
            formatedTime += "0";
        }
        formatedTime += m;
        return formatedTime;
    }

}