package mx.global.denodocsvtools;

import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.binary.StringUtils;
public class EncodeStringExample {

	public static void main(String[] args) {
        
        String var1 = "Cyntia";
        String var2 = new String(" is my daughter!");

        System.out.println(var1 + " \u263A" + var2);

        //printing heart using unicode
        System.out.println("Hello World \u2665  \u00D1\u00D1 \u00C3 \u2018");
        	
        
        String a ="CEDEÃ‘O MEDI";
        System.out.println(a.replace("\u00C3\u2018","\u00D1"));
        System.out.println(a.replace("\u00C3\u2018","N"));
    }
}
