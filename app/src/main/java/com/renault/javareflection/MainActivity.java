package com.renault.javareflection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        invokeGenericRequest(UserModel.class.getName());
    }
    /**
     * We can dynamically access the class and variable
     * declared from same application and
     * also supported application */
    public void invokeGenericRequest(String  className){
        try {
            Class classToInvestigate = Class.forName(className);
            Field[] fields = classToInvestigate.getDeclaredFields();
            for(Field field:fields){
                Log.e(MainActivity.class.getName(),field.getName());
            }
            Method[] aClassMethods = classToInvestigate.getDeclaredMethods();
            for(Method method : aClassMethods)
            {
                if(method.getName().startsWith("set")){
                    Log.e(MainActivity.class.getName(),method.getName());
                }
            }
        } catch (ClassNotFoundException e) {
            // Class not found
        } catch (SecurityException e) {
            // Access denied!
        } catch (Exception e) {
            // Unknown exception
        }
    }
}
