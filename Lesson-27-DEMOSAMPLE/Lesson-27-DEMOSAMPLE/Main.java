class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){

   print(switching("THE SAMPLE"));
   
   print(decrypt("HETSA PLME"));

  String msg ="HETSA PLME";
  
  print(encode(msg));

  String msg1="IFUTB!QMNF";
  print(decode(msg1));

  

    // This example we are substituting all lower case 
    // letters to another lower case letter.
    char[] letter1 = new char[5];
    letter1[0] = 'I';
    letter1[1] = 'U';
    letter1[2] = 'B';
    letter1[3] = 'Q';
    letter1[4] = 'N';

    char[] letter2 = new char[5];
    letter2[0] = '\u3127';  //ㄧ for letter I
    letter2[1] = '\u3128';  // ㄨ for letter U
    letter2[2] = '\u3105';  // ㄅ for letter B
    letter2[3] = '\u3111';  // ㄑ for letter Q
    letter2[4] = '\u310B';  // ㄋ for letter N

    
    // Encoding message
    String file = Input.readFile("test.txt");

    //substituion
    String encodedMsg1 = subEncryption(file,letter1,letter2);
    //Input.writeFile("Encode1.txt",encodedMsg1);

    // caesar cipher
    String encodedMsg2 = encode(encodedMsg1);
    //Input.writeFile("Encode2.txt",encodedMsg2);

    // reverse
    String encodedMsg3 = switching(encodedMsg2);
    Input.writeFile("Encode3.txt",encodedMsg3);

    
    // decoding message
    String file2 = Input.readFile("Encode1.txt");
    
    String decodedMsg1 = switching(file2);
    //Input.writeFile("Decode1.txt", decodedMsg1);
    
    String decodedMsg2 = decode(decodedMsg1);
    //Input.writeFile("Decode2.txt", decodedMsg2);
    
     String decodedMsg3 = subEncryption(decodedMsg2, letter2, letter1);
    //Input.writeFile("Decode1.txt", decodedMsg3);
    
    
  }
  // Level 1 swap string
  String switching(String txt){
    String bld ="";
    for(int x=0; x<=txt.length()-3; x+=3){
    bld+=txt.substring(x+1,x+3)+ txt.substring(x,x+1);
    }
  if(txt.length()%3==1){
    bld+= txt.substring(txt.length()-1);
  }
  return bld;
  }

    
    
  
    
    
  
  // Level 1 decrypt 
String decrypt(String txt){
  String bld="";
  for(int x=0; x<=txt.length()-3; x+=3){
  bld+=txt.substring(x+2,x+3)+ txt.substring(x,x+2);
}
 if(txt.length()%3==1){
    bld+= txt.substring(txt.length()-1);
  }
  return bld;
  }

  
  //Level 2 Cipher encoding with no wrapping
  String encode(String txt){
    String bld="";
    char ch = ' ';
    int ascii =0;
  for( int x=0; x<=txt.length()-1; x++){
   ch = txt.charAt(x);
    ascii = (int) ch;
    ascii++;
    ch = (char) ascii;
    bld+= ch;
  }
    return bld;
  }

  
  String decode(String txt){
    String bld="";
    char ch = ' ';
    int ascii =0;
  for( int x=0; x<=txt.length()-1; x++){
   ch = txt.charAt(x);
    ascii = (int) ch;
    ascii--;
    ch = (char) ascii;
    bld+= ch;
  }
    return bld;
  }

  // Level 3 Substituion encoding
  String subEncryption(String f, char[] letter1, char[] letter2){
    String bld="";
    char ch =' ';
    int index = 0;
    for(int x=0; x<=f.length()-1; x++){
      ch = f.charAt(x);
      index = indexOf(ch, letter1);
      if( index !=-1){
        bld+= letter2[index];
      }
      else{
        bld+=ch;
      }
    } 
    return bld;
  }

  
  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }

}