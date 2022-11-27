
public class PorterStemmer {
	
	String stem(String token){
        String pre_tocken = token;
        boolean step2_in_1b = false;
        if(token.endsWith("sses")){
            token = token.substring(0, token.length()-2);
        }
        else if(token.endsWith("ies")){
            token = token.substring(0, token.length()-2);
        }
        else if(token.endsWith("ss")){
            token = token;
        }
        else if(token.endsWith("s")){
            token = token.substring(0, token.length()-1);
        }
        else if(token.endsWith("eed")){
            token = token.substring(0, token.length()-1);
        }
        else if(token.endsWith("ed")){
            token = token.substring(0, token.length()-2);
            step2_in_1b = true;
        }
        else if(token.endsWith("ing")){
            token = token.substring(0, token.length()-3);
            step2_in_1b = true;
        }

        if(step2_in_1b){
            if(token.endsWith("at")){
                token = token + 'e';
            }
            else if(token.endsWith("bl")){
                token = token + 'e';
            }
            else if(token.endsWith("iz")){
                token = token + 'e';
            }
            else if(token.endsWith("s")){
                token = token.substring(0, token.length()-1);
            }
            else if(token.endsWith("eed")){
                token = token.substring(0, token.length()-1);
            }
        }

        if(!pre_tocken.equals(token)){
            System.out.println("Porter stemmer convert '" + pre_tocken + "' to '" + token + "'");
        }

        return token;
    }

}
