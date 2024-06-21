public class Encryption {

    private static String encrypt(double valueB, double valueF){
        if (valueF == 0 || valueB == valueF){
            if(Math.sqrt(valueB) == (int)Math.sqrt(valueB)){
                return (Math.sqrt(valueB) * Math.PI) + "-0";
            }
            return ((Math.sqrt(valueB)+0.001) * Math.PI) + "-0";
        }
        double temp = (Math.sqrt(valueB) * Math.PI);
        if (Math.pow(Math.sqrt(temp/Math.PI), 2) != valueB){
            valueB = (Math.sqrt(valueB) * Math.PI)+0.001;
        }else{
            valueB = (Math.sqrt(valueB) * Math.PI);
        }
        temp = (Math.sqrt(valueF) * Math.PI);
        if (Math.pow(Math.sqrt(temp/Math.PI), 2) != valueF){
            valueF = (Math.sqrt(valueF) * Math.PI)+0.001;
        }else {
            valueF = (Math.sqrt(valueF) * Math.PI);
        }

        double med = valueB - valueF;
        if (med < 0){
            med *= -1;
        }
        return (valueB + valueF)+"-"+med;
    }

    private static int dCrypt(String value){
        StringBuilder valueOne = new StringBuilder();
        StringBuilder valueTow = new StringBuilder();
        boolean flag = false;
        for (char index: value.toCharArray()){
            if (index == '-')
                flag = !flag;
            if (flag && index != '-')
                valueTow.append(index);
            else if(index != '-'){
                valueOne.append(index);
            }
        }
        double n = Double.parseDouble(String.valueOf(valueOne));
        if(valueTow.toString().equals("0")){
            return (int)(Math.pow((n/Math.PI), 2));
        }
        double m = Double.parseDouble(String.valueOf(valueTow));
        n = (n - m)/2;
        m = (n + m);
        m  = (Math.pow((m/Math.PI), 2));
        n = (Math.pow((n/Math.PI), 2));

        return (int)(n+m);
    }

    public static String divider(String value){
       int state = Integer.parseInt(value);
       int back = Integer.parseInt(String.valueOf(new StringBuilder(String.valueOf(state)).reverse()));
       if(state - back == 0 || state - back < 0 || back < 10){
           if (state % 2 == 0)
               encrypt(state , 0);
           return encrypt(state , 0);
       }
       return encrypt(back , (state - back));
    }

    public static String login(String value, boolean mode){
        if(mode){
            return String.valueOf(dCrypt(value));
        }else {
            return divider(value);
        }
    }
}
